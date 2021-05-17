package business;

import dataAcces.OneObjectDB;
import dataAcces.dao.IOneObjectDAO;
import model.Collective;
import model.OneObject;
import exception.DAOException;

import java.util.ArrayList;

public class OneObjectManager {
    // Variable
    private final IOneObjectDAO dao;

    // Constructor
    public OneObjectManager() {
        this.dao = new OneObjectDB();
    }

    // Insert
    public void addNewObject(OneObject oneObject) throws DAOException {
        dao.insert(oneObject);
    }

    // Update
    public void updateAnObject(OneObject oneObject) throws DAOException {
        dao.update(oneObject);
    }

    // Delete
    public void deleteAnObject(int idObject) throws DAOException {
        dao.delete(idObject);
    }

    public void deleteAnObject(OneObject oneObject) throws DAOException {
        this.deleteAnObject(oneObject.getIdObject());
    }

    // Get all object
    public ArrayList<OneObject> getAllObjects() throws DAOException {
        return dao.getAllObjects();
    }

    // Get all object for one collective
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException {
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllObjectsForOneCollective(Collective collective) throws DAOException {
        return this.getAllObjectsForOneCollective(collective.getIdCollective());
    }

    //
    public OneObject getObjectByID(int idObject) throws DAOException {
        return dao.getObjectByID(idObject);
    }
}
