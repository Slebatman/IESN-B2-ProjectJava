package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import type.Collective;

public class CollectiveManager {
    ICollectiveDAO dao;

    public CollectiveManager() {
        this.dao = new CollectiveDB();
    }

    public void addCollective(Collective collective) throws DAOConfigurationException {
        dao.insert(collective);
    }

}
