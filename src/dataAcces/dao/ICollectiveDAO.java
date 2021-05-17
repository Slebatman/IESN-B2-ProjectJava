package dataAcces.dao;

import dataAcces.exception.DAOConfigurationException;
import Model.Collective;

import java.util.ArrayList;

public interface ICollectiveDAO {

    void insert(Collective c) throws DAOConfigurationException;
    void update(Collective c) throws DAOConfigurationException;
    void delete(int idCollective) throws DAOConfigurationException;
    ArrayList<Collective> getAllCollective() throws DAOConfigurationException;
    Collective getACollectiveBasedId(int idCollective) throws DAOConfigurationException;
    int getACollectiveIDBasedName(String name) throws DAOConfigurationException;
    ArrayList<String> getDistinctCategoryCollective() throws DAOConfigurationException;

}
