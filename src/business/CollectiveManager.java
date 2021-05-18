package business;

import dataAcces.CollectiveDB;
import dataAcces.dao.ICollectiveDAO;
import exception.DAOException;
import exception.ModelException;
import model.Collective;

import java.util.ArrayList;

public class CollectiveManager {
    // Variables
    private ICollectiveDAO dao;

    // Constructor
    public CollectiveManager() {
        setDao(new CollectiveDB());
    }

    // Setter
    private void setDao(ICollectiveDAO dao) {
        this.dao = dao;
    }

    // Add a new collective
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

    // Retrieve all collective data from the database
    public ArrayList<Collective> getAllCollectives() throws DAOException, ModelException {
        return dao.getAllCollective();
    }

    // Search for a collective based on its id
    public Collective getACollectiveBasedId(int idCollective) throws DAOException, ModelException {
        return dao.getACollectiveBasedId(idCollective);
    }

    // Retrieving a collective's ID based on its name
    public int getACollectiveIDBasedName(String name) throws DAOException, ModelException {
        return dao.getACollectiveIDBasedName(name);
    }

    // Separately retrieve the category of collective
    public ArrayList<String> getDistinctCategoryCollective() throws DAOException {
        return dao.getDistinctCategoryCollective();
    }
}
