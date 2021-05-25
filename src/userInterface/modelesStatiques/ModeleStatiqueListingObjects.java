package userInterface.modelesStatiques;

import exception.ModelException;
import model.OneObject;
import controller.OneObjectController;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueListingObjects extends AbstractTableModel {
    private final OneObject[] objects;
    private final String[] entetes = {"Id","Nom","Id du collectif","Est commandable","Date d'achat","Prix d'achat","Caution","Nombre maximum de jours de location"};

    private ArrayList<OneObject> listObjects;
    private OneObjectController controler;
    private SimpleDateFormat formatDate;
    public ModeleStatiqueListingObjects() throws DAOException, ModelException {
        super();
        controler = new OneObjectController();
        listObjects = controler.getAllObjects();
        objects = listObjects.toArray(new OneObject[1]);
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
    }

    public int getRowCount(){
        return objects.length;
    }

    public int getColumnCount(){
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
            case 0:
                return objects[rowIndex].getIdObject();
            case 1:
                return objects[rowIndex].getName();
            case 2 :
                return objects[rowIndex].getIdCollectiveOwner();
            case 3:
                return objects[rowIndex].isCommendable();
            case 4:
                if(objects[rowIndex].getPurchaseDate() != null){
                    GregorianCalendar date = objects[rowIndex].getPurchaseDate();
                    formatDate.setCalendar(date);
                    return formatDate.format(date.getTime());
                } else {
                   return null;
                }
            case 5:
                return objects[rowIndex].getPurchasePrice();
            case 6:
                return objects[rowIndex].getDeposit();
            case 7 :
                return objects[rowIndex].getMaxRentalPeriod();
            default:
                return null;
        }
    }

    public Class getColumnClass(int columnIndex){
        Class c = switch (columnIndex) {
            case 0, 2, 6, 7 -> Integer.class;
            case 3 -> Boolean.class;
            case 4 -> SimpleDateFormat.class;
            case 5 -> Double.class;
            default -> String.class;
        };
        return c;
    }

    // ToDo : getColumnClass
}
