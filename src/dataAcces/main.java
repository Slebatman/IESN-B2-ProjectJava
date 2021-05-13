package dataAcces;

import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;

import java.sql.Types;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        OneObjectManager oneObjectManager = new OneObjectManager();

        GregorianCalendar date = new GregorianCalendar();
        OneObject oneObject = new OneObject(
                "Projecteur",
                1,
                false,
                date,
                350.99,
                20,
                3
                );

        ArrayList<OneObject> allArrayList = new ArrayList<>();

        try {
            allArrayList = oneObjectManager.getAllObjectsForOneCollective(1);

            for(OneObject o : allArrayList) {
                System.out.println(o.getName());
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
