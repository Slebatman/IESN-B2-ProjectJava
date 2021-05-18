package dataAcces;

import model.research.FirstResearch;
import model.research.SecondResearch;
import model.research.ThirdResearch;
import dataAcces.dao.IRentalDAO;
import exception.DAOException;
import model.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RentalDB implements IRentalDAO {
    // Date base access
    private final Connection connection = SingletonConnexion.getConnection();

    // Generic function to select several objects
    public ArrayList<Rental> selectListRental(PreparedStatement statement) throws SQLException {
        ArrayList<Rental> listRental = new ArrayList<>();
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            listRental.add(sqlToJavaObject(data));
        }

        return listRental;
    }

    // Generic function to select one object
    public Rental selectOneRental(PreparedStatement statement) throws SQLException {
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            return sqlToJavaObject(data);
        }
        return null;
    }

    // [IMPLEMENT] (Research n°1) All rentals for a category of collectives
    @Override
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException {
        try {
            ArrayList<FirstResearch> allRentalsForOneCollectiveCategory = new ArrayList<>();

            String sql = "SELECT r.startDate, o.name, c.name FROM rental r JOIN collective c ON (r.idTenant = c.idCollective) JOIN oneobject o on o.idObject = r.idObject WHERE c.category = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category);

            ResultSet data = statement.executeQuery();
            while (data.next()) {
                GregorianCalendar startDate = new GregorianCalendar();
                startDate.setTime(data.getDate("r.startDate"));
                allRentalsForOneCollectiveCategory.add(new FirstResearch(
                        startDate,
                        data.getString("o.name"),
                        data.getString("c.name")
                ));
            }

            return allRentalsForOneCollectiveCategory;

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer les locations pour la categorie " + category);
        }
    }

    // [IMPLEMENT] (Research n°2) List all rentals that have had the same type of return problem
    @Override
    public ArrayList<SecondResearch> getRentalsBasedOnSameTypeReturnProblem(int idTypeOfProblemExitProblemRental) throws DAOException {
        try {
            ArrayList<SecondResearch> allRentalsBasedOnSameTypeReturnProblem = new ArrayList<>();

            String sql = """
                    SELECT r.startDate, r.returnDate, o.name, o.deposit, o.maxRentalPeriod, c.name, c.emailAddress FROM rental r
                        JOIN problemexitrental p on r.idRental = p.idRental
                        JOIN collective c on c.idCollective = r.idTenant
                        JOIN oneobject o on o.idObject = r.idObject
                    WHERE p.idTypeOfProblemRental = ?;""";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idTypeOfProblemExitProblemRental);

            ResultSet data = statement.executeQuery();

            while (data.next()) {
                GregorianCalendar startDate = new GregorianCalendar(), endDate = new GregorianCalendar();
                startDate.setTime(data.getDate("r.startDate"));
                endDate.setTime(data.getDate("r.returnDate"));

                allRentalsBasedOnSameTypeReturnProblem.add(new SecondResearch(
                        startDate,
                        endDate,
                        data.getString("o.name"),
                        data.getInt("o.deposit"),
                        data.getInt("o.maxRentalPeriod"),
                        data.getString("c.name"),
                        data.getString("c.emailAddress")
                ));
            }

            return allRentalsBasedOnSameTypeReturnProblem;

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer la liste de toutes es locations ayant eu le même type de problème de retour");
        }
    }

    // [IMPLEMENT] (Research n°3) All rentals between 2 dates
    @Override
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException {
        ArrayList<ThirdResearch> rentalBetween2Dates = new ArrayList<>();

        try {
            String sql = """
                    select o.name, o.purchaseDate, o.purchasePrice, p.invocedPrice, p.note, r.rentalManager
                    from rental r
                    JOIN problemexitrental p on r.idRental = p.idRental
                    JOIN oneobject o on o.idObject = r.idObject
                    WHERE r.startDate BETWEEN ? AND ? ;""";

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

    // [IMPLEMENT] Recovering a location based on its ID
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
    private Rental sqlToJavaObject(ResultSet data) throws SQLException {
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
