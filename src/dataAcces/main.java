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
                "Micro sans fil",
                3,
                false,
                null,
                Types.NULL,
                Types.NULL,
                5
                );

        try {
           // oneObjectManager.addNewObject(oneObject);
            ArrayList<OneObject> allArrayList = oneObjectManager.getAllObjectsForOneCollective(2);

            for(OneObject o : allArrayList) {
                System.out.println(o.getName());
            }
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }
}
