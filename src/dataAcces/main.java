package dataAcces;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        Connection connection = SingletonConnexion.getConnection();
    }
}
