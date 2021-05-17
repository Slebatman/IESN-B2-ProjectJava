package dataAcces.dao;

import model.ProblemExitRental;
import exception.DAOException;

import java.util.ArrayList;

public interface IProblemExitRental {

    // Select all ProblemExitRental based on a TypeOfExitRental
    ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental) throws DAOException;
}
