package dataAcces.dao;

import type.Rental;

import java.util.ArrayList;

public interface IRentalDAO {
    ArrayList<Rental> rentalsForOneCollectiveCategory(String category);
    Rental getOneRentalBasedID(int idRental);
}
