package dataAcces.dao;

import model.FirstResearch;
import model.Rental;
import model.SecondResearch;
import model.ThirdResearch;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IRentalDAO {

    // (Research n°1) All rentals for a category of collectives
    ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException;

    // (Research n°2) List all rentals that have had the same type of return problem
    public ArrayList<SecondResearch> getRentalsBasedOnSameTypeReturnProblem(int idTypeOfProblemExitProblemRental) throws DAOException;

    // (Research n°3) All rentals between 2 dates
    ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException;

    // Recovering a location based on its ID
    Rental getOneRentalBasedID(int idRental) throws DAOException;

}
