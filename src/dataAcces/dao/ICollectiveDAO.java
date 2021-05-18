package dataAcces.dao;

import exception.DAOException;
import exception.ModelException;
import model.Collective;

import java.util.ArrayList;

public interface ICollectiveDAO {

    // Add a new collective
    void insert(Collective c) throws DAOException;

    // Update a collective
    void update(Collective c) throws DAOException;

    // Delete a collective
    void delete(int idCollective) throws DAOException;

    // Retrieve all collective data from the database
    ArrayList<Collective> getAllCollective() throws DAOException, ModelException;

    // Search for a collective based on its id
    Collective getACollectiveBasedId(int idCollective) throws DAOException, ModelException;

    // Retrieving a collective's ID based on its name
    int getACollectiveIDBasedName(String name) throws DAOException, ModelException;

    // Separately retrieve the category of Collective
    ArrayList<String> getDistinctCategoryCollective() throws DAOException;

}
