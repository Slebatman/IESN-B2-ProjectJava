package business;

import dataAcces.RentalDB;
import dataAcces.dao.IRentalDAO;
import exception.BusinessException;
import exception.DAOException;
import exception.ModelException;
import model.research.FirstResearch;
import model.Rental;

import java.util.ArrayList;

public class RentalManager {
    // Variable
    private IRentalDAO dao;

    // Constructor
    public RentalManager() {
        setDao(new RentalDB());
    }

    // Setter
    private void setDao(IRentalDAO dao) {
        this.dao = dao;
    }

    // Getting rentals for a category
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException, BusinessException {
        if (category.equals("")) throw new BusinessException("Erreur : la categorie ne peut être une chaine vide");
        return dao.getRentalsForOneCollectiveCategory(category);
    }

    // Getting rentals base on a ID
    public Rental getRentalBasedID(int idRental) throws DAOException, ModelException, BusinessException {
        if (idRental < 1) throw new BusinessException("Erreur : l'identifiant doit être suppérieur à 0");
        return dao.getOneRentalBasedID(idRental);
    }
}
