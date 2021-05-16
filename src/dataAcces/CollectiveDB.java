package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import dataAcces.exception.DAOConfigurationException;
import Model.Collective;

import java.sql.*;
import java.util.ArrayList;

public class CollectiveDB implements ICollectiveDAO {
    // DB Access
    private final Connection connection = SingletonConnexion.getConnection();

    // [IMPLEMENT] Insert
    @Override
    public void insert(Collective c) throws DAOConfigurationException {
        try {
            String sql = "INSERT INTO collective (name, category, physicalAdress, emailAdress) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2,c.getCategory());
            statement.setString(3,c.getPhysicalAddress());
            statement.setString(4,c.getEmailAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    // [IMPLEMENT] Update
    @Override
    public void update(Collective c) throws DAOConfigurationException {
        try {
            String sql = "UPDATE collective SET name = ?, category = ?, physicalAddress = ?, emailAddress = ? where idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2,c.getCategory());
            statement.setString(3,c.getPhysicalAddress());
            statement.setString(4,c.getEmailAddress());
            statement.setInt(5,c.getIdCollective());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    // [IMPLEMENT] Delete
    @Override
    public void delete(int idCollective) throws DAOConfigurationException {
        try {
            String sql = "DELETE FROM collective WHERE idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la tentative de suppression");
        }
    }

    // Generic function to select several collective
    public ArrayList<Collective> selectListOfCollective(PreparedStatement statement) throws SQLException {
        ResultSet data;
        ArrayList<Collective> listOfCollective = new ArrayList<>();

        data = statement.executeQuery();

        while(data.next()) {
            Collective collective = this.convertToCollective(data);
            listOfCollective.add(collective);
        }

        return listOfCollective;
    }

    // Generic function to select one collective
    public Collective selectACollective(PreparedStatement statement) throws SQLException {
        ResultSet data;
        data = statement.executeQuery();
        Collective collective = null;

        while(data.next()) {
            collective = this.convertToCollective(data);
        }

        return collective;
    }

    // [IMPLEMENT] Get all collective
    @Override
    public ArrayList<Collective> getAllCollective() throws DAOConfigurationException {

        try {
            // SQL statement
            String sql = "SELECT * FROM collective";
            PreparedStatement statement = connection.prepareStatement(sql);

            return selectListOfCollective(statement);

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération de l'ensemble des collectifs");
        }
    }

    // [IMPLEMENT] Search for a collective based on its id
    @Override
    public Collective getACollectiveBasedId(int idCollective) throws DAOConfigurationException {

        try {
            String sql = "SELECT * FROM collective WHERE idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);

            return selectACollective(statement);

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur. Soit le collectif n'a pas été trouvé en base de donnée, soit une erreur SQL a eu lieu.");
        }
    }

    // [IMPLEMENT] Retrieving a collective's ID based on its name
    @Override
    public int getACollectiveIDBasedName(String name) throws DAOConfigurationException {
        try {
            String sql = "SELECT * FROM collective WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            return selectACollective(statement).getIdCollective();

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL lors de la recherche d'un collectif sur base de son nom");
        }
    }

    // [IMPLEMENT] Separately retrieve the category of Collective
    @Override
    public ArrayList<String> getDistinctCategoryCollective() {
        ArrayList<String> distinctNameCollective = new ArrayList<>();

        try {
            String sql = "SELECT DISTINCT category FROM collective";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet data = statement.executeQuery();

            while (data.next()) {
                distinctNameCollective.add(data.getString("category"));
            }

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL : impossible de récuperer les categories distinctes de la table collective");
        }

        return distinctNameCollective;
    }

    // Function convert sql to java object Collective
    public Collective convertToCollective(ResultSet data) throws SQLException {
        Collective collective = null;

        collective = new Collective(
                data.getInt("idCollective"),
                data.getString("name"),
                data.getString("category"),
                data.getString("physicalAddress"),
                data.getString("emailAddress"));

        return collective;
    }
}
