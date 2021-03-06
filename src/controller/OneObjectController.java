package controller;
import dataAcces.SingletonConnexion;
import exception.*;
import model.*;
import business.OneObjectManager;

import java.util.ArrayList;

public class OneObjectController {
   // Variable
   private OneObjectManager manager;

   // Constructor
   public OneObjectController(){
      setManager(new OneObjectManager());
   }

   // Setter
   private void setManager(OneObjectManager manager) {
      this.manager = manager;
   }

   // Add a new object
   public void addObject(OneObject object) throws DAOException {
      manager.addNewObject(object);
   }

   // Update an object
   public void updateAnObject(OneObject object) throws DAOException {
      manager.updateAnObject(object);
   }

   // Delete an object
   public void deleteAnObject(OneObject oneObject) throws DAOException, BusinessException {
      manager.deleteAnObject(oneObject);
   }

   // Retrieve all objects
   public ArrayList<OneObject> getAllObjects() throws DAOException, ModelException {
      return manager.getAllObjects();
   }

   // Recovering all the objects of a collective
   public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException, ModelException, BusinessException, ControllerException {
      if (idCollective < 1) throw new ControllerException("Erreur : l'identifiant doit être suppérieur à 0");
      return manager.getAllObjectsForOneCollective(idCollective);
   }

   // Close connection
   public void closeConnection() throws DAOExceptionConnection {
      SingletonConnexion.closeConnection();
   }

}
