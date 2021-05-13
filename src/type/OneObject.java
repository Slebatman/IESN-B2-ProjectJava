package type;

import java.util.GregorianCalendar;
import controler.exception.*;

public class OneObject {
    // Link to DB
    private int idObject;
    private String name;
    private int idCollectiveOwner;
    private boolean isCommendable;
    private GregorianCalendar purchaseDate;
    private Double purchasePrice;
    private Integer deposit;
    private int maxRentalPeriod;

    // Constructor
    public OneObject() {};

    public OneObject(String name, int idCollectiveOwner, boolean isCommendable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this.name = name;
        this.idCollectiveOwner = idCollectiveOwner;
        this.isCommendable = isCommendable;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public OneObject(int idObject, String name, int idCollectiveOwner, boolean isCommendable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this(name, idCollectiveOwner, isCommendable, purchaseDate, purchasePrice, deposit, maxRentalPeriod);
        this.idObject = idObject;
    }


    // Getters
    public int getIdObject() {
        return idObject;
    }

    public String getName() {
        return name;
    }

    public int getIdCollectiveOwner() {
        return idCollectiveOwner;
    }

    public boolean isCommendable() {
        return isCommendable;
    }

    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getMaxRentalPeriod() {
        return maxRentalPeriod;
    }

    // Setters
    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIdCollectiveOwner(int idCollectiveOwner) {
        this.idCollectiveOwner = idCollectiveOwner;
    }

    public void setCommendable(boolean commendable) {
        isCommendable = commendable;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setMaxRentalPeriod(int maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    @Override
    public String toString() {
        return "OneObject{" +
                "idObject=" + idObject +
                ", name='" + name + '\'' +
                ", idCollectiveOwner=" + idCollectiveOwner +
                ", isCommandable=" + isCommendable +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", deposit=" + deposit +
                ", maxRentalPeriod=" + maxRentalPeriod +
                '}';
    }
}
