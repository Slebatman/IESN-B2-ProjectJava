package dataAcces.dao;

import Model.*;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public interface IOneObjectDAO {
    void insert(OneObject o) throws DAOConfigurationException;
    void update(OneObject o) throws DAOConfigurationException;
    void delete(int idObject) throws DAOConfigurationException;
    ArrayList<OneObject> getAllObjects() throws DAOConfigurationException;
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOConfigurationException;
    OneObject getObjectByID(int idObject) throws DAOConfigurationException;
}
