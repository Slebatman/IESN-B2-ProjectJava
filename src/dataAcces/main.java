package dataAcces;

import type.Collective;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        Collective collective1 = new Collective("Test collective 1", "Test", "Rue Bruno N°7", "test@rien.com");

        // Insert
        try {
            collectiveManager.addCollective(collective1);
        } catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
