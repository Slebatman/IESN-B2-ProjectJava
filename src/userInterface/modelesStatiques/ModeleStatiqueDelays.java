package userInterface.modelesStatiques;

import controller.DelayControler;
import controller.ResearchController;
import exception.DAOException;
import exception.ModelException;
import model.Delay;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueDelays extends AbstractTableModel {

    private final Delay[] delays;
    private final String[] entetes = {"Collective name", "Rental manager", "idOneObject", "OneObject name", "Start date", "MaxRentalPeriod", "Jours de retard", "deposit"};

    private ArrayList<Delay> listDelay;
    private DelayControler controler;
    private SimpleDateFormat formatDate;

    public ModeleStatiqueDelays() throws DAOException, ModelException {
        super();
        controler = new DelayControler();
        listDelay = controler.getTacheMetier();
        delays = listDelay.toArray(new Delay[0]);
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
    }

    public int getRowCount(){
        return delays.length;
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
                return delays[rowIndex].getNameCollectiveOwner();
            case 1:
                return delays[rowIndex].getRentalManager();
            case 2 :
                return delays[rowIndex].getIdOneObject();
            case 3 :
                return delays[rowIndex].getNameOneObject();
            case 4 :
                GregorianCalendar date = new GregorianCalendar();
                date = delays[rowIndex].getStartDate();
                formatDate.setCalendar(date);
                String dateFormatted = formatDate.format(date.getTime());
                return dateFormatted;
            case 5 :
                return delays[rowIndex].getMaxRentalPeriod();
            case 6 :
                return delays[rowIndex].getNbDaysDelay();
            case 7 :
                return delays[rowIndex].getDeposit();
            default:
                return null;
        }
    }


}
