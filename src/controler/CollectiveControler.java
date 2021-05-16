package controler;

import dataAcces.CollectiveManager;
import Model.Collective;

import java.util.ArrayList;

public class CollectiveControler {
    private CollectiveManager manager;

    public CollectiveControler(){
        manager = new CollectiveManager();
    }

    public ArrayList<Collective> getAllCollectives(){
        return  manager.getAllCollectives();
    }

    public int searchACollectiveIDBasedName(String name) {
        return manager.searchACollectiveIDBasedName(name);
    }
}
