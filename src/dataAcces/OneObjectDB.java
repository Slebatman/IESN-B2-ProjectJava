package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import dataAcces.exception.DAOConfigurationException;
import type.OneObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO {
    // Variables
    private final Connection connection = SingletonConnexion.getConnection();

    // Insert
    @Override
    public void insert(OneObject o) {
        try {
            String sql = "INSERT INTO oneobject (idObject, name, idCollectiveOwner, isCommandable, purchaseDate, purchasePrice, deposit, maxRentalPeriod) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Not null value
            statement.setInt(1, o.getIdObject());
            statement.setString(2,o.getName());
            statement.setInt(3,o.getIdCollectiveOwner());
            statement.setBoolean(4,o.isCommendable());

            // Nul value
            if(o.getPurchaseDate() != null) {
                statement.setDate(5, new Date(o.getPurchaseDate().getTimeInMillis()));
            } else {
                statement.setNull(5, Types.NULL);
            }

            if(o.getPurchasePrice() != Types.NULL) {
                statement.setDouble(6, o.getPurchasePrice());
            } else {
                statement.setNull(6, Types.NULL);
            }

            if(o.getDeposit() != Types.NULL) {
                statement.setInt(7, o.getDeposit());
            } else {
                statement.setNull(7, Types.NULL);
            }

            // Not null value
            statement.setInt(8, o.getMaxRentalPeriod());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOConfigurationException("Oups... Une erreur lors de l'insertion d'un objet en base de donnée est survenue.");
        }
    }

    // Select all objects for one collective
    @Override
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) {
        // Variables
        ResultSet data;
        ArrayList<OneObject> allObjectsCollective = new ArrayList<>();

        try {
            // SQL statement
            String sql = "SELECT * FROM oneobject WHERE idCollectiveOwner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            data = statement.executeQuery();

            // Convert
            while(data.next()) {
                OneObject oneObject = dataToOneObject(data);
                allObjectsCollective.add(oneObject);
            }

            return allObjectsCollective;

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur lors de la récupération des objets pour un collectif");
        }
    }

    // Convert ResultSet to object OneObject
    public OneObject dataToOneObject(ResultSet data) throws SQLException {
        GregorianCalendar calendar = new GregorianCalendar();
        OneObject oneObject = new OneObject();

        // ID
        oneObject.setIdObject(data.getInt("idObject"));
        // Name
        oneObject.setName( data.getString("name"));
        // Collective Owner
        oneObject.setIdCollectiveOwner(data.getInt("idCollectiveOwner"));
        // isCommendable
        oneObject.setCommendable(data.getInt("isCommandable") == 1);
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

        return oneObject;
    }

}
