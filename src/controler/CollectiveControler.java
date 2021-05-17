package controler;

import dataAcces.CollectiveManager;
import Model.Collective;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public class CollectiveControler {
    private CollectiveManager manager;

    public CollectiveControler(){
        manager = new CollectiveManager();
    }

    public ArrayList<Collective> getAllCollectives() throws DAOConfigurationException {
        return  manager.getAllCollectives();
    }

    public int searchACollectiveIDBasedName(String name) throws DAOConfigurationException {
        return manager.searchACollectiveIDBasedName(name);
    }
}
