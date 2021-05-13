package view;

import controler.CollectiveControler;
import type.Collective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteObjectWindow extends JFrame{
    private JComboBox listCollective, listObjects;
    private JPanel panelCollectives, panelObjects, panelWindow, panelButton, mainPanel;
    private JLabel labelCollective, labelObject;
    private JButton buttonCancel, buttonDelete, buttonCollectives;
    private ArrayList<Collective> arrayCollectives;
    private CollectiveControler collectiveControler;
    private ArrayList<String> collectives;

    DeleteObjectWindow(){
        super("Delete an object");
        setBounds(150, 150, 400, 400);
        collectiveControler = new CollectiveControler();
        arrayCollectives = collectiveControler.getAllCollectives();
        collectives = new ArrayList<String>();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }
        String[] objects = {"gobelets", "tables", "cruches", "micro" ,"banc"};

        this.setLayout(new FlowLayout());

        panelWindow = new JPanel();
        panelWindow.setLayout(new GridLayout(2,1, 50, 20));

        panelCollectives = new JPanel();
        panelButton = new JPanel();
        panelObjects = new JPanel();
        listCollective = new JComboBox(collectives.toArray());
        listObjects = new JComboBox(objects);
        labelCollective = new JLabel("Collectif : ");
        labelObject = new JLabel("Objet : ");

        panelCollectives.setLayout(new GridLayout(1,2, 10, 5));
        panelObjects.setLayout(new GridLayout(1,2, 10, 5));

        panelCollectives.add(labelCollective);
        panelCollectives.add(listCollective);

        panelObjects.add(labelObject);
        panelObjects.add(listObjects);

        panelCollectives.setVisible(true);
        panelObjects.setVisible(false);

        buttonCollectives = new JButton("Ok");
        buttonCollectives.addActionListener(new PanelObject());

        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(new CancelButtonListener());
        buttonDelete = new JButton("Delete");
        buttonDelete.setVisible(false);

        panelButton.add(buttonCancel);
        panelButton.add(buttonDelete);

        panelWindow.add(panelCollectives);
        panelWindow.add(panelObjects);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1, 10, 150));
        mainPanel.add(panelWindow);
        mainPanel.add(panelButton);

        this.add(mainPanel);
        this.add(buttonCollectives);
        setVisible(true);
    }

    private class PanelObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            panelObjects.setVisible(true);
            buttonDelete.setVisible(true);
        }
    }

    private class CancelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            DeleteObjectWindow.this.dispose();
        }
    }

    private class DeleteObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){

        }
    }
}
