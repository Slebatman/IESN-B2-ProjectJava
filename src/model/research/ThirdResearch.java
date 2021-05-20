package model.research;

import exception.ModelException;

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

    public ThirdResearch(String objectName, GregorianCalendar purchaseDate, Double purchasePrice, Double invoicedPrice, String note, String rentalManager) throws ModelException {
        setObjectName(objectName);
        setPurchaseDate(purchaseDate);
        setPurchasePrice(purchasePrice);
        setInvoicedPrice(invoicedPrice);
        setNote(note);
        setRentalManager(rentalManager);
    }

    // Setters
    public void setObjectName(String objectName) throws ModelException {
        if (objectName.equals("")) throw new ModelException("Le nom ne peut pas être une chaine vide");
        this.objectName = objectName;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(Double purchasePrice) throws ModelException {
        if (purchasePrice < 0) throw new ModelException("Le prix d'achat doit être suppérieur ou égal à 0");
        this.purchasePrice = purchasePrice;
    }

    public void setInvoicedPrice(Double invoicedPrice) throws ModelException {
        if (invoicedPrice < 0) throw new ModelException("La facture doit être suppérieur ou égal à 0");
        this.invoicedPrice = invoicedPrice;
    }

    public void setNote(String note) throws ModelException {
        if (objectName.equals("")) throw new ModelException("La note ne peut pas être une chaine vide");
        this.note = note;
    }

    public void setRentalManager(String rentalManager) throws ModelException {
        if (objectName.equals("")) throw new ModelException("Le responsable location ne peut pas être une chaine vide");
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

    // ToString for debug
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
