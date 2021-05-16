package controler;

import Model.FirstResearch;
import Model.SecondResearch;
import Model.ThirdResearch;
import dataAcces.ResearchManager;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchControler {
    private ResearchManager manager;

    public SearchControler(){
        manager = new ResearchManager();
    }

    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category){
        return manager.rentalsForOneCollectiveCategory(category);
    }

    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental){
        return manager.problemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate){
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
