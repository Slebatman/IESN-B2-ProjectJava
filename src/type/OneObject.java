package type;

import java.util.GregorianCalendar;

public class OneObject {
    // Link to DB
    private int idObject;
    private String name;
    private Collective collectiveOwner;
    private int idCollectiveOwner;
    private boolean isCommandable;
    private GregorianCalendar purchaseDate;
    private double purchasePrice;
    private int deposit;
    private int maxRentalPeriod;

    // Constructor
    public OneObject() {};

    public OneObject(String name, Collective collectiveOwner, boolean isCommandable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this.name = name;
        this.collectiveOwner = collectiveOwner;
        this.isCommandable = isCommandable;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public OneObject(int idObject, String name, Collective collectiveOwner, boolean isCommandable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this(name, collectiveOwner, isCommandable, purchaseDate, purchasePrice, deposit, maxRentalPeriod);
        this.idObject = idObject;
    }

    public OneObject(String name, int idCollectiveOwner, boolean isCommandable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this.name = name;
        this.idCollectiveOwner = idCollectiveOwner;
        this.isCommandable = isCommandable;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public OneObject(int idObject, String name, int idCollectiveOwner, boolean isCommandable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) {
        this(name, idCollectiveOwner, isCommandable, purchaseDate, purchasePrice, deposit, maxRentalPeriod);
        this.idObject = idObject;
    }

    // Getters
    public int getIdObject() {
        return idObject;
    }

    public String getName() {
        return name;
    }

    public Collective getCollectiveOwner() {
        return collectiveOwner;
    }

    public int getIdCollectiveOwner() {
        return idCollectiveOwner;
    }

    public boolean isCommandable() {
        return isCommandable;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCollectiveOwner(Collective collectiveOwner) {
        this.collectiveOwner = collectiveOwner;
    }

    public void setIdCollectiveOwner(int idCollectiveOwner) {
        this.idCollectiveOwner = idCollectiveOwner;
    }

    public void setCommandable(boolean commandable) {
        isCommandable = commandable;
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
                ", collectiveOwner=" + collectiveOwner +
                ", idCollectiveOwner=" + idCollectiveOwner +
                ", isCommandable=" + isCommandable +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", deposit=" + deposit +
                ", maxRentalPeriod=" + maxRentalPeriod +
                '}';
    }
}
