package dataAcces.dao;

import dataAcces.DAOConfigurationException;
import dataAcces.DAOException;
import type.Collective;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ICollectiveDAO {
    // Methods
    void insert(Collective c) throws DAOConfigurationException;
    void update(Collective c) throws DAOConfigurationException;
    ArrayList<Collective> getAllCollective() throws DAOConfigurationException;

}
