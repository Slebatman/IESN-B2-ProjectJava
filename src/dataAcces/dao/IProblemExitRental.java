package dataAcces.dao;

import model.ProblemExitRental;
import exception.DAOException;

import java.util.ArrayList;

public interface IProblemExitRental {
    ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental) throws DAOException;
}
