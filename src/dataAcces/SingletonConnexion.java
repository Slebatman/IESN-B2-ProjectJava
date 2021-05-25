// Class implement Singleton Pattern
package dataAcces;

import exception.DAOExceptionConnection;

import java.sql.*;

public class SingletonConnexion {
    private static String url = "jdbc:mysql://localhost:3306/inventory";
    private static String user = "BaeAnt";
    private static String password = "projectJava";
    private static Connection connection;

    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException e) {
            throw new DAOExceptionConnection("Erreur lors de la connection à la base de données.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws DAOExceptionConnection {
        try {
            connection.close();

        } catch (SQLException e) {
            throw new DAOExceptionConnection("Erreur lors de la fermeture de la base de données.");
        }
    }
}
