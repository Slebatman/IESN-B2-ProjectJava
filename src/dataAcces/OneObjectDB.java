package dataAcces;

import dataAcces.dao.IOneObjectDAO;
import exception.DAOException;
import model.OneObject;


import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OneObjectDB implements IOneObjectDAO{
    // Data base access
    private final Connection connection = SingletonConnexion.getConnection();

    // [IMPLEMENT] Insert a new object
    @Override
    public void insert(OneObject o) throws DAOException {
        try {
            String sql = "INSERT INTO oneobject (name, idCollectiveOwner, isCommendable, purchaseDate, purchasePrice, deposit, maxRentalPeriod) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            editPreparedStatement(statement, o);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible d'ajouter l'objet en base de données");
        }
    }

    // [IMPLEMENT] Update an object
    @Override
    public void update(OneObject o) throws DAOException {
        try {
            String sql = "UPDATE oneobject SET name = ?, idCollectiveOwner = ?, isCommendable = ?, purchaseDate = ?, purchasePrice = ?, " +
                    "deposit = ?, maxRentalPeriod = ? WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            editPreparedStatement(statement, o);
            statement.setInt(8, o.getIdObject());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de mettre à jour l'objet en base de données");
        }
    }

    // [IMPLEMENT] Delete an object
    @Override
    public void delete(int idObject) throws DAOException {
        try {
            String sql = "DELETE FROM oneobject WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idObject);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de supprimer l'objet en base de données");
        }
    }

    // Generic function to select several objects
    private ArrayList<OneObject> selectMultipleObject(PreparedStatement statement) throws SQLException {
        ArrayList<OneObject> listOfOneObject = new ArrayList<>();
        ResultSet data = statement.executeQuery();

        while(data.next()) {
            listOfOneObject.add(sqlToJavaObject(data));
        }
        return listOfOneObject;
    }

    // Generic function to select one object
    private OneObject selectOneObject(PreparedStatement statement) throws SQLException {

        ResultSet data = statement.executeQuery();
        while(data.next()) {
            return sqlToJavaObject(data);
        }
        return null;
    }

    // [IMPLEMENT] Retrieve all objects from the database
    @Override
    public ArrayList<OneObject> getAllObjects() throws DAOException {

        try {
            String sql = "SELECT * FROM oneobject";
            PreparedStatement statement = connection.prepareStatement(sql);

            return selectMultipleObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer l'ensemble des objets en base de données");
        }
    }

    // [IMPLEMENT] Recovering all the objects of a collective
    @Override
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException {

        try {
            String sql = "SELECT * FROM oneobject WHERE idCollectiveOwner = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            return selectMultipleObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer l'ensemble des objets pour le collectif d'identidiant : " + idCollective);
        }
    }

    // [IMPLEMENT] Retrieving an object via its id
    @Override
    public OneObject getObjectByID(int idObject) throws DAOException {
        try {
            String sql = "SELECT * FROM oneobject WHERE idObject = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idObject);
            return selectOneObject(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impssoble de récuperer l'objet sur base de son ID");
        }
    }

    // Convert sql to java object OneObject
    private OneObject sqlToJavaObject(ResultSet data) throws SQLException {
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

    // Edit PreparedStatement for include et update
    private void editPreparedStatement(PreparedStatement statement, OneObject o) throws SQLException {
        // Not null value
        statement.setString(1,o.getName());
        statement.setInt(2,o.getIdCollectiveOwner());
        statement.setBoolean(3,o.isCommendable());

        // Null values
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

        // Not null values
        statement.setInt(7, o.getMaxRentalPeriod());
    }
}
