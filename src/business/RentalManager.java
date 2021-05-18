package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import exception.ModelException;
import model.research.FirstResearch;
import model.Rental;

import java.util.ArrayList;

public class RentalManager {
    // Variable
    private IRentalDAO dao;

    // Constructor
    public RentalManager() {
        setDao(new RentalDB());
    }

    // Setter
    private void setDao(IRentalDAO dao) {
        this.dao = dao;
    }

    // Getting rentals for a category
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException {
        return dao.getRentalsForOneCollectiveCategory(category);
    }

    // Getting rentals base on a ID
    public Rental getRentalBasedID(int idRental) throws DAOException, ModelException {
        return dao.getOneRentalBasedID(idRental);
    }
}
