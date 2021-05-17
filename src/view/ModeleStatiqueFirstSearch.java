package view;

import Model.FirstResearch;
import controler.SearchControler;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueFirstSearch extends AbstractTableModel {
    private final FirstResearch[] search;
    private final String[] entetes = {"startDate", "objectName", "collectiveName"};

    private ArrayList<FirstResearch> listSearch;
    private SearchControler controler;
    private SimpleDateFormat formatDate;
    public ModeleStatiqueFirstSearch(String category) throws DAOException {
        super();
        controler = new SearchControler();
        listSearch = controler.rentalsForOneCollectiveCategory(category);
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
                GregorianCalendar date = new GregorianCalendar();
                date = search[rowIndex].getStartDate();
                formatDate.setCalendar(date);
                String dateFormatted = formatDate.format(date.getTime());
                return dateFormatted;
            case 1:
                return search[rowIndex].getObjectName();
            case 2 :
                return search[rowIndex].getCollectiveName();
            default:
                return null;
        }
    }
}
