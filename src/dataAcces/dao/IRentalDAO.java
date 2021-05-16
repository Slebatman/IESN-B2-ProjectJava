package dataAcces.dao;

import Model.Rental;
import Model.ThirdResearch;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface IRentalDAO {
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category);
    Rental getOneRentalBasedID(int idRental);
    ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate);
}
