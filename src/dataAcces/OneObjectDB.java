package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO {
    // Data Access
    private final Connection connection = SingletonConnexion.getConnection();

    @Override
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) {
        // Variables
        ResultSet data;
        ArrayList<OneObject> allObjectsCollective = new ArrayList<>();
        GregorianCalendar calendar = new GregorianCalendar();

        try {
            // SQL statement
            String sql = "SELECT * FROM inventory.object WHERE idCollectiveOwner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            data = statement.executeQuery();

            // Convert
            while(data.next()) {
                OneObject oneObject = new OneObject();
                oneObject.setIdObject(data.getInt("idObject"));
                oneObject.setName( data.getString("name"));
                oneObject.setIdCollectiveOwner(data.getInt("idCollectiveOwner"));
                oneObject.setCommandable(data.getInt("isCommandable") == 1);
                data.getDate("purchaseDate");
                if(!data.wasNull()) {
                    calendar.setTime(data.getDate("purchaseDate"));
                    oneObject.setPurchaseDate(calendar);
                }


                allObjectsCollective.add(oneObject);
            }

            return allObjectsCollective;

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération des objets pour un collectif");
        }
    }
}
