// Class implement Singleton Pattern
package dataAcces;

import exception.DAOExceptionConnection;

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
            // Todo : implement catch exception
            throw new DAOExceptionConnection("Erreur lors de la connection à la base de données.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
