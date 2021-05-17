package dataAcces;

import business.CollectiveManager;
import business.OneObjectManager;
import business.RentalManager;
import business.ResearchManager;
import business.TypeOfProblemRentalManager;
import model.Collective;
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
            Collective collective = collectiveManager.searchACollectiveBasedId(8);
            System.out.println(collective);
        }
        catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
