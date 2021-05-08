// Class implement Singleton Pattern
package dataAcces;

import java.sql.*;

public class SingletonConnexion {
    private static Connection connection;

    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",
                            "admin",
                            "projetJava");
            System.out.println("Succefuly connected to the db !");
        }
        catch(ClassNotFoundException | SQLException e) {
            // ToDo : spread the error
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
