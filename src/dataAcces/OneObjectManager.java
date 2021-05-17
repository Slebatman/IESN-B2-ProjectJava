package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import Model.Collective;
import Model.OneObject;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public class OneObjectManager {
    // Variable
    private final IOneObjectDAO dao;

    // Constructor
    public OneObjectManager() {
        this.dao = new OneObjectDB();
    }

    // Insert
    public void addNewObject(OneObject oneObject) throws DAOConfigurationException {
        dao.insert(oneObject);
    }

    // Update
    public void updateAnObject(OneObject oneObject) throws DAOConfigurationException {
        dao.update(oneObject);
    }

    // Delete
    public void deleteAnObject(int idObject) throws DAOConfigurationException {
        dao.delete(idObject);
    }

    public void deleteAnObject(OneObject oneObject) throws DAOConfigurationException {
        this.deleteAnObject(oneObject.getIdObject());
    }

    // Get all object
    public ArrayList<OneObject> getAllObjects() throws DAOConfigurationException {
        return dao.getAllObjects();
    }

    // Get all object for one collective
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOConfigurationException {
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllObjectsForOneCollective(Collective collective) throws DAOConfigurationException {
        return this.getAllObjectsForOneCollective(collective.getIdCollective());
    }

    //
    public OneObject getObjectByID(int idObject) throws DAOConfigurationException {
        return dao.getObjectByID(idObject);
    }
}
