package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import exception.DAOException;
import model.OneObject;


import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO{
    // Variables
    private final Connection connection = SingletonConnexion.getConnection();

    // Insert
    @Override
    public void insert(OneObject o) throws DAOException {
        try {
            String sql = "INSERT INTO oneobject (idObject, name, idCollectiveOwner, isCommendable, purchaseDate, purchasePrice, deposit, maxRentalPeriod) " +
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
            throw new DAOException("Oups... Une erreur lors de l'insertion d'un objet en base de donnée est survenue.");
        }
    }

    // Update an object
    @Override
    public void update(OneObject o) throws DAOException {
        try {
            String sql = "UPDATE oneobject SET name = ?, idCollectiveOwner = ?, isCommendable = ?, purchaseDate = ?, purchasePrice = ?, " +
                    "deposit = ?, maxRentalPeriod = ? WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Not null value
            statement.setString(1,o.getName());
            statement.setInt(2,o.getIdCollectiveOwner());
            statement.setBoolean(3,o.isCommendable());

            // Nul value
            if(o.getPurchaseDate() != null) {
                statement.setDate(4, new Date(o.getPurchaseDate().getTimeInMillis()));
            } else {
                statement.setNull(4, Types.NULL);
            }

            if(o.getPurchasePrice() != Types.NULL) {
                statement.setDouble(5, o.getPurchasePrice());
            } else {
                statement.setNull(5, Types.NULL);
            }

            if(o.getDeposit() != Types.NULL) {
                statement.setInt(6, o.getDeposit());
            } else {
                statement.setNull(6, Types.NULL);
            }

            // Not null value
            statement.setInt(7, o.getMaxRentalPeriod());
            statement.setInt(8, o.getIdObject());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Une erreur d'accès à la base de données s'est produit, méthode appelée sur une connexion fermée ou erreur SQL.");
        }
    }

    // Delete
    @Override
    public void delete(int idObject) throws DAOException {
        try {
            String sql = "DELETE FROM oneobject WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idObject);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la suppression de l'objet en base de donnée");
        }
    }

    // Generic function to select several objects
    public ArrayList<OneObject> selectMultipleObject(PreparedStatement statement) throws SQLException {
        ResultSet data;
        ArrayList<OneObject> listOfOneObject = new ArrayList<>();

        data = statement.executeQuery();

        while(data.next()) {
            OneObject oneObject = dataToOneObject(data);
            listOfOneObject.add(oneObject);
        }

        return listOfOneObject;
    }

    // Generic function to select one object
    public OneObject selectOneObject(PreparedStatement statement) throws SQLException {
        ResultSet data;
        OneObject oneObject = null;

        data = statement.executeQuery();

        while(data.next()) {
            oneObject = dataToOneObject(data);
        }

        return oneObject;
    }

    // Select all objects
    @Override
    public ArrayList<OneObject> getAllObjects() throws DAOException {

        try {
            String sql = "SELECT * FROM oneobject";
            PreparedStatement statement = connection.prepareStatement(sql);

            return selectMultipleObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération de l'ensemble des objets");
        }
    }

    // Select all objects for one collective
    @Override
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException {

        try {
            String sql = "SELECT * FROM oneobject WHERE idCollectiveOwner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);

            return selectMultipleObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération des objets pour un collectif");
        }
    }

    // Retrieving the name of an object via its id
    @Override
    public OneObject getObjectByID(int idObject) throws DAOException {
        try {
            String sql = "SELECT * FROM oneobject WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idObject);

            return selectOneObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur lors de la récupération du nom d'un objet");
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
        oneObject.setCommendable(data.getInt("isCommendable") == 1);
        // PurchaseDate [optional]
        data.getDate("purchaseDate");
        if(!data.wasNull()) {
            calendar.setTime(data.getDate("purchaseDate"));
            oneObject.setPurchaseDate(calendar);
        }else{
            oneObject.setPurchaseDate(null);
        }
        // Purchase price [optional]
        data.getDouble("purchasePrice");
        if(!data.wasNull()) {
            oneObject.setPurchasePrice(data.getDouble("purchasePrice"));
        }else{
            oneObject.setPurchasePrice(Types.NULL);
        }
        // Deposit [optional]
        data.getInt("deposit");
        if(!data.wasNull()) {
            oneObject.setDeposit(data.getInt("deposit"));
        }else{
            oneObject.setDeposit(Types.NULL);
        }
        // maxRentalPeriod
        oneObject.setMaxRentalPeriod(data.getInt("maxRentalPeriod"));

        return oneObject;
    }
}
