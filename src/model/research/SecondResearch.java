package model.research;

import exception.ModelException;

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
    public SecondResearch(GregorianCalendar startDate, GregorianCalendar returnDate, String nameObject, int deposit, int maxRentalPeriod, String nameCollectiveOwner, String emailAddressCollectiveOwner) throws ModelException {
        setStartDate(startDate);
        setReturnDate(returnDate);
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

    public void setReturnDate(GregorianCalendar returnDate) throws ModelException {
        if (returnDate.compareTo(startDate) != 1) throw new ModelException("La date de retour doit être plus recente ou égale à la date de départ");
        this.returnDate = returnDate;
    }

    public void setNameObject(String nameObject) throws ModelException {
        if (nameObject.equals("")) throw new ModelException("Le responsable location ne peut pas être une chaine vide");
        this.nameObject = nameObject;
    }

    public void setDeposit(Integer deposit) throws ModelException {
        if (deposit < 0) throw new ModelException("La caution doit être suppérieure ou égale à 0");
        this.deposit = deposit;
    }

    public void setMaxRentalPeriod(Integer maxRentalPeriod) throws ModelException {
        if (maxRentalPeriod < 0) throw new ModelException("La durée maximale de location doit être suppérieure ou égale à 0");
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public void setNameCollectiveOwner(String nameCollectiveOwner) throws ModelException {
        if (nameCollectiveOwner.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
        this.nameCollectiveOwner = nameCollectiveOwner;
    }

    public void setEmailAddressCollectiveOwner(String emailAddressCollectiveOwner) throws ModelException {
        if (emailAddressCollectiveOwner.equals("")) throw new ModelException("L'email' ne peut pas être une chaine vide");
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
