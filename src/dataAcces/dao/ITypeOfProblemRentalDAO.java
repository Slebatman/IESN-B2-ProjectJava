package dataAcces.dao;

import java.util.ArrayList;

public interface ITypeOfProblemRentalDAO {
    int selectIdBaseName(String nameProblem);
    ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental();
}
