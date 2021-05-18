package model;

import exception.ModelException;

import java.util.GregorianCalendar;

public class OneObject {
    // Variables
    private Integer idObject;
    private String name;
    private Integer idCollectiveOwner;
    private Boolean isCommendable;
    private GregorianCalendar purchaseDate;
    private Double purchasePrice;
    private Integer deposit;
    private Integer maxRentalPeriod;

    // Constructors
    public OneObject() {}

    public OneObject(String name, int idCollectiveOwner, boolean isCommendable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) throws ModelException {
        setName(name);
        setIdCollectiveOwner(idCollectiveOwner);
        setCommendable(isCommendable);
        setPurchaseDate(purchaseDate);
        setPurchasePrice(purchasePrice);
        setDeposit(deposit);
        setMaxRentalPeriod(maxRentalPeriod);
    }

    public OneObject(int idObject, String name, int idCollectiveOwner, boolean isCommendable, GregorianCalendar purchaseDate, double purchasePrice, int deposit, int maxRentalPeriod) throws ModelException {
        this(name, idCollectiveOwner, isCommendable, purchaseDate, purchasePrice, deposit, maxRentalPeriod);
        setIdObject(idObject);
    }

    // Setters
    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIdCollectiveOwner(Integer idCollectiveOwner) {
        this.idCollectiveOwner = idCollectiveOwner;
    }

    public void setCommendable(boolean commendable) {
        isCommendable = commendable;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(double purchasePrice) throws ModelException {
        if (purchasePrice < 0) throw new ModelException("Le prix d'achat doit être suppérieur ou égal à 0");
        this.purchasePrice = purchasePrice;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setMaxRentalPeriod(Integer maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    // Getters
    public Integer getIdObject() {
        return idObject;
    }

    public String getName() {
        return name;
    }

    public Integer getIdCollectiveOwner() {
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

    public Integer getMaxRentalPeriod() {
        return maxRentalPeriod;
    }

    // ToString for debug
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
