package business;

import dataAcces.ProblemExitRentalDB;
import dataAcces.RentalDB;
import model.*;
import dataAcces.dao.IProblemExitRental;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResearchManager {
    // Variables
    private IRentalDAO daoRental;
    private IProblemExitRental daoProblemExitRental;

    // Constructor
    public ResearchManager() {
        setDaoRental(new RentalDB());
        setDaoProblemExitRental(new ProblemExitRentalDB());
    }

    // Setters
    private void setDaoRental(IRentalDAO daoRental) {
        this.daoRental = daoRental;
    }

    private void setDaoProblemExitRental(IProblemExitRental daoProblemExitRental) {
        this.daoProblemExitRental = daoProblemExitRental;
    }

    // (Research n°1) All rentals for a category of collectives
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException {

        ArrayList<Rental> rentalResultResearch = daoRental.getRentalsForOneCollectiveCategory(category);
        ArrayList<FirstResearch> rentalsConverted = new ArrayList<>();

        for (Rental rental : rentalResultResearch) {
            FirstResearch result = new FirstResearch(rental);
            rentalsConverted.add(result);
        }

        return rentalsConverted;
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    public ArrayList<SecondResearch> getProblemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException {
        ArrayList<ProblemExitRental> problemExitRentals = daoProblemExitRental.getProblemExitRentalBasedTypeProblem(idTypeOfProblemRental);
        ArrayList<SecondResearch> problemExitRentalConverted = new ArrayList<>();

        for(ProblemExitRental p : problemExitRentals) {
            problemExitRentalConverted.add(new SecondResearch(p));
        }

        return problemExitRentalConverted;
    }

    // (Research n°3) All rentals between 2 dates
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        return daoRental.getRentalBetween2Dates(firstDate, secondDate);
    }
}
