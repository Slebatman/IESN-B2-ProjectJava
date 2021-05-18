package controller;

import business.CollectiveManager;
import exception.ModelException;
import model.Collective;
import exception.DAOException;

import java.util.ArrayList;

public class CollectiveController {
    // Variable
    private CollectiveManager manager;

    // Constructor
    public CollectiveController() {
        setManager(new CollectiveManager());
    }

    // Setter
    private void setManager(CollectiveManager manager) {
        this.manager = manager;
    }

    // Retrieve all collective
    public ArrayList<Collective> getAllCollectives() throws DAOException {
        return  manager.getAllCollectives();
    }

    // Retrieving a collective's ID based on its name
    public int getACollectiveIDBasedName(String name) throws DAOException, ModelException {
        return manager.getACollectiveIDBasedName(name);
    }
}
