package dataAcces;

import dataAcces.dao.IProblemExitRental;
import dataAcces.exception.DAOConfigurationException;
import Model.ProblemExitRental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemExitRentalDB implements IProblemExitRental {
    // Date base connection
    Connection connection = SingletonConnexion.getConnection();

    // Generic function who select a list of ProblemExitLocation
    private ArrayList<ProblemExitRental> selectListOfProblemExitRental(PreparedStatement statement) throws SQLException {
        ArrayList<ProblemExitRental> listOfProblemExitRental = new ArrayList<>();
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            ProblemExitRental problemExitRental = convertSqlToJava(data);
            listOfProblemExitRental.add(problemExitRental);
        }

        return listOfProblemExitRental;
    }

    // Select all ProblemExitRental based on a TypeOfExitRental
    @Override
    public ArrayList<ProblemExitRental> getProblemExitRentalBasedTypeProblem(int idTypeOfProblemRental) {
        try {
            String sql = "SELECT * FROM problemexitrental WHERE idproblemExitLocation = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idTypeOfProblemRental);

            return selectListOfProblemExitRental(statement);

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL lors de la récuparation des locations qui ont rencontré un problème d'id : " + idTypeOfProblemRental);
        }
    }

    // Convert sql data to Java ProblemExitRental Object
    private ProblemExitRental convertSqlToJava(ResultSet data) throws SQLException {
        return new ProblemExitRental(
                data.getInt("idproblemExitLocation"),
                data.getInt("idRental"),
                data.getInt("idTypeOfProblemRental"),
                data.getDouble("invocedPrice"),
                data.getString("note")
        );
    }
}
