package dataAcces;

import type.Collective;

import java.sql.*;

public class CollectiveDB implements ICollectiveDAO {
    // DB Acces
    private SingletonConnexion connexion = new SingletonConnexion();

    @Override
    public void insert(Collective collective) throws DAOConfigurationException {
        try {
            String sql = "INSERT INTO collective (name, category, physicalAdress, emailAdress) VALUES ('Baetsle Antoine', 'KàPs', 'Rue sous la pelière', 'antoine@lesmarostin.be')";
            Statement statement = this.connexion.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DAOConfigurationException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    @Override
    public Collective find(String name) throws DAOException {
        return null;
    }
}
