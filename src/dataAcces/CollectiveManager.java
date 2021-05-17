package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import exception.DAOException;
import Model.Collective;

import java.util.ArrayList;

public class CollectiveManager {
    // Variable
    private final ICollectiveDAO dao;

    // Constructor
    public CollectiveManager() {
        this.dao = new CollectiveDB();
    }

    // Insert a collective
    public void addCollective(Collective collective) throws DAOException {
        dao.insert(collective);
    }

    // Update a collective
    public void updateCollective(Collective collective) throws DAOException {
        dao.update(collective);
    }

    // Delete a collective
    public void deleteCollective(int idCollective) throws DAOException {
        dao.delete(idCollective);
    }

    public void deleteCollective(Collective collective) throws DAOException {
        this.deleteCollective(collective.getIdCollective());
    }

    // get all collective in memory
    public ArrayList<Collective> getAllCollectives() throws DAOException {
        return dao.getAllCollective();
    }

    // Get a collective based on its id
    public Collective searchACollectiveBasedId(int idCollective) throws DAOException {
        return dao.getACollectiveBasedId(idCollective);
    }

    // Get id of a collective based on its name
    public int searchACollectiveIDBasedName(String name) throws DAOException {
        return dao.getACollectiveIDBasedName(name);
    }

    // Separately retrieve the category of collective
    public ArrayList<String> getDistinctCategoryCollective() throws DAOException {
        return dao.getDistinctCategoryCollective();
    }
}
