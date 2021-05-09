// Class implement Singleton Pattern
package dataAcces;

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
            System.out.println("Succefuly connected to the db !");
        }
        catch(ClassNotFoundException | SQLException e) {
            // ToDo : spread the error
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        System.out.println("c = " + connection);
        return connection;
    }
}
