package dataAcces.dao;

import dataAcces.exception.DAOConfigurationException;
import type.Collective;

import java.util.ArrayList;

public interface ICollectiveDAO {

    void insert(Collective c) throws DAOConfigurationException;
    void update(Collective c) throws DAOConfigurationException;
    void delete(int idCollective) throws DAOConfigurationException;
    ArrayList<Collective> getAllCollective() throws DAOConfigurationException;
    Collective searchACollectiveBasedId(int idCollective) throws DAOConfigurationException;

}
