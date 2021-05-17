package view;

import Model.OneObject;
import controler.ObjectControler;
import dataAcces.exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueListingObjects extends AbstractTableModel {
    private final OneObject[] objects;
    private final String[] entetes = {"IdObject","Name","idCollectiveOwner","isCommandable","purchaseDate","purchasePrice","deposit","MaxRentalPeriod"};

    private ArrayList<OneObject> listObjects;
    private ObjectControler controler;
    private SimpleDateFormat formatDate;
    public ModeleStatiqueListingObjects() throws DAOException {
        super();
        controler = new ObjectControler();
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
        switch (columnIndex){
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
                    GregorianCalendar date = new GregorianCalendar();
                    date = objects[rowIndex].getPurchaseDate();
                    formatDate.setCalendar(date);
                    String dateFormatted = formatDate.format(date.getTime());
                    return dateFormatted;
                }else{
                   return " - ";
                }
            case 5:
                if(objects[rowIndex].getPurchasePrice() == 0){
                    return " - ";
                }else{
                    return objects[rowIndex].getPurchasePrice();
                }
            case 6:
                if(objects[rowIndex].getDeposit() == 0){
                    return " - ";
                }else{
                    return objects[rowIndex].getDeposit();
                }
            case 7 :
                return objects[rowIndex].getMaxRentalPeriod();
            default:
                return null;
        }
    }
}
