package view;

import model.ThirdResearch;
import controler.SearchControler;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueThirdSearch extends AbstractTableModel {
    private final ThirdResearch[] search;
    private final String[] entetes = {"objectName", "purchaseDate", "purchasePrice", "invoicedPrice", "note", "rentalManager"};
    private ArrayList<ThirdResearch> listSearch;
    private SearchControler controler;
    private SimpleDateFormat formatDate;
    GregorianCalendar date;
    String dateFormatted;

    public ModeleStatiqueThirdSearch(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        super();
        controler = new SearchControler();
        listSearch = controler.getRentalBetween2Dates(firstDate, secondDate);
        search = listSearch.toArray(new ThirdResearch[0]);
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
                return search[rowIndex].getObjectName();
            case 1:
                if(search[rowIndex].getPurchaseDate() != null){
                    GregorianCalendar date = new GregorianCalendar();
                    date = search[rowIndex].getPurchaseDate();
                    formatDate.setCalendar(date);
                    dateFormatted = formatDate.format(date.getTime());
                    return dateFormatted;
                }else{
                    return " - ";
                }
            case 2 :
                return search[rowIndex].getPurchasePrice();
            case 3 :
                return search[rowIndex].getInvoicedPrice();
            case 4 :
                return search[rowIndex].getNote();
            case 5 :
                return search[rowIndex].getRentalManager();
            default:
                return null;
        }
    }
}
