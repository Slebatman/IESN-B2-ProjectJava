package dataAcces;

import dataAcces.dao.IRentalDAO;
import dataAcces.exception.DAOConfigurationException;
import type.Rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public ArrayList<Rental> rentalsForOneCollectiveCategory(String category) throws DAOConfigurationException {
        try {
            String sql = "SELECT * FROM rental JOIN collective ON (rental.idTenant = collective.idCollective) WHERE collective.category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category);

            return selectListRental(statement);

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL : impossible de recuperer les locations pour la categorie " + category);
        }
    }

    @Override
    public Rental getOneRentalBasedID(int idRental) {
        try {
            String sql = "SELECT * FROM rental WHERE idRental = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idRental);

            return selectOneRental(statement);

        } catch (SQLException e) {
            throw new DAOConfigurationException("Erreur SQL lors de la récupération d'une location");
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
