package controler;

import dataAcces.CollectiveManager;
import Model.Collective;
import dataAcces.exception.DAOException;

import java.util.ArrayList;

public class CollectiveControler {
    private CollectiveManager manager;

    public CollectiveControler(){
        manager = new CollectiveManager();
    }

    public ArrayList<Collective> getAllCollectives() throws DAOException {
        return  manager.getAllCollectives();
    }

    public int searchACollectiveIDBasedName(String name) throws DAOException {
        return manager.searchACollectiveIDBasedName(name);
    }
}
