package model;

public class ProblemExitRental {
    // Variables
    private int idProblemExitRental;
    private int idRental;
    private int idTypeOfProblemExitRental;
    private double invoicedPrice;
    private String note;

    // Constructor
    public ProblemExitRental(int idProblemExitRental, int idRental, int idTypeOfProblemExitRental, double invoicedPrice, String note) {
        setIdProblemExitRental(idProblemExitRental);
        setIdRental(idRental);
        setIdTypeOfProblemExitRental(idTypeOfProblemExitRental);
        setInvoicedPrice(invoicedPrice);
        setNote(note);
    }

    // Setters
    public void setIdProblemExitRental(int idProblemExitRental) {
        this.idProblemExitRental = idProblemExitRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public void setIdTypeOfProblemExitRental(int idTypeOfProblemExitRental) {
        this.idTypeOfProblemExitRental = idTypeOfProblemExitRental;
    }

    public void setInvoicedPrice(double invoicedPrice) {
        this.invoicedPrice = invoicedPrice;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Getters
    public int getIdProblemExitRental() {
        return idProblemExitRental;
    }

    public int getIdRental() {
        return idRental;
    }

    public int getIdTypeOfProblemExitRental() {
        return idTypeOfProblemExitRental;
    }

    public double getInvoicedPrice() {
        return invoicedPrice;
    }

    public String getNote() {
        return note;
    }

    // ToString for debug
    @Override
    public String toString() {
        return "ProblemExitRental{" +
                "idProblemExitRental=" + idProblemExitRental +
                ", idRental=" + idRental +
                ", idTypeOfProblemExitRental=" + idTypeOfProblemExitRental +
                ", invoicedPrice=" + invoicedPrice +
                ", note='" + note + '\'' +
                '}';
    }
}
