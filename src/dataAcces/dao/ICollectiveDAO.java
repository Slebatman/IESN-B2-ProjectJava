package dataAcces.dao;

import dataAcces.DAOConfigurationException;
import type.Collective;

import java.sql.SQLException;

public interface ICollectiveDAO {
    // Methods
    void insert(Collective collective) throws DAOConfigurationException;
    Collective find(String name) throws DAOConfigurationException;


}
