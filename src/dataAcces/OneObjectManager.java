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

    // Get all object for one collective
    ArrayList<OneObject> getAllOneCollective(int idCollective) {
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllOneCollective(Collective collective) {
        return this.getAllOneCollective(collective.getIdCollective());
    }
}
