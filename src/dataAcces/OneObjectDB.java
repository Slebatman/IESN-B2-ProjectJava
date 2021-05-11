package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO {
    // Data Acces
    private final Connection connection = SingletonConnexion.getConnection();

    @Override
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) {
        // Variables
        ResultSet data;
        ArrayList<OneObject> allObjectsCollective = new ArrayList<>();
        OneObject object = new OneObject();
        GregorianCalendar calendar = new GregorianCalendar();

        try {
            // SQL statement
            String sql = "SELECT * FROM inventory.object WHERE idCollectiveOwner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            data = statement.executeQuery();

            // Convert
            while(data.next()) {
                object.setIdObject(data.getInt("idObject"));
                object.setName( data.getString("name"));
                object.setIdCollectiveOwner(data.getInt("idCollectiveOwner"));
                object.setCommandable(data.getInt("isCommandable") == 1);
                data.getDate("purchaseDate");
                if(!data.wasNull()) {
                    calendar.setTime(data.getDate("purchaseDate"));
                    object.setPurchaseDate(calendar);
                }

                System.out.println(object.getName());

                allObjectsCollective.add(object);

                System.out.println("--- Boucle for ---");
                for (OneObject o : allObjectsCollective) {
                    System.out.println(o.getIdObject());
                }
            }

            System.out.println("--- Out while ---");
            System.out.println(allObjectsCollective.get(0).getIdObject());
            System.out.println(allObjectsCollective.get(1).getIdObject());
            System.out.println(allObjectsCollective.get(2).getIdObject());

            System.out.println("--- Boucle for ---");
            for (OneObject o : allObjectsCollective) {
                System.out.println(o.getIdObject());
            }

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération des objets pour un collectif");
        }

        return allObjectsCollective;
    }
}
