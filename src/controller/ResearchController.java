package controller;

import model.FirstResearch;
import model.SecondResearch;
import model.ThirdResearch;
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
    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category) throws DAOException {
        return manager.getRentalsForOneCollectiveCategory(category);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException {
        return manager.getProblemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
