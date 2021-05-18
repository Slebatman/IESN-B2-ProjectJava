package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
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
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException {
        return dao.getRentalsForOneCollectiveCategory(category);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> getProblemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException, ModelException {
        return dao.getRentalsBasedOnSameTypeReturnProblem(idTypeOfProblemRental);
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException {
        return dao.getRentalBetween2Dates(firstDate, secondDate);
    }
}
