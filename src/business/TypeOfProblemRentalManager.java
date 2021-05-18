package business;

import dataAcces.TypeOfProblemRentalDB;
import dataAcces.dao.ITypeOfProblemRentalDAO;
import exception.DAOException;

import java.util.ArrayList;

public class TypeOfProblemRentalManager {
    // Variable
    private ITypeOfProblemRentalDAO dao;

    // Constructor
    public TypeOfProblemRentalManager() {
        setDao(new TypeOfProblemRentalDB());
    }

    // Setter
    private void setDao(ITypeOfProblemRentalDAO dao) {
        this.dao = dao;
    }

    // Separately retrieve the names of typeOfProblemExitRental
    public ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException {
        return dao.getDistinctNameOfTypeOfProblemExitRental();
    }
}
