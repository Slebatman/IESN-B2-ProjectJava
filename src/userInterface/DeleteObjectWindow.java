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
    JFrame frame;
    private JComboBox listCollective;
    private JComboBox<String> listObjects;
    private JPanel panelCollectives, panelObjects, panelWindow, panelButton, mainPanel;
    private JLabel labelCollective, labelObject;
    private JButton buttonCancel, buttonDelete;
    private ArrayList<Collective> arrayCollectives;
    private ArrayList<OneObject> arrayObjects;
    private CollectiveController collectiveController;
    private OneObjectController oneObjectController;
    private ArrayList<String> collectives;
    private ArrayList<String> objects;

    DeleteObjectWindow(JFrame frame) throws DAOException, ModelException, BusinessException, ControllerException {
        this.frame = frame;
        frame.getContentPane().removeAll();
        this.setLayout(new FlowLayout());

        //Controlers et récupérations de listes
        collectiveController = new CollectiveController();
        oneObjectController = new OneObjectController();
        collectives = new ArrayList<String>();
        objects = new ArrayList<String>();
        arrayCollectives = collectiveController.getAllCollectives();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }

        int idCollective = 1;
        arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
        listObjects = new JComboBox<String>();
        for(OneObject object : arrayObjects){
            listObjects.addItem(object.getName());
        }

        panelWindow = new JPanel();
        panelWindow.setLayout(new GridLayout(2,1, 50, 20));

        panelCollectives = new JPanel();
        panelButton = new JPanel();
        panelObjects = new JPanel();
        listCollective = new JComboBox(collectives.toArray());
        listCollective.addActionListener(new PanelObject());

        labelCollective = new JLabel("Collectif : ");
        labelObject = new JLabel("Objet : ");

        panelCollectives.setLayout(new GridLayout(1,2, 10, 5));
        panelObjects.setLayout(new GridLayout(1,2, 10, 5));

        panelCollectives.add(labelCollective);
        panelCollectives.add(listCollective);

        panelObjects.add(labelObject);
        panelObjects.add(listObjects);

        panelCollectives.setVisible(true);
        panelObjects.setVisible(true);

        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(new CancelButtonListener());
        buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new DeleteObjectListener());

        panelButton.add(buttonCancel);
        panelButton.add(buttonDelete);

        panelWindow.add(panelCollectives);
        panelWindow.add(panelObjects);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1, 10, 150));
        mainPanel.add(panelWindow);
        mainPanel.add(panelButton);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();

        setVisible(true);
    }

    private class PanelObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;
            try {
                idCollective = collectiveController.getACollectiveIDBasedName(value);
                arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get collective values Exception", JOptionPane.ERROR_MESSAGE);
            }
            listObjects.removeAllItems();
            for(OneObject object : arrayObjects){
                listObjects.addItem(object.getName());
            }
        }
    }

    private class CancelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            frame.getContentPane().removeAll();
            frame.add(new MainWindowPanel());
            frame.revalidate();
            frame.repaint();
        }
    }

    private class DeleteObjectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;

            try {
                idCollective = collectiveController.getACollectiveIDBasedName(value);
                OneObject objetTest = arrayObjects.get(listObjects.getSelectedIndex());
                oneObjectController.deleteAnObject(objetTest);
                arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Delete an object Exception", JOptionPane.ERROR_MESSAGE);
            }
            listObjects.removeAllItems();
            for(OneObject object : arrayObjects){
                listObjects.addItem(object.getName());
            }
        }
    }
}
