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
    public SecondResearch(ProblemExitRental problemExitRental) throws DAOException {
        rentalManager = new RentalManager();
        collectiveManager = new CollectiveManager();
        oneObjectManager = new OneObjectManager();
        Rental rental = rentalManager.getRentalBasedID(problemExitRental.getIdRental());

        setStartDate(rental);
        setReturnDate(rental);
        setNameObject(rental);
        setDeposit(rental);
        setMaxRentalPeriod(rental);
        setNameCollectiveOwner(rental);
        setEmailAddressCollectiveOwner(rental);
    }

    // Setters
    public void setStartDate(Rental rental) {
        this.startDate = rental.getStartDate();
    }

    public void setReturnDate(Rental rental) {
        this.returnDate = rental.getReturnDate();
    }

    public void setNameObject(Rental rental) throws DAOException {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.nameObject = oneObject.getName();
    }

    public void setDeposit(Rental rental) throws DAOException {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.deposit = oneObject.getDeposit();
    }

    public void setMaxRentalPeriod(Rental rental) throws DAOException {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.maxRentalPeriod = oneObject.getMaxRentalPeriod();
    }

    public void setNameCollectiveOwner(Rental rental) throws DAOException {
        Collective collective = collectiveManager.getACollectiveBasedId(rental.getIdTenant());
        this.nameCollectiveOwner = collective.getName();
    }

    public void setEmailAddressCollectiveOwner(Rental rental) throws DAOException {
        Collective collective = collectiveManager.getACollectiveBasedId(rental.getIdTenant());
        this.emailAddressCollectiveOwner = collective.getEmailAddress();
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
