package model;

import business.CollectiveManager;
import business.OneObjectManager;
import business.RentalManager;
import exception.DAOException;

import java.util.GregorianCalendar;

public class SecondResearch {
    // Variables
    private GregorianCalendar startDate;
    private GregorianCalendar returnDate;
    private String nameObject;
    private int deposit;
    private int maxRentalPeriod;
    private String nameCollectiveOwner;
    private String emailAddressCollectiveOwner;

    private static RentalManager rentalManager;
    private static CollectiveManager collectiveManager;
    private static OneObjectManager oneObjectManager;

    // Constructor
    public SecondResearch(GregorianCalendar startDate, GregorianCalendar returnDate, String nameObject, int deposit, int maxRentalPeriod, String nameCollectiveOwner, String emailAddressCollectiveOwner) {
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.nameObject = nameObject;
        this.deposit = deposit;
        this.maxRentalPeriod = maxRentalPeriod;
        this.nameCollectiveOwner = nameCollectiveOwner;
        this.emailAddressCollectiveOwner = emailAddressCollectiveOwner;
    }

    // Setters
    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setMaxRentalPeriod(int maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public void setNameCollectiveOwner(String nameCollectiveOwner) {
        this.nameCollectiveOwner = nameCollectiveOwner;
    }

    public void setEmailAddressCollectiveOwner(String emailAddressCollectiveOwner) {
        this.emailAddressCollectiveOwner = emailAddressCollectiveOwner;
    }

    public static void setRentalManager(RentalManager rentalManager) {
        SecondResearch.rentalManager = rentalManager;
    }

    public static void setCollectiveManager(CollectiveManager collectiveManager) {
        SecondResearch.collectiveManager = collectiveManager;
    }

    public static void setOneObjectManager(OneObjectManager oneObjectManager) {
        SecondResearch.oneObjectManager = oneObjectManager;
    }

    // Getters
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getMaxRentalPeriod() {
        return maxRentalPeriod;
    }

    public String getNameObject() {
        return nameObject;
    }

    public String getNameCollectiveOwner() {
        return nameCollectiveOwner;
    }

    public String getEmailAddressCollectiveOwner() {
        return emailAddressCollectiveOwner;
    }

    // ToString for debug
    @Override
    public String toString() {
        return "SecondResearch{" +
                "startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", nameObject='" + nameObject + '\'' +
                ", deposit=" + deposit +
                ", maxRentalPeriod=" + maxRentalPeriod +
                ", nameCollectiveOwner='" + nameCollectiveOwner + '\'' +
                ", emailAddressCollectiveOwner='" + emailAddressCollectiveOwner + '\'' +
                '}';
    }
}
