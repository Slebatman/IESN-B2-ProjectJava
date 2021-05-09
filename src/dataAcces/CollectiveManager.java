package dataAcces;

import type.Collective;

import java.sql.SQLException;

public class CollectiveManager {
    ICollectiveDAO dao;

    public CollectiveManager() {
        this.dao = new CollectiveDB();
    }

    public void addCollective(Collective collective) throws DAOConfigurationException {
        dao.insert(collective);
    }

}
