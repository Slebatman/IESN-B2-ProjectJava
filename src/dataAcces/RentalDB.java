package dataAcces;

import Model.ThirdResearch;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import Model.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RentalDB implements IRentalDAO {
    // Date base connection
    private final Connection connection = SingletonConnexion.getConnection();

    // Generic function to select several objects
    public ArrayList<Rental> selectListRental(PreparedStatement statement) throws SQLException {
        ResultSet data;
        ArrayList<Rental> listRental = new ArrayList<>();

        data = statement.executeQuery();

        while (data.next()) {
            Rental rental = sqlDataToJavaRental(data);
            listRental.add(rental);
        }

        return listRental;
    }

    // Generic function to select one object
    public Rental selectOneRental(PreparedStatement statement) throws SQLException {
        Rental rental = null;
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            rental = sqlDataToJavaRental(data);
        }

        return rental;
    }

    // Research n°1
    @Override
    public ArrayList<Rental> rentalsForOneCollectiveCategory(String category) throws DAOException {
        try {
            String sql = "SELECT * FROM rental JOIN collective ON (rental.idTenant = collective.idCollective) WHERE collective.category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category);

            return selectListRental(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de recuperer les locations pour la categorie " + category);
        }
    }

    // Research n°3
    @Override
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        ArrayList<ThirdResearch> rentalBetween2Dates = new ArrayList<>();

        try {
            String sql = "select o.name, o.purchaseDate, o.purchasePrice, p.invocedPrice, p.note, r.rentalManager\n" +
                    "from rental r\n" +
                    "JOIN problemexitrental p on r.idRental = p.idRental\n" +
                    "JOIN oneobject o on o.idObject = r.idObject\n" +
                    "WHERE r.startDate BETWEEN ? AND ? ;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new Date(firstDate.getTimeInMillis()));
            statement.setDate(2, new Date(secondDate.getTimeInMillis()));

            ResultSet data = statement.executeQuery();

            while (data.next()) {
                ThirdResearch thirdResearch = new ThirdResearch();

                // Not null value
                thirdResearch.setObjectName(data.getString("o.name"));
                thirdResearch.setInvoicedPrice(data.getDouble("p.invocedPrice"));
                thirdResearch.setRentalManager(data.getString("r.rentalManager"));

                // Null value
                data.getDate("o.purchaseDate");
                if(!data.wasNull()) {
                    GregorianCalendar purchaseDate = new GregorianCalendar();
                    purchaseDate.setTime(data.getDate("o.purchaseDate"));
                    thirdResearch.setPurchaseDate(purchaseDate);
                }

                data.getDouble("o.purchasePrice");
                if (!data.wasNull()) {
                    thirdResearch.setPurchasePrice(data.getDouble("o.purchasePrice"));
                }

                data.getString("p.note");
                if (!data.wasNull()) {
                    thirdResearch.setNote(data.getString("p.note"));
                }

                rentalBetween2Dates.add(thirdResearch);
            }

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : recherche des locations entre les 2 dates ayant rencontré un problème n'est pas possible");
        }

        return rentalBetween2Dates;
    }

    @Override
    public Rental getOneRentalBasedID(int idRental) throws DAOException {
        try {
            String sql = "SELECT * FROM rental WHERE idRental = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idRental);

            return selectOneRental(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL lors de la récupération d'une location");
        }
    }

    // Convert sql to java object Rental
    public Rental sqlDataToJavaRental(ResultSet data) throws SQLException {
        GregorianCalendar startDate = new GregorianCalendar(), endDate = new GregorianCalendar();
        Rental rental = new Rental();

        // Not null value
        rental.setIdRental(data.getInt("idRental"));
        startDate.setTime(data.getDate("startDate"));
        rental.setStartDate(startDate);
        rental.setIdObject(data.getInt("idObject"));
        rental.setIdTenant(data.getInt("idTenant"));
        rental.setRentalManager(data.getString("rentalManager"));

        // Null value
        data.getDate("returnDate");
        if(!data.wasNull()) {
            endDate.setTime(data.getDate("returnDate"));
            rental.setReturnDate(endDate);
        }

        return rental;
    }
}
