package dataAcces;

import dataAcces.dao.IRentalDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Rental;

import java.util.ArrayList;

public class RentalManager {
    private final IRentalDAO dao;

    public RentalManager() {
        this.dao = new RentalDB();
    }

    // Getting rentals for a category
    public ArrayList<Rental> getRentalsForOneCollectiveCategory(String category) throws DAOConfigurationException {
        return dao.rentalsForOneCollectiveCategory(category);
    }

    // Getting rentals base on a ID
    public Rental getRentalBasedID(int idRental) {
        return dao.getOneRentalBasedID(idRental);
    }
}
