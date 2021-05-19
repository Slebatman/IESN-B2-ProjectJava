package business;

import dataAcces.OneObjectDB;
import dataAcces.dao.IOneObjectDAO;
import exception.BusinessException;
import exception.ModelException;
import model.Collective;
import model.OneObject;
import exception.DAOException;

import java.util.ArrayList;

public class OneObjectManager {
    // Variable
    private IOneObjectDAO dao;

    // Constructor
    public OneObjectManager() {
        setDao(new OneObjectDB());
    }

    // Setter
    private void setDao(IOneObjectDAO dao) {
        this.dao = dao;
    }

    // Insert a new object
    public void addNewObject(OneObject oneObject) throws DAOException {
        dao.insert(oneObject);
    }

    // Update an object
    public void updateAnObject(OneObject oneObject) throws DAOException {
        dao.update(oneObject);
    }

    // Delete an object
    public void deleteAnObject(int idObject) throws DAOException, BusinessException {
        if (idObject < 1) throw new BusinessException("Erreur : l'identifiant doit être suppérieur à 0");
        dao.delete(idObject);
    }

    public void deleteAnObject(OneObject oneObject) throws DAOException, BusinessException {
        this.deleteAnObject(oneObject.getIdObject());
    }

    // Retrieve all objects
    public ArrayList<OneObject> getAllObjects() throws DAOException, ModelException {
        return dao.getAllObjects();
    }

    // Recovering all the objects of a collective
    public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException, ModelException, BusinessException {
        if (idCollective < 1) throw new BusinessException("Erreur : l'identifiant doit être suppérieur à 0");
        return dao.getAllObjectsForOneCollective(idCollective);
    }

    ArrayList<OneObject> getAllObjectsForOneCollective(Collective collective) throws DAOException, ModelException, BusinessException {
        return this.getAllObjectsForOneCollective(collective.getIdCollective());
    }

    // Retrieving an object via its id
    public OneObject getObjectByID(int idObject) throws DAOException, ModelException, BusinessException {
        if (idObject < 1) throw new BusinessException("Erreur : l'identifiant doit être suppérieur à 0");
        return dao.getObjectByID(idObject);
    }
}
