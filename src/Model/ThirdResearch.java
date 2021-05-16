package Model;

import java.util.GregorianCalendar;

public class ThirdResearch {
    // Variables
    private String objectName;
    private GregorianCalendar purchaseDate;
    private Double purchasePrice;
    private Double invoicedPrice;
    private String note;
    private String rentalManager;

    // Constructors
    public ThirdResearch() {}

    public ThirdResearch(String objectName, GregorianCalendar purchaseDate, Double purchasePrice, Double invoicedPrice, String note, String rentalManager) {
        this.objectName = objectName;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.invoicedPrice = invoicedPrice;
        this.note = note;
        this.rentalManager = rentalManager;
    }

    // Setters
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setInvoicedPrice(Double invoicedPrice) {
        this.invoicedPrice = invoicedPrice;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRentalManager(String rentalManager) {
        this.rentalManager = rentalManager;
    }

    // Getters
    public String getObjectName() {
        return objectName;
    }

    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Double getInvoicedPrice() {
        return invoicedPrice;
    }

    public String getNote() {
        return note;
    }

    public String getRentalManager() {
        return rentalManager;
    }

    // ToString
    @Override
    public String toString() {
        return "ThirdResearch{" +
                "objectName='" + objectName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", purchasePrice=" + purchasePrice +
                ", invoicedPrice=" + invoicedPrice +
                ", note='" + note + '\'' +
                ", rentalManager='" + rentalManager + '\'' +
                '}';
    }
}
