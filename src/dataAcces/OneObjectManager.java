package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import type.Collective;
import type.OneObject;

import java.util.ArrayList;

public class OneObjectManager {
    // Variable
    private final IOneObjectDAO dao;

    // Constructor
    public OneObjectManager() {
        this.dao = new OneObjectDB();
    }

    // Insert
    public void addNewObject(OneObject oneObject) {
        dao.insert(oneObject);
    }

    // Update
    public void updateAnObject(OneObject oneObject) {
        dao.update(oneObject);
    }

    // Delete
    public void deleteAnObject(int idObject) {
        dao.delete(idObject);
    }

    public void deleteAnObject(OneObject oneObject) {
        this.deleteAnObject(oneObject.getIdObject());
    }

    // Get all object
    public ArrayList<OneObject> getAllObjects() {
        return dao.getAllObjects();
    }

    // Get all object for one collective
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) {
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllObjectsForOneCollective(Collective collective) {
        return this.getAllObjectsForOneCollective(collective.getIdCollective());
    }
}
