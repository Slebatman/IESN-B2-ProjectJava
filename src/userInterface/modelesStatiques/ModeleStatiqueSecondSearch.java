package userInterface.modelesStatiques;

import exception.BusinessException;
import exception.ControllerException;
import exception.ModelException;
import model.research.SecondResearch;
import controller.ResearchController;
import exception.DAOException;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ModeleStatiqueSecondSearch extends AbstractTableModel {
    private final SecondResearch[] search;
    private final String[] entetes = {"startDate", "returnDate", "nameObject", "deposit", "maxRentalPeriod", "nameCollectiveOwner", "emailAddressCollectiveOwner"};
    private ArrayList<SecondResearch> listSearch;
    private ResearchController controler;
    private SimpleDateFormat formatDate;
    GregorianCalendar date;
    String dateFormatted;
    public ModeleStatiqueSecondSearch(int typeOfProblem) throws DAOException, ModelException, BusinessException, ControllerException {
        super();
        controler = new ResearchController();
        listSearch = controler.getProblemRentalBasedOnTypeOfProblem(typeOfProblem);
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
                    GregorianCalendar date = search[rowIndex].getStartDate();
                    formatDate.setCalendar(date);
                    return formatDate.format(date.getTime());
                }else{
                    return null;
                }
            case 1:
                if(search[rowIndex].getReturnDate() != null){
                    GregorianCalendar date = search[rowIndex].getReturnDate();
                    formatDate.setCalendar(date);
                    return formatDate.format(date.getTime());
                }else{
                    return null;
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

    public Class getColumnClass(int columnIndex){
        Class c;
        switch (columnIndex){
            case 0, 1 : c = SimpleDateFormat.class;
                break;
            case 3, 4 : c = Integer.class;
                break;
            default: c = String.class;
        }
        return c;
    }
}
