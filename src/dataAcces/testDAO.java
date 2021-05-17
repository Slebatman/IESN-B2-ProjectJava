package dataAcces;

import business.CollectiveManager;
import business.OneObjectManager;
import business.RentalManager;
import business.ResearchManager;
import business.TypeOfProblemRentalManager;
import model.ThirdResearch;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class testDAO {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();
        RentalManager rentalManager = new RentalManager();
        ResearchManager researchManager = new ResearchManager();
        TypeOfProblemRentalManager typeOfProblemRentalManager = new TypeOfProblemRentalManager();

        try {
            GregorianCalendar date1 = new GregorianCalendar(2020,12,01);
            GregorianCalendar date2 = new GregorianCalendar(2021,12,01);

            ArrayList<ThirdResearch> listArray;
            listArray = researchManager.getRentalBetween2Dates(date1, date2);

            for(ThirdResearch r : listArray) {
                System.out.println(r);
            }
        }
        catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
