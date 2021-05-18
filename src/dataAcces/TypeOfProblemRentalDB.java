package dataAcces;

import dataAcces.dao.ITypeOfProblemRentalDAO;
import exception.DAOException;
import model.TypeOfProblemRental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeOfProblemRentalDB implements ITypeOfProblemRentalDAO {
    // Data base access
    Connection connexion = SingletonConnexion.getConnection();

    // Generic function who return one TypeOfProblemRental object
    private TypeOfProblemRental selectOneTypeOfProblemRental(PreparedStatement statement) throws SQLException {
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            return sqlToJavaObject(data);
        }
        return null;
    }

    // [IMPLEMENT] Select id of a problem base on its name
    @Override
    public int getIdBaseName(String nameProblem) throws DAOException {
        try {
            String sql = "SELECT * FROM typeofproblemrental WHERE name = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, nameProblem);
            return selectOneTypeOfProblemRental(statement).getIdTypeOfProblemRental();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer de l'id du probleme avec comme critère de recherche : " + nameProblem);
        }
    }

    // [IMPLEMENT] Select DISTINCT name of typeOfProblemExitLocation
    @Override
    public ArrayList<String> getDistinctNameOfTypeOfProblemExitRental() throws DAOException {
        ArrayList<String> distinctNameOfTypeOfExitRental = new ArrayList<>();

        try {
            String sql = "SELECT DISTINCT name FROM typeOfProblemRental";
            PreparedStatement statement = connexion.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                distinctNameOfTypeOfExitRental.add(data.getString("name"));
            }

            return distinctNameOfTypeOfExitRental;

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer de manière distincte les noms de typeOfProblemExitLocation");
        }
    }

    // Convert sql info to java object TypeOfProblemRental
    private TypeOfProblemRental sqlToJavaObject(ResultSet data) throws SQLException {
        return new TypeOfProblemRental(
                data.getInt("idtypeofproblemrental"),
                data.getString("name"),
                data.getString("description")
        );
    }
}
