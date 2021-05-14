package dataAcces;

import dataAcces.dao.IRentalDAO;
import type.FirstResearch;
import type.Rental;

import java.util.ArrayList;

public class ResearchManager {
    private IRentalDAO daoRental;

    public ResearchManager() {
        this.daoRental = new RentalDB();
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
}
