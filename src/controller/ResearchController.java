package controller;

import exception.BusinessException;
import exception.ControllerException;
import exception.ModelException;
import model.research.FirstResearch;
import model.research.SecondResearch;
import model.research.ThirdResearch;
import business.ResearchManager;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResearchController {
    // Variable
    private ResearchManager manager;

    // Constructor
    public ResearchController(){
        setManager(new ResearchManager());
    }

    // Setter
    private void setManager(ResearchManager manager) {
        this.manager = manager;
    }

    // (Research n°1) All rentals for a category of collectives
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException, BusinessException, ControllerException {
        if (category.equals("")) throw new ControllerException("Erreur : la categorie ne peut pas être une chaine vide");
        return manager.getRentalsForOneCollectiveCategory(category);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> getProblemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException, ModelException, BusinessException, ControllerException {
        if (idTypeOfProblemRental < 1) throw new ControllerException("Erreur : l'identifiant doit être suppérieur à 0");
        return manager.getProblemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException, BusinessException, ControllerException {
        if (secondDate.compareTo(firstDate) != 1) throw new ControllerException("La date de retour doit être plus recente ou égale à la date de départ");
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
