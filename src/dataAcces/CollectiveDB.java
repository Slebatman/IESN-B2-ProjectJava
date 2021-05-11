package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import type.Collective;

import java.sql.*;

public class CollectiveDB implements ICollectiveDAO {
    // DB Acces
    private SingletonConnexion connexion = new SingletonConnexion();

    @Override
    public void insert(Collective c) throws DAOConfigurationException {
        try {
            String sql = "INSERT INTO collective (name, category, physicalAdress, emailAdress) VALUES (" +
                    c.getName() +", " +
                    c.getCategory() + ", " +
                    c.getPhysicalAdress() + ", " +
                    c.getEmailAdress() +")";
            Statement statement = this.connexion.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    @Override
    public Collective find(String name) throws DAOConfigurationException {
        return null;
    }
}
