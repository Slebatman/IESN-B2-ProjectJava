package dataAcces.dao;

import Model.ProblemExitRental;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public interface IProblemExitRental {
    ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental) throws DAOConfigurationException;
}
