package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import type.Collective;

import java.sql.*;

public class CollectiveDB implements ICollectiveDAO {
    // DB Acces
    private Connection connexion = SingletonConnexion.getConnection();

    @Override
    public void insert(Collective c) throws DAOConfigurationException {
        try {
            String sql = "INSERT INTO collective (name, category, physicalAdress, emailAdress) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2,c.getCategory());
            statement.setString(3,c.getPhysicalAdress());
            statement.setString(4,c.getEmailAdress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    @Override
    public Collective find(String name) throws DAOConfigurationException {
        return null;
    }
}
