package business;

import dataAcces.TypeOfProblemRentalDB;
import dataAcces.dao.ITypeOfProblemRentalDAO;
import exception.DAOException;

import java.util.ArrayList;

public class TypeOfProblemRentalManager {
    private ITypeOfProblemRentalDAO dao;

    public TypeOfProblemRentalManager() {
        this.dao = new TypeOfProblemRentalDB();
    }

    // Separately retrieve the names of typeOfProblemExitRental
    public ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental() throws DAOException {
        return dao.selectDistinctNameOfTypeOfProblemExitRental();
    }
}
