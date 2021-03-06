package dataAcces;

import exception.ModelException;
import model.Delay;
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
    public ArrayList<Rental> selectListRental(PreparedStatement statement) throws SQLException, ModelException {
        ArrayList<Rental> listRental = new ArrayList<>();
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            listRental.add(sqlToJavaObject(data));
        }

        return listRental;
    }

    // Generic function to select one object
    public Rental selectOneRental(PreparedStatement statement) throws SQLException, ModelException {
        ResultSet data = statement.executeQuery();

        while (data.next()) {
            return sqlToJavaObject(data);
        }
        return null;
    }

    // [IMPLEMENT] (Research n°1) All rentals for a category of collectives
    @Override
    public ArrayList<FirstResearch> getRentalsForOneCollectiveCategory(String category) throws DAOException, ModelException {
        try {
            ArrayList<FirstResearch> allRentalsForOneCollectiveCategory = new ArrayList<>();

            String sql = "SELECT r.startDate, o.name, c.name FROM rental r JOIN collective c ON (r.idTenant = c.idCollective) JOIN oneobject o on o.idOneObject = r.idOneObject WHERE c.category = ?";
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
    public ArrayList<SecondResearch> getRentalsBasedOnSameTypeReturnProblem(int idTypeOfProblemExitProblemRental) throws DAOException, ModelException {
        try {
            ArrayList<SecondResearch> allRentalsBasedOnSameTypeReturnProblem = new ArrayList<>();

            String sql = """
                    SELECT r.startDate, r.returnDate, o.name, o.deposit, o.maxRentalPeriod, c.name, c.emailAddress FROM rental r
                        JOIN problemexitrental p on r.idRental = p.idRental
                        JOIN collective c on c.idCollective = r.idTenant
                        JOIN oneobject o on o.idOneObject = r.idOneObject
                    WHERE p.idTypeOfProblemRental = ?;""";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idTypeOfProblemExitProblemRental);

            ResultSet data = statement.executeQuery();

            while (data.next()) {
                GregorianCalendar startDate = new GregorianCalendar(), endDate = new GregorianCalendar();
                startDate.setTime(data.getDate("r.startDate"));

                data.getDate("r.returnDate");
                if(!data.wasNull()) {
                    endDate.setTime(data.getDate("r.returnDate"));
                }

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
            throw new DAOException("Erreur SQL : impossible de récuperer la liste de toutes les locations ayant eu le même type de problème de retour");
        }
    }

    // [IMPLEMENT] (Research n°3) All rentals between 2 dates
    @Override
    public ArrayList<ThirdResearch> getRentalBetween2Dates(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException {
        ArrayList<ThirdResearch> rentalBetween2Dates = new ArrayList<>();

        try {
            String sql = """
                    select o.name, o.purchaseDate, o.purchasePrice, p.invocedPrice, p.note, r.rentalManager
                    from rental r
                    JOIN problemexitrental p on r.idRental = p.idRental
                    JOIN oneobject o on o.idOneObject = r.idOneObject
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
    public Rental getOneRentalBasedID(int idRental) throws DAOException, ModelException {
        try {
            String sql = "SELECT * FROM rental WHERE idRental = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idRental);
            return selectOneRental(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL lors de la récupération d'une location");
        }
    }

    // [IMPLEMENT] (Job task) Late rentals and number of days in delay.
    @Override
    public ArrayList<Delay> getJobTask() throws DAOException, ModelException{
        ArrayList<Delay> rentalsWithDelays = new ArrayList<>();

        try{
            String sql = """
                    SELECT c.name, r.rentalManager, r.idOneObject, o.name, r.startDate, o.maxRentalPeriod, o.deposit
                    FROM rental r
                    JOIN oneobject o on r.idOneObject = o.idOneObject
                    JOIN collective c on c.idCollective = r.idTenant
                    WHERE r.returnDate IS null;
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                GregorianCalendar startDate = new GregorianCalendar();
                startDate.setTime(data.getDate("r.startDate"));

                Delay delay = new Delay();

                delay.setNameCollectiveOwner(data.getString("c.name"));
                delay.setRentalManager(data.getString("r.rentalManager"));
                delay.setIdOneObject(data.getInt("r.idOneObject"));
                delay.setNameOneObject(data.getString("o.name"));
                delay.setStartDate(startDate);
                delay.setMaxRentalPeriod(data.getInt("o.maxRentalPeriod"));
                data.getInt("o.deposit");
                if (!data.wasNull()) {
                    delay.setDeposit(data.getInt("o.deposit"));
                }
                rentalsWithDelays.add(delay);
            }

            return rentalsWithDelays;

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : recherche des retards dans les locations n'est pas possible");
        }
    }


    // Convert sql to java object Rental
    private Rental sqlToJavaObject(ResultSet data) throws SQLException, ModelException {
        GregorianCalendar startDate = new GregorianCalendar(), endDate = new GregorianCalendar();
        Rental rental = new Rental();

        // Not null value
        rental.setIdRental(data.getInt("idRental"));
        startDate.setTime(data.getDate("startDate"));
        rental.setStartDate(startDate);
        rental.setIdObject(data.getInt("idOneObject"));
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
