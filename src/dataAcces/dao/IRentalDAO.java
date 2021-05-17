package dataAcces.dao;

import Model.Rental;
import Model.ThirdResearch;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IRentalDAO {
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category) throws DAOConfigurationException;
    Rental getOneRentalBasedID(int idRental) throws DAOConfigurationException;
    ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOConfigurationException;
}
