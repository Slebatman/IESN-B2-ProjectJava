package dataAcces;

import dataAcces.exception.DAOConfigurationException;
import type.FirstResearch;
import type.Rental;
import type.SecondResearch;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();
        RentalManager rentalManager = new RentalManager();
        ResearchManager researchManager = new ResearchManager();
        TypeOfProblemRentalManager typeOfProblemRentalManager = new TypeOfProblemRentalManager();

        try {
            ArrayList<String> listArray;
            listArray = collectiveManager.getDistinctCategoryCollective();

            for(String s : listArray) {
                System.out.println(s);
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
