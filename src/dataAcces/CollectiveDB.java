package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Collective;

import java.sql.*;
import java.util.ArrayList;

public class CollectiveDB implements ICollectiveDAO {
    // DB Access
    private final Connection connection = SingletonConnexion.getConnection();

    // Insert
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

    // Update
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

    // Delete
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

    // Get all collective
    @Override
    public ArrayList<Collective> getAllCollective() throws DAOConfigurationException {
        // Variables
        ResultSet data;
        ArrayList<Collective> allCollectives = new ArrayList<>();
        Collective collective;

        try {
            // SQL statement
            String sql = "SELECT * FROM collective";
            PreparedStatement statement = connection.prepareStatement(sql);
            data = statement.executeQuery();

            // Convert
            while(data.next()) {
                collective = this.convertToCollective(data);
                allCollectives.add(collective);
            }

            return allCollectives;

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération de l'ensemble des collectifs");
        }
    }

    // Search for a collective based on its id
    @Override
    public Collective searchACollectiveBasedId(int idCollective) throws DAOConfigurationException {
        try {
            // SQL statement
            String sql = "SELECT * FROM collective WHERE idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            ResultSet data = statement.executeQuery();

            // Convert
            Collective collective = null;
            while(data.next()) {
                collective = this.convertToCollective(data);
            }

            return collective;

        } catch (SQLException e) {
            e.fillInStackTrace();
            throw new DAOConfigurationException("Erreur. Soit le collectif n'a pas été trouvé en base de donnée, soit une erreur SQL a eu lieu.");
        }
    }

    // Function convert sql to java
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
