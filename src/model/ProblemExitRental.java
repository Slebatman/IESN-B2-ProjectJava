package model;

public class ProblemExitRental {
    // Variables
    private Integer idProblemExitRental;
    private Integer idRental;
    private Integer idTypeOfProblemExitRental;
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
    public void setIdProblemExitRental(Integer idProblemExitRental) {
        this.idProblemExitRental = idProblemExitRental;
    }

    public void setIdRental(Integer idRental) {
        this.idRental = idRental;
    }

    public void setIdTypeOfProblemExitRental(Integer idTypeOfProblemExitRental) {
        this.idTypeOfProblemExitRental = idTypeOfProblemExitRental;
    }

    public void setInvoicedPrice(double invoicedPrice) {
        this.invoicedPrice = invoicedPrice;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Getters
    public Integer getIdProblemExitRental() {
        return idProblemExitRental;
    }

    public Integer getIdRental() {
        return idRental;
    }

    public Integer getIdTypeOfProblemExitRental() {
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
