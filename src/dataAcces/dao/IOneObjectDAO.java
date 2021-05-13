package dataAcces.dao;

import type.*;

import java.util.ArrayList;

public interface IOneObjectDAO {
    void insert(OneObject o);
    void update(OneObject o);
    void delete(int idObject);
    ArrayList<OneObject> getAllObjects();
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective);
    OneObject getObjectByID(int idObject);
}
