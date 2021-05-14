package dataAcces;

import dataAcces.dao.IProblemExitRental;
import dataAcces.dao.IRentalDAO;
import type.FirstResearch;
import type.ProblemExitRental;
import type.Rental;
import type.SecondResearch;

import java.util.ArrayList;

public class ResearchManager {
    private IRentalDAO daoRental;
    private IProblemExitRental daoProblemExitRental;

    public ResearchManager() {
        this.daoRental = new RentalDB();
        this.daoProblemExitRental = new ProblemExitRentalDB();
    }

    // First research
    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category) {

        ArrayList<Rental> rentalResultResearch = daoRental.rentalsForOneCollectiveCategory(category);
        ArrayList<FirstResearch> rentalsConverted = new ArrayList<>();

        for (Rental rental : rentalResultResearch) {
            FirstResearch result = new FirstResearch(rental);
            rentalsConverted.add(result);
        }

        return rentalsConverted;
    }

    // Second research
    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) {
        ArrayList<ProblemExitRental> problemExitRentals = daoProblemExitRental.getProblemExitRentalBasedTypeProblem(idTypeOfProblemRental);
        ArrayList<SecondResearch> problemExitRentalConverted = new ArrayList<>();

        for(ProblemExitRental p : problemExitRentals) {
            SecondResearch result = new SecondResearch(p);
            problemExitRentalConverted.add(result);
        }

        return problemExitRentalConverted;
    }
}
