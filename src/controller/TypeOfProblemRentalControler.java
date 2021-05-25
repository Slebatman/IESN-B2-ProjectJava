package controller;

import business.TypeOfProblemRentalManager;
import exception.DAOException;

import java.util.ArrayList;

public class TypeOfProblemRentalControler {
    private TypeOfProblemRentalManager manager;

    public TypeOfProblemRentalControler(){
        manager = new TypeOfProblemRentalManager();
    }

    public ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException {
        return manager.getDistinctNameOfTypeOfProblemExitRental();
    }
}
