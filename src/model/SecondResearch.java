package model;

import java.util.GregorianCalendar;

public class SecondResearch {
    // Variables
    private GregorianCalendar startDate;
    private GregorianCalendar returnDate;
    private String nameObject;
    private Integer deposit;
    private Integer maxRentalPeriod;
    private String nameCollectiveOwner;
    private String emailAddressCollectiveOwner;

    // Constructor
    public SecondResearch(GregorianCalendar startDate, GregorianCalendar returnDate, String nameObject, int deposit, int maxRentalPeriod, String nameCollectiveOwner, String emailAddressCollectiveOwner) {
        setStartDate(startDate);
        setStartDate(returnDate);
        setNameObject(nameObject);
        setDeposit(deposit);
        setMaxRentalPeriod(maxRentalPeriod);
        setNameCollectiveOwner(nameCollectiveOwner);
        setEmailAddressCollectiveOwner(emailAddressCollectiveOwner);
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

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public void setMaxRentalPeriod(Integer maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public void setNameCollectiveOwner(String nameCollectiveOwner) {
        this.nameCollectiveOwner = nameCollectiveOwner;
    }

    public void setEmailAddressCollectiveOwner(String emailAddressCollectiveOwner) {
        this.emailAddressCollectiveOwner = emailAddressCollectiveOwner;
    }

    // Getters
    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public Integer getMaxRentalPeriod() {
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
