package controler;

import model.FirstResearch;
import model.SecondResearch;
import model.ThirdResearch;
import business.ResearchManager;
import exception.DAOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchControler {
    private ResearchManager manager;

    public SearchControler(){
        manager = new ResearchManager();
    }

    public ArrayList<FirstResearch> rentalsForOneCollectiveCategory(String category) throws DAOException {
        return manager.rentalsForOneCollectiveCategory(category);
    }

    public ArrayList<SecondResearch> problemRentalBasedOnTypeOfProblem(int idTypeOfProblemRental) throws DAOException {
        return manager.problemRentalBasedOnTypeOfProblem(idTypeOfProblemRental);
    }

    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        return manager.getRentalBetween2Dates(firstDate, secondDate);
    }
}
