package dataAcces;

import business.CollectiveManager;
import business.OneObjectManager;
import business.RentalManager;
import business.ResearchManager;
import business.TypeOfProblemRentalManager;

public class testDAO {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();
        RentalManager rentalManager = new RentalManager();
        ResearchManager researchManager = new ResearchManager();
        TypeOfProblemRentalManager typeOfProblemRentalManager = new TypeOfProblemRentalManager();
    }
}
