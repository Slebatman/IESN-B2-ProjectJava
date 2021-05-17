package controler;
import Model.*;
import dataAcces.OneObjectManager;
import exception.DAOException;

import java.util.ArrayList;

public class ObjectControler {
   private OneObjectManager manager;
   public ObjectControler(){
      manager = new OneObjectManager();
   }

   public void addObject(OneObject object) throws DAOException {
      manager.addNewObject(object);
   }

   public ArrayList<OneObject> getAllObjects() throws DAOException {
      return manager.getAllObjects();
   }

   public ArrayList<OneObject> getAllObjectsForOneCollective(int idCollective) throws DAOException {
      return manager.getAllObjectsForOneCollective(idCollective);
   }
   public void deleteAnObject(OneObject oneObject) throws DAOException {
      manager.deleteAnObject(oneObject);
   }

   public void updateAnObject(OneObject object) throws DAOException {
      manager.updateAnObject(object);
   }

}
