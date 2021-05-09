package dataAcces;

import type.Collective;

import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        Collective collective = new Collective();
        CollectiveManager collectiveManager = new CollectiveManager();

        collectiveManager.addCollective(collective);

    }
}
