package dataAcces;

import dataAcces.dao.ICollectiveDAO;
import exception.DAOException;
import model.Collective;

import java.sql.*;
import java.util.ArrayList;

public class CollectiveDB implements ICollectiveDAO {
    // Data base access
    private final Connection connection = SingletonConnexion.getConnection();

    // [IMPLEMENT] Add a new collective
    @Override
    public void insert(Collective c) throws DAOException {
        try {
            String sql = "INSERT INTO collective (name, category, physicalAddress, emailAddress) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2, c.getCategory());
            statement.setString(3, c.getPhysicalAddress());
            statement.setString(4, c.getEmailAddress());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible d'ajouter le collectif en base de données");
        }
    }

    // [IMPLEMENT] Update a collective
    @Override
    public void update(Collective c) throws DAOException {
        try {
            String sql = "UPDATE collective SET name = ?, category = ?, physicalAddress = ?, emailAddress = ? where idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2,c.getCategory());
            statement.setString(3,c.getPhysicalAddress());
            statement.setString(4,c.getEmailAddress());
            statement.setInt(5,c.getIdCollective());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de mettre à jour le collectif en base de données");
        }
    }

    // [IMPLEMENT] Delete a collective
    @Override
    public void delete(int idCollective) throws DAOException {
        try {
            String sql = "DELETE FROM collective WHERE idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de supprimer le collectif de la base de données");
        }
    }

    // SELECT
    // Generic function to select several collective
    private ArrayList<Collective> selectListOfCollective(PreparedStatement statement) throws SQLException {

        ArrayList<Collective> listOfCollective = new ArrayList<>();
        ResultSet data = statement.executeQuery();

        while(data.next()) {
            Collective collective = sqlToJavaObject(data);
            listOfCollective.add(collective);
        }

        return listOfCollective;
    }

    // Generic function to select a specific collective
    private Collective selectACollective(PreparedStatement statement) throws SQLException {

        ResultSet data = statement.executeQuery();
        while (data.next()) {
            return this.sqlToJavaObject(data);
        }
        return null;
    }

    // [IMPLEMENT] Retrieve all collective data from the database
    @Override
    public ArrayList<Collective> getAllCollective() throws DAOException {

        try {
            String sql = "SELECT * FROM collective";
            PreparedStatement statement = connection.prepareStatement(sql);

            return selectListOfCollective(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer l'ensemble des collectifs en base de données");
        }
    }

    // [IMPLEMENT] Search for a collective based on its id
    @Override
    public Collective getACollectiveBasedId(int idCollective) throws DAOException {

        try {
            String sql = "SELECT * FROM collective WHERE idCollective = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCollective);

            return selectACollective(statement);

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer le collectif sur base l'identifiant : " + idCollective);
        }
    }

    // [IMPLEMENT] Retrieving a collective's ID based on its name
    @Override
    public int getACollectiveIDBasedName(String name) throws DAOException {
        try {
            String sql = "SELECT * FROM collective WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            return selectACollective(statement).getIdCollective();

        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuper l'identifiant du collectif '" + name + "' ");
        }
    }

    // [IMPLEMENT] Separately retrieve the category of Collective
    @Override
    public ArrayList<String> getDistinctCategoryCollective() throws DAOException {

        try {
            ArrayList<String> distinctNameCollective = new ArrayList<>();
            String sql = "SELECT DISTINCT category FROM collective";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while (data.next()) {
                distinctNameCollective.add(data.getString("category"));
            }
            return distinctNameCollective;
        } catch (SQLException e) {
            throw new DAOException("Erreur SQL : impossible de récuperer les categories distinctes de la table collective");
        }
    }

    // Function convert sql to java object Collective
    private Collective sqlToJavaObject(ResultSet data) throws SQLException {
        return new Collective(
            data.getInt("idCollective"),
            data.getString("name"),
            data.getString("category"),
            data.getString("physicalAddress"),
            data.getString("emailAddress"));
    }
}
