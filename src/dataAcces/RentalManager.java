package dataAcces;

import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import Model.Rental;

import java.util.ArrayList;

public class RentalManager {
    private final IRentalDAO dao;

    public RentalManager() {
        this.dao = new RentalDB();
    }

    // Getting rentals for a category
    public ArrayList<Rental> getRentalsForOneCollectiveCategory(String category) throws DAOException {
        return dao.rentalsForOneCollectiveCategory(category);
    }

    // Getting rentals base on a ID
    public Rental getRentalBasedID(int idRental) throws DAOException {
        return dao.getOneRentalBasedID(idRental);
    }
}
