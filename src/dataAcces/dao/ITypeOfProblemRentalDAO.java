package dataAcces.dao;

import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public interface ITypeOfProblemRentalDAO {
    int selectIdBaseName(String nameProblem) throws DAOConfigurationException;
    ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental() throws DAOConfigurationException;
}
