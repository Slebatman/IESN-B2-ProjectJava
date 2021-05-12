package dataAcces;

import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();

        ArrayList<OneObject> allObjectsForOneCollective;

        try {
           /* allObjectsForOneCollective = oneObjectManager.getAllOneCollective(1);

            for (OneObject o : allObjectsForOneCollective) {
                //System.out.println(o.getIdObject());
            }*/
            Collective collective = collectiveManager.searchACollectiveBasedId(8);
            System.out.println("Info collectif : " + collective.getName());
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }


    }
}
