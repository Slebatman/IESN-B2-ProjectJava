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

        ArrayList<Collective> allCollective;

        try {
            allCollective = collectiveManager.getAllCollectives();

            for (Collective c : allCollective) {
                System.out.println(c);
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
