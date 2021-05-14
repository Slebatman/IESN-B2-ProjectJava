package dataAcces;

import dataAcces.exception.DAOConfigurationException;
import type.FirstResearch;
import type.Rental;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();
        RentalManager rentalManager = new RentalManager();
        ResearchManager researchManager = new ResearchManager();

        try {
            ArrayList<FirstResearch> listArray;
            listArray = researchManager.rentalsForOneCollectiveCategory("Cercle");

            for(FirstResearch fr : listArray) {
                System.out.println(fr);
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
