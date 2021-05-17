package dataAcces.dao;

import Model.*;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public interface IOneObjectDAO {
    void insert(OneObject o);
    void update(OneObject o);
    void delete(int idObject);
    ArrayList<OneObject> getAllObjects();
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOConfigurationException;
    OneObject getObjectByID(int idObject);
}
