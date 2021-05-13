package business;
import dataAcces.*;
import controler.*;
import type.Collective;

import java.util.ArrayList;

public class CollectiveBusiness {
    private CollectiveManager manager;
    public CollectiveBusiness(){
        manager = new CollectiveManager();
    }

    public ArrayList<Collective> getAllCollectives(){
        return  manager.getAllCollectives();
    }
}
