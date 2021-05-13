package type;

import java.util.Collections;
import java.util.GregorianCalendar;

public class Rental {
    // Variables link to DB
    private int idRental;
    private GregorianCalendar startDate;
    private int idObject;
    private int idTenant;
    private GregorianCalendar returnDate;
    private String rentalManager;

    // Constructors
    public Rental() {}

    public Rental(GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) {
        this.startDate = startDate;
        this.idObject = idObject;
        this.idTenant = idTenant;
        this.returnDate = returnDate;
        this.rentalManager = rentalManager;
    }

    public Rental(int idRental, GregorianCalendar startDate, int idObject, int idTenant, GregorianCalendar returnDate, String rentalManager) {
        this(startDate, idObject, idTenant, returnDate, rentalManager);
        this.idRental = idRental;
    }

    // Getteurs
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
}
