package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import type.Collective;

import java.util.ArrayList;

public class CollectiveManager {
    // Variable
    ICollectiveDAO dao;

    // Constructor
    public CollectiveManager() {
        this.dao = new CollectiveDB();
    }

    // Insert a collective
    public void addCollective(Collective collective) throws DAOConfigurationException {
        dao.insert(collective);
    }

    // Update a collective
    public void updateCollective(Collective collective) throws DAOConfigurationException {
        dao.update(collective);
    }

    // get all collective in memory
    public ArrayList<Collective> getAllCollectives() throws DAOConfigurationException {
        return dao.getAllCollective();
    }



}
