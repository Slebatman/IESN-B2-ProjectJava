package dataAcces.dao;

import type.*;

import java.util.ArrayList;

public interface IOneObjectDAO {
    ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective);
}
