package dataAcces.dao;

import exception.DAOException;

import java.util.ArrayList;

public interface ITypeOfProblemRentalDAO {

    // Select id of a problem base on its name
    int getIdBaseName(String nameProblem) throws DAOException;

    // Select DISTINCT name of typeOfProblemExitLocation
    ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException;
}
