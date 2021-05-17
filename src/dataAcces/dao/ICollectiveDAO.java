package dataAcces.dao;

import exception.DAOException;
import Model.Collective;

import java.util.ArrayList;

public interface ICollectiveDAO {

    void insert(Collective c) throws DAOException;
    void update(Collective c) throws DAOException;
    void delete(int idCollective) throws DAOException;
    ArrayList<Collective> getAllCollective() throws DAOException;
    Collective getACollectiveBasedId(int idCollective) throws DAOException;
    int getACollectiveIDBasedName(String name) throws DAOException;
    ArrayList<String> getDistinctCategoryCollective() throws DAOException;

}
