package dataAcces;

import Model.*;
import dataAcces.dao.IProblemExitRental;
import dataAcces.dao.IRentalDAO;
import dataAcces.exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ResearchManager {
    private IRentalDAO daoRental;
    private IProblemExitRental daoProblemExitRental;

    public ResearchManager() {
        this.daoRental = new RentalDB();
        this.daoProblemExitRental = new ProblemExitRentalDB();
    }

    // First research
    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category) throws DAOException {

        ArrayList<Rental> rentalResultResearch = daoRental.rentalsForOneCollectiveCategory(category);
        ArrayList<FirstResearch> rentalsConverted = new ArrayList<>();

        for (Rental rental : rentalResultResearch) {
            FirstResearch result = new FirstResearch(rental);
            rentalsConverted.add(result);
        }

        return rentalsConverted;
    }

    // Second research
    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException {
        ArrayList<ProblemExitRental> problemExitRentals = daoProblemExitRental.getProblemExitRentalBasedTypeProblem(idTypeOfProblemRental);
        ArrayList<SecondResearch> problemExitRentalConverted = new ArrayList<>();

        for(ProblemExitRental p : problemExitRentals) {
            SecondResearch result = new SecondResearch(p);
            problemExitRentalConverted.add(result);
        }

        return problemExitRentalConverted;
    }

    // Third research
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        return daoRental.getRentalBetween2Dates(firstDate, secondDate);
    }
}
