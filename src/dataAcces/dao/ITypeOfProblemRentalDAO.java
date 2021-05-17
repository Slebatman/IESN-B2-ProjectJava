package dataAcces.dao;

import dataAcces.exception.DAOException;

import java.util.ArrayList;

public interface ITypeOfProblemRentalDAO {
    int selectIdBaseName(String nameProblem) throws DAOException;
    ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental() throws DAOException;
}
