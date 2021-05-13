package dataAcces;

import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;
import type.Rental;

import java.sql.Types;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();
        RentalManager rentalManager = new RentalManager();

        try {
            ArrayList<Rental> listArray;
            listArray = rentalManager.getRentalsForOneCollectiveCategory("KàP");

            for(Rental r : listArray) {
                System.out.println(r.getRentalManager());
            }

            FirstResearchManager firstResearchManager = new FirstResearchManager(listArray.get(0));
            System.out.println(firstResearchManager);
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
