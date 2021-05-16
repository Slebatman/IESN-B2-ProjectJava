package dataAcces.dao;

import Model.Rental;

import java.util.ArrayList;

public interface IRentalDAO {
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category);
    Rental getOneRentalBasedID(int idRental);
}
