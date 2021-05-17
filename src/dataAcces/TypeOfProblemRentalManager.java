package dataAcces;

import dataAcces.dao.ITypeOfProblemRentalDAO;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public class TypeOfProblemRentalManager {
    private ITypeOfProblemRentalDAO dao;

    public TypeOfProblemRentalManager() {
        this.dao = new TypeOfProblemRentalDB();
    }

    // Separately retrieve the names of typeOfProblemExitRental
    public ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental() throws DAOConfigurationException {
        return dao.selectDistinctNameOfTypeOfProblemExitRental();
    }
}
