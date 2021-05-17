package dataAcces.dao;

import Model.ProblemExitRental;
import dataAcces.exception.DAOException;

import java.util.ArrayList;

public interface IProblemExitRental {
    ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental) throws DAOException;
}
