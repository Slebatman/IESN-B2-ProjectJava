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
            statement.setString(3,c.getPhysicalAdress());
            statement.setString(4,c.getEmailAdress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    // Update
    @Override
    public void update(Collective c) throws DAOConfigurationException {
        try {
            String sql = "UPDATE collective SET name = ?, category = ?, physicalAdress = ?, emailAdress = ? where idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2,c.getCategory());
            statement.setString(3,c.getPhysicalAdress());
            statement.setString(4,c.getEmailAdress());
            statement.setInt(5,c.getIdCollective());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
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
            String sql = "SELECT * FROM inventory.collective";
            PreparedStatement statement = connection.prepareStatement(sql);
            data = statement.executeQuery();

            // Convert
            while(data.next()) {
                collective = new Collective(data.getInt("idCollective"), data.getString("name"), data.getString("category"), data.getString("physicalAdress"), data.getString("emailAdress"));
                allCollectives.add(collective);
            }

            return allCollectives;

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération de l'ensemble des collectifs");
        }
    }
}
