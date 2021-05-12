package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Collective;
import type.OneObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO {
    // Variables
    private final Connection connection = SingletonConnexion.getConnection();
    CollectiveManager collectiveManager = new CollectiveManager();

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
                // Create object
                OneObject oneObject = new OneObject();
                // ID
                oneObject.setIdObject(data.getInt("idObject"));
                // Name
                oneObject.setName( data.getString("name"));
                // Collective Owner
                oneObject.setIdCollectiveOwner(data.getInt("idCollectiveOwner"));
                int idCollectiveOwner = oneObject.getIdCollectiveOwner();
                oneObject.setCollectiveOwner(collectiveManager.searchACollectiveBasedId(idCollectiveOwner));
                // isCommendable
                oneObject.setCommandable(data.getInt("isCommandable") == 1);
                // PurchaseDate [optional]
                data.getDate("purchaseDate");
                if(!data.wasNull()) {
                    calendar.setTime(data.getDate("purchaseDate"));
                    oneObject.setPurchaseDate(calendar);
                }
                // Purchase price [optional]
                data.getDouble("purchasePrice");
                if(!data.wasNull()) {
                    oneObject.setPurchasePrice(data.getDouble("purchasePrice"));
                }
                // Deposit [optional]
                data.getInt("deposit");
                if(!data.wasNull()) {
                    oneObject.setDeposit(data.getInt("deposit"));
                }
                // maxRentalPeriod
                oneObject.setMaxRentalPeriod(data.getInt("maxRentalPeriod"));

                // Add object
                allObjectsCollective.add(oneObject);
            }

            return allObjectsCollective;

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération des objets pour un collectif");
        }
    }
}
