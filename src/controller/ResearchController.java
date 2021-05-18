package controller;

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
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException {
        return manager.getRentalsForOneCollectiveCategory(category);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> getProblemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException {
        return manager.getProblemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
