package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
import exception.BusinessException;
import exception.DAOException;
import exception.ModelException;
import model.research.FirstResearch;
import model.research.SecondResearch;
import model.research.ThirdResearch;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResearchManager {
    // Variables
    private IRentalDAO dao;

    // Constructor
    public ResearchManager() {
        setDao(new RentalDB());
    }

    // Setters
    private void setDao(IRentalDAO dao) {
        this.dao = dao;
    }

    // (Research n°1) All rentals for a category of collectives
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException, BusinessException {
        if (category.equals("")) throw new BusinessException("Erreur : la categorie ne peut-être une chaine vide");
        return dao.getRentalsForOneCollectiveCategory(category);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> getProblemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException, ModelException, BusinessException {
        if (idTypeOfProblemRental < 1) throw new BusinessException("Erreur : l'identifiant doit être suppérieur à 0");
        return dao.getRentalsBasedOnSameTypeReturnProblem(idTypeOfProblemRental);
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException, BusinessException {
        if (secondDate.compareTo(firstDate) != 1) throw new BusinessException("La date de retour doit être plus recente ou égale à la date de départ");
        return dao.getRentalBetween2Dates(firstDate, secondDate);
    }
}
