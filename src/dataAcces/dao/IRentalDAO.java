package dataAcces.dao;

import model.Rental;
import model.ThirdResearch;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IRentalDAO {

    // All rentals for a category of collectives
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category) throws DAOException;

    // Recovering a location based on its ID
    Rental getOneRentalBasedID(int idRental) throws DAOException;

    // All rentals between 2 dates
    ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException;
}
