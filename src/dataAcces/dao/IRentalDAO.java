package dataAcces.dao;

import model.Rental;
import model.ThirdResearch;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IRentalDAO {
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category) throws DAOException;
    Rental getOneRentalBasedID(int idRental) throws DAOException;
    ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException;
}
