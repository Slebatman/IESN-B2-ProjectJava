package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import type.Collective;
import type.OneObject;

import java.util.ArrayList;

public class OneObjectManager {
    // Variable
    IOneObjectDAO dao;

    // Constructor
    public OneObjectManager() {
        this.dao = new OneObjectDB();
    }

    // Insert
    public void addNewObject(OneObject oneObject) {
        dao.insert(oneObject);
    }

    // Get all object for one collective
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) {
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllObjectsForOneCollective(Collective collective) {
        return this.getAllObjectsForOneCollective(collective.getIdCollective());
    }
}
