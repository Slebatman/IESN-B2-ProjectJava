package dataAcces.dao;

import type.ProblemExitRental;

import java.util.ArrayList;

public interface IProblemExitRental {
    ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental);
}
