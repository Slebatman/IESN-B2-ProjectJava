package controler;
import type.*;
import controler.exception.*;
import dataAcces.OneObjectManager;

import javax.swing.*;
import java.util.ArrayList;

public class ObjectControler {
   private OneObjectManager manager;
   public ObjectControler(){
      manager = new OneObjectManager();
   }

   public void addObject(OneObject object){
      manager.addNewObject(object);
   }

   public ArrayList<OneObject> getAllObjects(){
      return manager.getAllObjects();
   }

}
