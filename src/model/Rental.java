package model;

import java.util.GregorianCalendar;

public class Rental {
    // Variables
    private int idRental;
    private GregorianCalendar startDate;
    private int idObject;
    private int idTenant;
    private GregorianCalendar returnDate;
    private String rentalManager;

    // Constructors
    public Rental() {}

    public Rental(GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) {
        setStartDate(startDate);
        setIdObject(idObject);
        setIdTenant(idTenant);
        setReturnDate(returnDate);
        setRentalManager(rentalManager);
    }

    public Rental(int idRental, GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) {
        this(startDate, idObject, idTenant, returnDate, rentalManager);
        setIdRental(idRental);
    }

    // Setters
    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

    public void setRentalManager(String rentalManager) {
        this.rentalManager = rentalManager;
    }

    // Getters
    public int getIdRental() {
        return idRental;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public int getIdObject() {
        return idObject;
    }

    public int getIdTenant() {
        return idTenant;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    public String getRentalManager() {
        return rentalManager;
    }

    // ToString for debug
    @Override
    public String toString() {
        return "Rental{" +
                "idRental=" + idRental +
                ", startDate=" + startDate +
                ", idObject=" + idObject +
                ", idTenant=" + idTenant +
                ", returnDate=" + returnDate +
                ", rentalManager='" + rentalManager + '\'' +
                '}';
    }
}
