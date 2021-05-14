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

        try {
            ArrayList<SecondResearch> listArray;
            listArray = researchManager.problemRentalBasedOnTypeOfProblem(1);

            for(SecondResearch sr : listArray) {
                System.out.println(sr);
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
