package view;

import Model.SecondResearch;
import controler.SearchControler;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueSecondSearch extends AbstractTableModel {
    private final SecondResearch[] search;
    private final String[] entetes = {"startDate", "returnDate", "nameObject", "deposit", "maxRentalPeriod", "nameCollectiveOwner", "emailAddressCollectiveOwner"};
    private ArrayList<SecondResearch> listSearch;
    private SearchControler controler;
    private SimpleDateFormat formatDate;
    GregorianCalendar date;
    String dateFormatted;
    public ModeleStatiqueSecondSearch(int typeOfProblem) throws DAOException {
        super();
        controler = new SearchControler();
        listSearch = controler.problemRentalBasedOnTypeOfProblem(typeOfProblem);
        search = listSearch.toArray(new SecondResearch[0]);
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
                if(search[rowIndex].getStartDate() != null){
                    GregorianCalendar date = new GregorianCalendar();
                    date = search[rowIndex].getStartDate();
                    formatDate.setCalendar(date);
                    dateFormatted = formatDate.format(date.getTime());
                    return dateFormatted;
                }else{
                    return " - ";
                }
            case 1:
                if(search[rowIndex].getReturnDate() != null){
                    GregorianCalendar date = new GregorianCalendar();
                    date = search[rowIndex].getReturnDate();
                    formatDate.setCalendar(date);
                    dateFormatted = formatDate.format(date.getTime());
                    return dateFormatted;
                }else{
                    return " - ";
                }
            case 2 :
                return search[rowIndex].getNameObject();
            case 3 :
                return search[rowIndex].getDeposit();
            case 4 :
                return search[rowIndex].getMaxRentalPeriod();
            case 5 :
                return search[rowIndex].getNameCollectiveOwner();
            case 6 :
                return search[rowIndex].getEmailAddressCollectiveOwner();
            default:
                return null;
        }
    }
}
