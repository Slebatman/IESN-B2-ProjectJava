package model;

import java.util.GregorianCalendar;

public class Delay {
    private String nameCollectiveOwner;
    private String rentalManager;
    private int idOneObject;
    private String nameOneObject;
    private GregorianCalendar startDate;
    private int maxRentalPeriod;
    private int deposit;

    //Constructor
    public Delay(String nameCollectiveOwner, String rentalManager, int idOneObject, String nameOneObject, GregorianCalendar startDate, int maxRentalPeriod, int deposit){
        setNameCollectiveOwner(nameCollectiveOwner);
        setRentalManager(rentalManager);
        setIdOneObject(idOneObject);
        setNameOneObject(nameOneObject);
        setStartDate(startDate);
        setMaxRentalPeriod(maxRentalPeriod);
        setDeposit(deposit);
    }

    //Setters
    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setIdOneObject(int idOneObject) {
        this.idOneObject = idOneObject;
    }

    public void setMaxRentalPeriod(int maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public void setNameCollectiveOwner(String nameCollectiveOwner) {
        this.nameCollectiveOwner = nameCollectiveOwner;
    }

    public void setNameOneObject(String nameOneObject) {
        this.nameOneObject = nameOneObject;
    }

    public void setRentalManager(String rentalManager) {
        this.rentalManager = rentalManager;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
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
}
