package userInterface.modelesStatiques;

public class ModeleStatiqueDelays {
    /*
    private final Delays[] delays;
    private final String[] entetes = {"startDate", "objectName", "collectiveName"};

    private ArrayList<Delays> listSearch;
    private ResearchController controler;
    private SimpleDateFormat formatDate;

    public ModeleStatiqueDelays() throws DAOException {
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

     */
}
