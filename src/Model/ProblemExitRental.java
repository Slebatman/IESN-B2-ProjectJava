package Model;

public class ProblemExitRental {
    // Link to DB
    private int idProblemExitRental;
    private int idRental;
    private int idTypeOfProblemExitRental;
    private double invoicedPrice;
    private String note;

    // Constructor
    public ProblemExitRental(int idProblemExitRental, int idRental, int idTypeOfProblemExitRental, double invoicedPrice, String note) {
        this.idProblemExitRental = idProblemExitRental;
        this.idRental = idRental;
        this.idTypeOfProblemExitRental = idTypeOfProblemExitRental;
        this.invoicedPrice = invoicedPrice;
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
}
