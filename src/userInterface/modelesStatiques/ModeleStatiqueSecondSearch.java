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
    // Variables
    private final SecondResearch[] search;
    private final String[] entetes = {"Date de départ", "Date de retour", "Nom de l'objet", "Caution", "Nombre maximum de jours de location", "Nom du collectif propriétaire", "adresse mail du collectif"};
    private ArrayList<SecondResearch> listSearch;
    private ResearchController controler;
    private SimpleDateFormat formatDate;

    // Constructor
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
                if (search[rowIndex].getStartDate() != null) {
                    GregorianCalendar date = search[rowIndex].getStartDate();
                    formatDate.setCalendar(date);
                    return formatDate.format(date.getTime());
                } else {
                    return null;
                }
            case 1:
                if (search[rowIndex].getReturnDate() != null) {
                    GregorianCalendar date = search[rowIndex].getReturnDate();
                    formatDate.setCalendar(date);
                    return formatDate.format(date.getTime());
                } else {
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
        return switch (columnIndex) {
            case 0, 1 -> SimpleDateFormat.class;
            case 3, 4 -> Integer.class;
            default -> String.class;
        };
    }

    public boolean isEmpty() {
        return listSearch.size() == 0;
    }
}
