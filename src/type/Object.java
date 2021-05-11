package type;

import java.util.GregorianCalendar;

public class Object {
    // Link to DB
    private int idObject;
    private String name;
    private int collectiveOwner;
    private boolean isCommandable;
    private GregorianCalendar purchaseDate;
    private double purchasePrice;
    private double deposit;
    private int maxRentalPeriod;


    public Object(String name, int idCollective, boolean commandable, GregorianCalendar date, double purchasePrice, double deposit, int maxPeriod){
       this.idObject = 1;
        this.name = name;
        this.collectiveOwner = idCollective;
        this.isCommandable = commandable;
        this.purchaseDate = date;
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.maxRentalPeriod = maxPeriod;
    }

    public String getName() {
        return name;
    }

    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public int getMaxRentalPeriod() {
        return maxRentalPeriod;
    }
}
