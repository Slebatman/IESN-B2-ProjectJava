package view;

import exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private Container frameContainer;
    private MainWindowPanel panel;
    private JMenuBar menu;
    private JMenu application, objects, research;
    JMenuItem leave, createObject, updateObject, deleteObject, showObjects, firstSearch, secondSearch, thirdSearch;
    public MainWindow(){
        super("Gestion d'inventaire");
        setBounds(100, 100, 500, 500);

        panel = new MainWindowPanel();

        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(panel, BorderLayout.CENTER);

        menu = new JMenuBar();
        this.setJMenuBar(menu);
        application = new JMenu("Application");
        objects = new JMenu("Object");
        research = new JMenu("Research");

        menu.add(application);
        menu.add(objects);
        menu.add(research);

        leave = new JMenuItem("Leave");
        leave.addActionListener(new ExitListener());
        application.add(leave);

        createObject = new JMenuItem("Create");
        createObject.addActionListener(new AddObject());
        objects.add(createObject);

        updateObject = new JMenuItem("Update");
        updateObject.addActionListener(new UpdateObject());
        objects.add(updateObject);

        deleteObject = new JMenuItem("Delete");
        deleteObject.addActionListener(new DeleteObject());
        objects.add(deleteObject);

        showObjects = new JMenuItem("Show all");
        showObjects.addActionListener(new ListingObjects());
        objects.add(showObjects);

        firstSearch = new JMenuItem("Search rentals by collective category");
        firstSearch.addActionListener(new FirstSearch());
        research.add(firstSearch);

        secondSearch = new JMenuItem("Search rentals by type of problem");
        secondSearch.addActionListener(new SecondSearch());
        research.add(secondSearch);

        thirdSearch = new JMenuItem("Search rentals between 2 dates");
        thirdSearch.addActionListener(new ThirdSearch());
        research.add(thirdSearch);


        setVisible(true);
    }

    private class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            System.exit(0);
        }
    }

    private class AddObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                AddObjectWindow addObjectWindow = new AddObjectWindow();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of collective Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DeleteObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                DeleteObjectWindow deleteWindow = new DeleteObjectWindow();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of collective or Objects Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class UpdateObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                UpdateObjectWindow updateWindow = new UpdateObjectWindow();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of collective Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ListingObjects implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                ListingObjetWindow listWindow = new ListingObjetWindow();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of Objects Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class FirstSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                FirstSearchForm firstSearchForm = new FirstSearchForm();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of Rentals by category Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SecondSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try {
                SecondSearchForm secondSearchForm = new SecondSearchForm();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of Rentals problems by typeOfProblem Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ThirdSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            ThirdSearchForm thirdSearchForm = new ThirdSearchForm();
            }

        }

}
