package controler;

import business.*;
import type.Collective;

import java.util.ArrayList;

public class CollectiveControler {
    private CollectiveBusiness business;

    public CollectiveControler(){
        business = new CollectiveBusiness();
    }

    public ArrayList<Collective> getAllCollectives(){
        return  business.getAllCollectives();
    }
}
