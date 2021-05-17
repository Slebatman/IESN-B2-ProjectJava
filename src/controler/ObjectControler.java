package controler;
import Model.*;
import dataAcces.OneObjectManager;
import dataAcces.exception.DAOConfigurationException;

import java.util.ArrayList;

public class ObjectControler {
   private OneObjectManager manager;
   public ObjectControler(){
      manager = new OneObjectManager();
   }

   public void addObject(OneObject object) throws DAOConfigurationException {
      manager.addNewObject(object);
   }

   public ArrayList<OneObject> getAllObjects() throws DAOConfigurationException {
      return manager.getAllObjects();
   }

   public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOConfigurationException {
      return manager.getAllObjectsForOneCollective(idCollective);
   }
   public void deleteAnObject(OneObject oneObject) throws DAOConfigurationException {
      manager.deleteAnObject(oneObject);
   }

   public void updateAnObject(OneObject object) throws DAOConfigurationException {
      manager.updateAnObject(object);
   }

}
