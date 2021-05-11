package dataAcces;

import type.Collective;

import java.util.ArrayList;

public class main {
    public static void main(String[] args)  {
        // Init
        CollectiveManager collectiveManager = new CollectiveManager();
        Collective collective1 = new Collective(3,"Alice", "AGE", "Rue Bruno N°7", "alice@age-namur.be");

        // Insert
       /* try {
            collectiveManager.addCollective(collective1);
        } catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }*/

        // Update
        /*try {
            collectiveManager.updateCollective(collective1);
        } catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }*/
        ArrayList<Collective> allCollectives = new ArrayList<>();

        try {
            allCollectives = collectiveManager.getAllCollectives();
        }
        catch (DAOConfigurationException e) {
            System.out.println(e.getMessage());
        }

        for (Collective c : allCollectives) {
            System.out.println(c.getName());
        }

    }
}
