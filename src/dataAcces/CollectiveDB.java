package dataAcces;

import type.Collective;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectiveDB implements ICollectiveDAO {
    // DB Acces
    private SingletonConnexion connexion = new SingletonConnexion();

    @Override
    public void insert(Collective collective) throws DAOException, SQLException {
        System.out.println("Connexion : " + this.connexion.getConnection().createStatement());
        Statement statement = this.connexion.getConnection().createStatement();
        statement.executeUpdate("INSERT INTO collective (idCollective, name, category, physicalAdress, emailAdress) VALUES (1, 'Baetsle Antoine', 'KàPs', 'Rue sous la pelière', 'antoine@lesmarostin')");
    }

    @Override
    public Collective find(String name) throws DAOException {
        return null;
    }
}
