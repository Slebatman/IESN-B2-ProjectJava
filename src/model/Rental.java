package model;

import java.util.GregorianCalendar;

public class Rental {
    // Variables
    private Integer idRental;
    private GregorianCalendar startDate;
    private Integer idObject;
    private Integer idTenant;
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
    public void setIdRental(Integer idRental) {
        this.idRental = idRental;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public void setIdTenant(Integer idTenant) {
        this.idTenant = idTenant;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

    public void setRentalManager(String rentalManager) {
        this.rentalManager = rentalManager;
    }

    // Getters
    public Integer getIdRental() {
        return idRental;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public Integer getIdObject() {
        return idObject;
    }

    public Integer getIdTenant() {
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
