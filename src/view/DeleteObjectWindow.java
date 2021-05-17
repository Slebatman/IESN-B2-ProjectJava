package view;

import controler.CollectiveControler;
import controler.ObjectControler;
import Model.Collective;
import Model.OneObject;
import dataAcces.exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteObjectWindow extends JFrame{
    private JComboBox listCollective;
    private JComboBox<String> listObjects;
    private JPanel panelCollectives, panelObjects, panelWindow, panelButton, mainPanel;
    private JLabel labelCollective, labelObject;
    private JButton buttonCancel, buttonDelete;
    private ArrayList<Collective> arrayCollectives;
    private ArrayList<OneObject> arrayObjects;
    private CollectiveControler collectiveControler;
    private ObjectControler objectControler;
    private ArrayList<String> collectives;
    private ArrayList<String> objects;
    private int idCollective;

    DeleteObjectWindow() throws DAOException {
        super("Delete an object");
        setBounds(150, 150, 400, 400);

        collectiveControler = new CollectiveControler();
        objectControler = new ObjectControler();
        collectives = new ArrayList<String>();
        objects = new ArrayList<String>();
        arrayCollectives = collectiveControler.getAllCollectives();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }
        arrayCollectives = collectiveControler.getAllCollectives();

        int idCollective = 1;
        arrayObjects = objectControler.getAllObjectsForOneCollective(idCollective);
        listObjects = new JComboBox<String>();
        for(OneObject object : arrayObjects){
            listObjects.addItem(object.getName());
        }

        this.setLayout(new FlowLayout());

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

        this.add(mainPanel);
        setVisible(true);
    }

    private class PanelObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;
            // Todo : implement exception
            try {
                idCollective = collectiveControler.searchACollectiveIDBasedName(value);
                arrayObjects = objectControler.getAllObjectsForOneCollective(idCollective);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            //System.out.println(listObjects.getSelectedIndex());

            listObjects.removeAllItems();
            for(OneObject object : arrayObjects){
                listObjects.addItem(object.getName());
            }
        }
    }

    private class CancelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            DeleteObjectWindow.this.dispose();
        }
    }

    private class DeleteObjectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;
            // Todo : implement exception
            try {
                idCollective = collectiveControler.searchACollectiveIDBasedName(value);
                OneObject objetTest = arrayObjects.get(listObjects.getSelectedIndex());
                objectControler.deleteAnObject(objetTest);
                arrayObjects = objectControler.getAllObjectsForOneCollective(idCollective);
            } catch (DAOException e) {
                e.printStackTrace();
            }

            listObjects.removeAllItems();
            for(OneObject object : arrayObjects){
                listObjects.addItem(object.getName());
            }
        }
    }
}
