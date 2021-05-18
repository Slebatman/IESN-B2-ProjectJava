package dataAcces.dao;

import exception.DAOException;
import exception.ModelException;

import java.util.ArrayList;

public interface ITypeOfProblemRentalDAO {

    // Select id of a problem base on its name
    int getIdBaseName(String nameProblem) throws DAOException, ModelException;

    // Select DISTINCT name of typeOfProblemExitLocation
    ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException;
}
