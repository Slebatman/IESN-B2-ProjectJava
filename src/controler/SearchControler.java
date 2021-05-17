package controler;

import Model.FirstResearch;
import Model.SecondResearch;
import Model.ThirdResearch;
import dataAcces.ResearchManager;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchControler {
    private ResearchManager manager;

    public SearchControler(){
        manager = new ResearchManager();
    }

    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category) throws DAOConfigurationException {
        return manager.rentalsForOneCollectiveCategory(category);
    }

    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOConfigurationException {
        return manager.problemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOConfigurationException {
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
