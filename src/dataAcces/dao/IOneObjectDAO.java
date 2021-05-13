package dataAcces.dao;

import type.*;

import java.util.ArrayList;

public interface IOneObjectDAO {
    void insert(OneObject o);
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective);
}
