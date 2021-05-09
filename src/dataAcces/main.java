package dataAcces;

import type.Collective;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args)  {
        // Init
        Collective collective = new Collective();
        CollectiveManager collectiveManager = new CollectiveManager();

        //
        try {
            collectiveManager.addCollective(collective);
        } catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
