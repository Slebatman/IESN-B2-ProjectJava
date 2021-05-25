package userInterface;

import controller.CollectiveController;
import controller.OneObjectController;
import exception.BusinessException;
import exception.ControllerException;
import exception.ModelException;
import model.Collective;
import model.OneObject;
import exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteObjectWindow extends JLabel {
    // Variables
    JFrame frame;
    private JComboBox listCollective;
    private JComboBox<String> listObjects;
    private JPanel panelCollectives, panelObjects, panelDeleteArea, panelButton, mainPanel;
    private JLabel labelCollective, labelObject;
    private JButton buttonCancel, buttonDelete;
    private ArrayList<Collective> arrayCollectives;
    private ArrayList<OneObject> arrayObjects;
    private CollectiveController collectiveController;
    private OneObjectController oneObjectController;
    private ArrayList<String> collectives, objects;

    // Constructors
    DeleteObjectWindow(JFrame frame) throws DAOException, ModelException, BusinessException, ControllerException {
        // Display the form in the same section as the welcome message --> cleaning main Frame
        this.frame = frame;
        frame.getContentPane().removeAll();

        // Controller
        collectiveController = new CollectiveController();
        oneObjectController = new OneObjectController();

        // Create & initialize in memory listing Collective & Object
        collectives = new ArrayList<String>();
        objects = new ArrayList<String>();

        arrayCollectives = collectiveController.getAllCollectives();
        for (Collective col : arrayCollectives) {
            collectives.add(col.getName());
        }

        int idCollective = arrayCollectives.get(1).getIdCollective();
        arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
        listObjects = new JComboBox<String>();
        for (OneObject object : arrayObjects) {
            listObjects.addItem(object.getName());
        }

        // Create panels
        panelDeleteArea = new JPanel();
        panelCollectives = new JPanel();
        panelObjects = new JPanel();
        panelButton = new JPanel();

        // Delete area
        panelDeleteArea.setLayout(new GridLayout(2, 1, 50, 20));

        // Panel Collective
        listCollective = new JComboBox(collectives.toArray());
        listCollective.addActionListener(new UpdatePanelObject());
        labelCollective = new JLabel("Collectif : ");
        panelCollectives.setLayout(new GridLayout(1, 2, 10, 5));
        panelCollectives.add(labelCollective);
        panelCollectives.add(listCollective);
        panelCollectives.setVisible(true);

        // Panel Object
        labelObject = new JLabel("Objet : ");
        panelObjects.setLayout(new GridLayout(1, 2, 10, 5));
        panelObjects.add(labelObject);
        panelObjects.add(listObjects);
        panelObjects.setVisible(true);

        // Panel Button
        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(new CancelButtonListener());
        buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new DeleteObjectListener());

        panelButton.add(buttonCancel);
        panelButton.add(buttonDelete);

        panelDeleteArea.add(panelCollectives);
        panelDeleteArea.add(panelObjects);

        // Add all object in mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 10, 150));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        mainPanel.add(panelDeleteArea);
        mainPanel.add(panelButton);

        // Add all in frame en repaint
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        setVisible(true);
    }

    // Update of the object list according to the selected collective
    private class UpdatePanelObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String collectiveSelect = listCollective.getSelectedItem().toString();

            try {
                int idCollective = collectiveController.getACollectiveIDBasedName(collectiveSelect);
                arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);

                listObjects.removeAllItems();
                for (OneObject object : arrayObjects) {
                    listObjects.addItem(object.getName());
                }

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                showMessage(e.getMessage());
            }
        }
    }

    // If the action is cancelled, display a message in the main window
    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Cleaning main frame
            frame.getContentPane().removeAll();

            // Create new label
            JLabel label = new JLabel("Pour continuer, utilisez le menu ci-dessus.");
            label.setHorizontalAlignment(JLabel.CENTER);

            // Add & repaint
            frame.add(label, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        }
    }

    // Deleting an object
    private class DeleteObjectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {

            String value = listCollective.getSelectedItem().toString();

            try {
                // Retrieving information via the form
                int idCollective = collectiveController.getACollectiveIDBasedName(value);
                int indexListObjects = listObjects.getSelectedIndex();

                // Some collectives do not necessarily have a purpose
                if(indexListObjects >= 0) {
                    // Creation of the object to delete
                    OneObject objetToDelete = arrayObjects.get(listObjects.getSelectedIndex());

                    // Ask confirmation
                    int confirmationDelete = JOptionPane.showConfirmDialog(
                            frame,
                            "Attention, la suppression de l'objet entrainera la suppression des locations le concernant. \n Voulez-vous continuer ?",
                            "Confirmation de la suppression.",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE
                    );

                    if (confirmationDelete == 0) {
                        // Delete
                        oneObjectController.deleteAnObject(objetToDelete);
                        System.out.println("Objet supprimé !");

                        // Update form for a new delete action
                        arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
                        listObjects.removeAllItems();
                        for (OneObject object : arrayObjects) {
                            listObjects.addItem(object.getName());
                        }
                    }
                }

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                showMessage(e.getMessage());
            }
        }
    }

    // Show error message
    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erreur lors de la suppression", JOptionPane.ERROR_MESSAGE);
    }
}

