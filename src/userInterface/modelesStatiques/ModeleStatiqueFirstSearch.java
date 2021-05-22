package userInterface.modelesStatiques;

import exception.BusinessException;
import exception.ControllerException;
import exception.ModelException;
import model.research.FirstResearch;
import controller.ResearchController;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueFirstSearch extends AbstractTableModel {
    private final FirstResearch[] search;
    private final String[] entetes = {"startDate", "objectName", "collectiveName"};

    private ArrayList<FirstResearch> listSearch;
    private ResearchController controler;
    private SimpleDateFormat formatDate;
    public ModeleStatiqueFirstSearch(String category) throws DAOException, ModelException, BusinessException, ControllerException {
        super();
        controler = new ResearchController();
        listSearch = controler.getRentalsForOneCollectiveCategory(category);
        search = listSearch.toArray(new FirstResearch[0]);
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
    }

    public int getRowCount(){
        return search.length;
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
                GregorianCalendar date = search[rowIndex].getStartDate();
                formatDate.setCalendar(date);
                return formatDate.format(date.getTime());
            case 1:
                return search[rowIndex].getObjectName();
            case 2 :
                return search[rowIndex].getCollectiveName();
            default:
                return null;
        }
    }

    public Class getColumnClass(int columnIndex){
        Class c;
        switch (columnIndex){
            case 0 : c = SimpleDateFormat.class;
                break;
            default: c = String.class;
        }
        return c;
    }

    public boolean isEmpty() {
        return listSearch.size() == 0;
    }
}
