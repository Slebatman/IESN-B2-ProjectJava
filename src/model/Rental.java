package model;

import exception.ModelException;

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

    public Rental(GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) throws ModelException {
        setStartDate(startDate);
        setIdObject(idObject);
        setIdTenant(idTenant);
        setReturnDate(returnDate);
        setRentalManager(rentalManager);
    }

    public Rental(int idRental, GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) throws ModelException {
        this(startDate, idObject, idTenant, returnDate, rentalManager);
        setIdRental(idRental);
    }

    // Setters
    public void setIdRental(Integer idRental) throws ModelException {
        if (idRental < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idRental = idRental;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public void setIdObject(Integer idObject) throws ModelException {
        if (idObject < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idObject = idObject;
    }

    public void setIdTenant(Integer idTenant) throws ModelException {
        if (idTenant < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idTenant = idTenant;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        if (returnDate.compareTo(startDate) > 0)
        this.returnDate = returnDate;
    }

    public void setRentalManager(String rentalManager) throws ModelException {
        if (rentalManager.equals("")) throw new ModelException("Le responsable location ne peut pas être une chaine vide");
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
