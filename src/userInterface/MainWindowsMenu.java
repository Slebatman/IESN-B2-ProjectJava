package userInterface;

import controller.OneObjectController;
import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowsMenu extends JMenuBar {
    // Variables
    JFrame frame;
    private JMenu application, objects, research, delays;
    JMenuItem leave, createObject, updateObject, deleteObject, showObjects, firstSearch, secondSearch, thirdSearch, delaysManagement;

    // Constructor
    public MainWindowsMenu(JFrame frame) {
        this.frame = frame;
        this.frame.add(new JLabel("Test 1"), BorderLayout.WEST);

        // Main menu
        application = new JMenu("Application");
        objects = new JMenu("Objet");
        research = new JMenu("Recherche");
        delays = new JMenu("Retard");
        add(objects);
        add(research);
        add(delays);
        add(application);

        // Application menu
        leave = new JMenuItem("Quitter");
        leave.addActionListener(new ExitListener());
        application.add(leave);

        // Object menu
        createObject = new JMenuItem("Ajouter");
        createObject.addActionListener(new AddObject());
        objects.add(createObject);

        updateObject = new JMenuItem("Mettre à jour");
        updateObject.addActionListener(new UpdateObject());
        objects.add(updateObject);

        deleteObject = new JMenuItem("Supprimer");
        deleteObject.addActionListener(new DeleteObject());
        objects.add(deleteObject);

        showObjects = new JMenuItem("Listing complet");
        showObjects.addActionListener(new ListingObjects());
        objects.add(showObjects);

        // Research menu
        firstSearch = new JMenuItem("Via la catégorie");
        firstSearch.addActionListener(new FirstSearch());
        research.add(firstSearch);

        secondSearch = new JMenuItem("Via le type de problème de retour");
        secondSearch.addActionListener(new SecondSearch());
        research.add(secondSearch);

        thirdSearch = new JMenuItem("Entre 2 dates");
        thirdSearch.addActionListener(new ThirdSearch());
        research.add(thirdSearch);

        // Delay menu
        delaysManagement = new JMenuItem("Listing complet");
        delaysManagement.addActionListener(new Delays());
        delays.add(delaysManagement);

    }

    // Show message error
    private void showErrorMessage(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    // Exit application
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            new OneObjectController().closeConnection();
            System.exit(0);
        }
    }

    // Create and add an object
    private class AddObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                new AddObjectWindow();

            } catch (DAOException | ModelException e) {
                showErrorMessage("Erreur lors de l'ajout", e.getMessage());
            }
        }
    }

    // Delete an object
    private class DeleteObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                new DeleteObjectWindow(frame);

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                showErrorMessage("Erreur lors de la suppression", e.getMessage());
            }
        }
    }

    // Update an object
    private class UpdateObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                new UpdateObjectWindow();

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                showErrorMessage("Erreur lors de la mise à jour", e.getMessage());
            }
        }
    }

    // Show all objects
    private class ListingObjects implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                new ListingObjetWindow();

            } catch (DAOException | ModelException e) {
                showErrorMessage("Erreur lors de l'affichage de l'ensemble des objets", e.getMessage());
            }
        }
    }

    // (Research n°1) All rentals for a category of collectives
    private class FirstSearch implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                new FirstSearchForm();
            }catch(DAOException e){
                showErrorMessage("Erreur lors de la recherche sur base d'une catégorie", e.getMessage());
            }

        }
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    private class SecondSearch implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                new SecondSearchForm();

            } catch (DAOException e) {
                showErrorMessage("Erreur lors de la recherche n°2", e.getMessage());
            }
        }
    }

    // (Research n°3) All rentals between 2 dates
    private class ThirdSearch implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            new ThirdSearchForm();
        }
    }

    // (Job task)
    private class Delays implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try{
                new RentalDelaysWindow();
            }catch(DAOException | ModelException e){
                showErrorMessage("Erreur lors du listing des retards", e.getMessage());
            }
        }
    }
}


