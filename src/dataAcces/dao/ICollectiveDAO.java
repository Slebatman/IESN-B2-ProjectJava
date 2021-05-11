package dataAcces.dao;

import dataAcces.exception.DAOConfigurationException;
import type.Collective;

import java.util.ArrayList;

public interface ICollectiveDAO {
    // Methods
    void insert(Collective c) throws DAOConfigurationException;
    void update(Collective c) throws DAOConfigurationException;
    ArrayList<Collective> getAllCollective() throws DAOConfigurationException;

}
