package dataAcces.dao;

import model.*;
import exception.DAOException;

import java.util.ArrayList;

public interface IOneObjectDAO {
    void insert(OneObject o) throws DAOException;
    void update(OneObject o) throws DAOException;
    void delete(int idObject) throws DAOException;
    ArrayList<OneObject> getAllObjects() throws DAOException;
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException;
    OneObject getObjectByID(int idObject) throws DAOException;
}
