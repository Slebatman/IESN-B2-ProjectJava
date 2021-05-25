package controller;

import business.TypeOfProblemRentalManager;
import exception.DAOException;

import java.util.ArrayList;

public class TypeOfProblemRentalController {
    // Variable
    private TypeOfProblemRentalManager manager;

    // Constructor
    public TypeOfProblemRentalController() {
        manager = new TypeOfProblemRentalManager();
    }

    // Get distinct name of typeOfProblemExitRental
    public ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException {
        return manager.getDistinctNameOfTypeOfProblemExitRental();
    }
}
