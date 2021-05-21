package model;

import exception.ModelException;

import java.util.GregorianCalendar;

public class Delay {
    private String nameCollectiveOwner;
    private String rentalManager;
    private int idOneObject;
    private String nameOneObject;
    private GregorianCalendar startDate;
    private int maxRentalPeriod;
    private int nbDaysDelay;
    private int nbRecalls;
    private int deposit;

    public Delay(){}

    //Constructor
    public Delay(String nameCollectiveOwner, String rentalManager, int idOneObject, String nameOneObject, GregorianCalendar startDate, int maxRentalPeriod, int deposit) throws ModelException {
        setNameCollectiveOwner(nameCollectiveOwner);
        setRentalManager(rentalManager);
        setIdOneObject(idOneObject);
        setNameOneObject(nameOneObject);
        setStartDate(startDate);
        setMaxRentalPeriod(maxRentalPeriod);
        setDeposit(deposit);
    }

    //Setters
    public void setDeposit(int deposit) throws ModelException{
        if(deposit < 0) throw new ModelException("La caution doit être plus grande que zéro");
        this.deposit = deposit;
    }

    public void setIdOneObject(int idOneObject) {
        this.idOneObject = idOneObject;
    }

    public void setMaxRentalPeriod(int maxRentalPeriod) throws ModelException{
        if(maxRentalPeriod < 1) throw new ModelException("La caution doit être plus grande que zéro");
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public void setNameCollectiveOwner(String nameCollectiveOwner) throws ModelException{
        if(nameCollectiveOwner.equals("")) throw new ModelException("Le nom du collectif doit être rempli");
        this.nameCollectiveOwner = nameCollectiveOwner;
    }

    public void setNameOneObject(String nameOneObject) throws ModelException{
        if(nameOneObject.equals("")) throw new ModelException("Le nom de l'objet doit être rempli");
        this.nameOneObject = nameOneObject;
    }

    public void setRentalManager(String rentalManager) throws ModelException{
        if(rentalManager.equals("")) throw new ModelException("Le nom du locataire doit être rempli");
        this.rentalManager = rentalManager;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setNbDaysDelay(int nbDaysDelay)throws ModelException {
        if(nbDaysDelay < 0) throw new ModelException("Le nombre de jours de retards ne peut pas être négatif")    ;
        this.nbDaysDelay = nbDaysDelay;
    }

    public void setNbRecalls(int nbRecalls) throws ModelException{
        if(nbRecalls < 0) throw new ModelException("Le nombre de rappels ne peut pas être négatif");
        this.nbRecalls = nbRecalls;
    }

    //Getters
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getIdOneObject() {
        return idOneObject;
    }

    public int getMaxRentalPeriod() {
        return maxRentalPeriod;
    }

    public String getNameCollectiveOwner() {
        return nameCollectiveOwner;
    }

    public String getNameOneObject() {
        return nameOneObject;
    }

    public String getRentalManager() {
        return rentalManager;
    }

    public int getNbDaysDelay() {
        return nbDaysDelay;
    }

    public int getNbRecalls() {
        return nbRecalls;
    }
}
