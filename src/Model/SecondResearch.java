package Model;

import dataAcces.CollectiveManager;
import dataAcces.OneObjectManager;
import dataAcces.RentalManager;

import java.util.GregorianCalendar;

public class SecondResearch {
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

    public SecondResearch(ProblemExitRental problemExitRental) {
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

    public void setStartDate(Rental rental) {
        this.startDate = rental.getStartDate();
    }

    public void setReturnDate(Rental rental) {
        this.returnDate = rental.getReturnDate();
    }

    public void setNameObject(Rental rental) {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.nameObject = oneObject.getName();
    }

    public void setDeposit(Rental rental) {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.deposit = oneObject.getDeposit();
    }

    public void setMaxRentalPeriod(Rental rental) {
        OneObject oneObject = oneObjectManager.getObjectByID(rental.getIdObject());
        this.maxRentalPeriod = oneObject.getMaxRentalPeriod();
    }

    public void setNameCollectiveOwner(Rental rental) {
        Collective collective = collectiveManager.searchACollectiveBasedId(rental.getIdTenant());
        this.nameCollectiveOwner = collective.getName();
    }

    public void setEmailAddressCollectiveOwner(Rental rental) {
        Collective collective = collectiveManager.searchACollectiveBasedId(rental.getIdTenant());
        this.emailAddressCollectiveOwner = collective.getEmailAddress();
    }

    // ToString
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
