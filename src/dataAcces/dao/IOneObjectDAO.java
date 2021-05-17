package dataAcces.dao;

import model.*;
import exception.DAOException;

import java.util.ArrayList;

public interface IOneObjectDAO {

    // Insert a new object
    void insert(OneObject o) throws DAOException;

    // Update an object
    void update(OneObject o) throws DAOException;

    // Delete an object
    void delete(int idObject) throws DAOException;

    // Retrieve all objects
    ArrayList<OneObject> getAllObjects() throws DAOException;

    // Recovering all the objects of a collective
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException;

    // Retrieving an object via its id
    OneObject getObjectByID(int idObject) throws DAOException;

}
