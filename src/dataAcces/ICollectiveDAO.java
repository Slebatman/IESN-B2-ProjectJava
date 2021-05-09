package dataAcces;

import type.Collective;

import java.sql.SQLException;

public interface ICollectiveDAO {
    // Methods
    void insert(Collective collective) throws DAOException, SQLException;
    Collective find(String name) throws DAOException;


}
