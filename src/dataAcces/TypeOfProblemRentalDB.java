package dataAcces;

import dataAcces.dao.ITypeOfProblemRentalDAO;
import dataAcces.exception.DAOConfigurationException;
import Model.TypeOfProblemRental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeOfProblemRentalDB implements ITypeOfProblemRentalDAO {
    // Connection to the data base
    Connection connexion = SingletonConnexion.getConnection();

    // Generic function who return one TypeOfProblemRental object
    private TypeOfProblemRental selectOneTypeOfProblemRental(PreparedStatement statement) throws SQLException {
        TypeOfProblemRental typeOfProblemRental = null;
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            typeOfProblemRental = sqlTypeOfPbToJavaObject(data);
        }
        return typeOfProblemRental;
    }

    // Select id of a problem base on its name
    @Override
    public int selectIdBaseName(String nameProblem) {
        try {
            String sql = "SELECT * FROM typeofproblemrental WHERE name = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, nameProblem);

            return selectOneTypeOfProblemRental(statement).getIdTypeOfProblemRental();

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL lors de la récuperation de l'id du probleme avec comme critère de recherche : " + nameProblem);
        }
    }

    // Select DISTINCT name of typeOfProblemExitLocation
    @Override
    public ArrayList<String> selectDistinctNameOfTypeOfProblemExitRental() {
        ArrayList<String> distinctNameOfTypeOfExitRental = new ArrayList<>();

        try {
            String sql = "SELECT DISTINCT name FROM typeOfProblemRental";
            PreparedStatement statement = connexion.prepareStatement(sql);

            ResultSet data = statement.executeQuery();

            while (data.next()) {
                distinctNameOfTypeOfExitRental.add(data.getString("name"));
            }
        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL : impossible de récuperer de manière distincte les noms de typeOfProblemExitLocation");
        }

        return distinctNameOfTypeOfExitRental;
    }

    // Convert sql info to java object TypeOfProblemRental
    private TypeOfProblemRental  sqlTypeOfPbToJavaObject(ResultSet data) throws SQLException {
        return new TypeOfProblemRental(
                data.getInt("idtypeofproblemrental"),
                data.getString("name"),
                data.getString("description")
        );
    }
}
