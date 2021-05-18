package model;

import exception.ModelException;

public class ProblemExitRental {
    // Variables
    private Integer idProblemExitRental;
    private Integer idRental;
    private Integer idTypeOfProblemExitRental;
    private double invoicedPrice;
    private String note;

    // Constructor
    public ProblemExitRental(int idProblemExitRental, int idRental, int idTypeOfProblemExitRental, double invoicedPrice, String note) throws ModelException {
        setIdProblemExitRental(idProblemExitRental);
        setIdRental(idRental);
        setIdTypeOfProblemExitRental(idTypeOfProblemExitRental);
        setInvoicedPrice(invoicedPrice);
        setNote(note);
    }

    // Setters
    public void setIdProblemExitRental(Integer idProblemExitRental) throws ModelException {
        if (idProblemExitRental < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idProblemExitRental = idProblemExitRental;
    }

    public void setIdRental(Integer idRental) throws ModelException {
        if (idRental < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idRental = idRental;
    }

    public void setIdTypeOfProblemExitRental(Integer idTypeOfProblemExitRental) throws ModelException {
        if (idProblemExitRental < 1) throw new ModelException("L'identifiant doit être suppérieur à 0");
        this.idTypeOfProblemExitRental = idTypeOfProblemExitRental;
    }

    public void setInvoicedPrice(double invoicedPrice) throws ModelException {
        if (invoicedPrice < 0) throw new ModelException("La facture doit être suppérieure à 0");
        this.invoicedPrice = invoicedPrice;
    }

    public void setNote(String note) throws ModelException {
        if (note.equals("")) throw new ModelException("La note ne peut être une chaine une chaine vide");
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
