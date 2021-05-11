// Class implement Singleton Pattern
package dataAcces;

import dataAcces.exception.DAOConfigurationException;

import java.sql.*;

public class SingletonConnexion {
    private static final String url = "jdbc:mysql://localhost:3306/inventory";
    private static final String user = "admin";
    private static final String password = "projetJava";
    private static Connection connection;

    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la connection à la base de données.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
