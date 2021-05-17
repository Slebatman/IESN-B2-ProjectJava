package view;

import controler.CollectiveControler;
import controler.ObjectControler;
import Model.Collective;
import Model.OneObject;
import dataAcces.exception.DAOConfigurationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UpdateObjectWindow extends JFrame{
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod;
    private JTextField textName, textPrice, textDeposit, textPeriod;
    private JRadioButton commandable, notCommandable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio, panelButton, panelWindow, panelCollectives, panelDate;
    private JButton buttonUpdate, buttonCancel, buttonDate;
    private JFormattedTextField dateArea;
    private ObjectControler addObjectControler;
    private ArrayList<Collective> arrayCollectives;
    private CollectiveControler collectiveControler;
    private ArrayList<String> collectives;
    private ArrayList<OneObject> arrayObjects;
    private ObjectControler objectControler;
    private ArrayList<String> objects;
    private JComboBox<String> listObjects;
    private GregorianCalendar dateObject;
    private JSpinner spinnerDate, spinnerPeriod;
    private OneObject object;
    private Boolean commandableValue;
    private OneObject objectDefault;
    private SimpleDateFormat formatDate;

    UpdateObjectWindow() throws DAOConfigurationException {
        super("Update an object");
        setBounds(250, 200, 800, 450);
        collectiveControler = new CollectiveControler();
        arrayCollectives = collectiveControler.getAllCollectives();
        collectives = new ArrayList<String>();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }
        listCollective = new JComboBox(collectives.toArray());
        listCollective.addActionListener(new RefreshObjects());

        objectControler = new ObjectControler();

        int idCollective = 1;
        arrayObjects = objectControler.getAllObjectsForOneCollective(idCollective);
        listObjects = new JComboBox<String>();
        for(OneObject object : arrayObjects){
            listObjects.addItem(object.getName());
        }
        listObjects.addActionListener(new RefreshValues());

        objectDefault = arrayObjects.get(0);

        this.setLayout(new FlowLayout());


        formatDate = new SimpleDateFormat("dd/MM/yyyy");

        SpinnerDateModel model = new SpinnerDateModel();
        spinnerDate = new JSpinner(model);
        spinnerDate.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(editor);
        //spinnerDate.setEnabled(false);
        SpinnerNumberModel modelSpinnerPeriod = new SpinnerNumberModel(1.0, 1.0, 100.0, 1.0);
        spinnerPeriod = new JSpinner(modelSpinnerPeriod);



        labelCollective = new JLabel("Collectif : ");
        labelName = new JLabel("Nom de l'objet : ");
        labelCommandable = new JLabel("Commandable : ");
        labelDate = new JLabel("Date de l'achat (dd/mm/yyyy) : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué :");
        textName = new JTextField();
        dateArea = new JFormattedTextField(formatDate);
        textDeposit = new JTextField();
        textPrice = new JTextField();
        textPeriod = new JTextField();
        commandable = new JRadioButton("Yes");
        notCommandable = new JRadioButton("No");
        radioGroup = new ButtonGroup();
        radioGroup.add(notCommandable);
        radioGroup.add(commandable);
        panelRadio = new JPanel();
        panelRadio.add(commandable);
        panelRadio.add(notCommandable);
        buttonUpdate = new JButton("Update");
        buttonCancel= new JButton("Cancel");
        panel = new JPanel();
        panelButton = new JPanel();
        panelWindow = new JPanel();
        panelCollectives = new JPanel();
        panelCollectives.setLayout(new GridLayout(1,2, 5, 5));
        panelCollectives.add(labelCollective);
        panelCollectives.add(listCollective);
        if(objectDefault.isCommendable()){
            commandable.setSelected(true);
            notCommandable.setSelected(false);
        }else{
            commandable.setSelected(false);
            notCommandable.setSelected(true);
        }
        if(objectDefault.getPurchasePrice() != Types.NULL){
            textPrice.setText(objectDefault.getPurchasePrice() + "");
        }
        if(objectDefault.getDeposit() != Types.NULL){
            textDeposit.setText(objectDefault.getDeposit() +"");
        }
        GregorianCalendar date = objectDefault.getPurchaseDate();
        formatDate.setCalendar(date);
        buttonDate = new JButton("Ajouter");
        buttonDate.addActionListener(new AddDate());
        if(date != null){
            spinnerDate.setValue(date.getTime());
            spinnerDate.setEnabled(true);
            buttonDate.setText("Retirer");
        }else{
            spinnerDate.setEnabled(false);
            buttonDate.setText("Ajouter");
        }
        spinnerPeriod.setValue(objectDefault.getMaxRentalPeriod());
        panelDate = new JPanel();

        panelDate.setLayout(new GridLayout(1,2, 10, 5));
        panelDate.add(labelDate);
        panelDate.add(buttonDate);
        spinnerDate.setEnabled(false);
        panel.setLayout(new GridLayout(7,2, 10, 5));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(listObjects);
        panel.add(labelCommandable);
        panel.add(panelRadio);
        panel.add(panelDate);
        panel.add(spinnerDate);
        panel.add(labelPrice);
        panel.add(textPrice);
        panel.add(labelDeposit);
        panel.add(textDeposit);
        panel.add(labelPeriod);
        panel.add(spinnerPeriod);

        dateObject = new GregorianCalendar();
        dateObject.setTime((Date)spinnerDate.getModel().getValue());

        buttonCancel.addActionListener(new CancelButtonListener());
        panelButton.add(buttonCancel);
        buttonUpdate.addActionListener(new UpdateObject());
        panelButton.add(buttonUpdate);

        RadioButtonListener listener = new RadioButtonListener();
        commandable.addItemListener(listener);
        notCommandable.addItemListener(listener);

        panelWindow.setLayout(new GridLayout(2,1, 10, 30));;
        panelWindow.add(panel);
        panelWindow.add(panelButton);
        panelWindow.setVisible(true);
        this.add(panelWindow);
        setVisible(true);
    }

    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            UpdateObjectWindow.this.dispose();
        }
    }

    private class UpdateObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            dateObject.setTime((Date)spinnerDate.getModel().getValue());
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;
            try {
                idCollective = collectiveControler.searchACollectiveIDBasedName(value);
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
            int indexObject = listObjects.getSelectedIndex();
            OneObject objectTest = arrayObjects.get(indexObject);
            int idObject = objectTest.getIdObject();

            boolean price = false;
            boolean deposit = !textDeposit.getText().equals("");
            if(!textPrice.getText().equals("")){
                price = true;
            }
            if(buttonDate.getText().equals("Ajouter")){
                dateObject = null;
            }
            object = new OneObject(idObject, objectTest.getName(), idCollective, commandableValue, dateObject, (price ? Double.parseDouble(textPrice.getText()) : Types.NULL), (deposit ? Integer.parseInt(textDeposit.getText()): Types.NULL), (Integer)spinnerPeriod.getValue());
            try {
                objectControler.updateAnObject(object);
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
            UpdateObjectWindow.this.dispose();
        }
    }
    private class RefreshObjects implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            String value = listCollective.getSelectedItem().toString();
            int idCollective = 0;
            try {
                idCollective = collectiveControler.searchACollectiveIDBasedName(value);
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
            //System.out.println(listObjects.getSelectedIndex());

            try {
                arrayObjects = objectControler.getAllObjectsForOneCollective(idCollective);
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
            listObjects.removeAllItems();
            for(OneObject object : arrayObjects){
                listObjects.addItem(object.getName());
            }
        }
    }

    private class RefreshValues implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            int indexObject = listObjects.getSelectedIndex();
            if(indexObject == -1){
                indexObject =0;
            }
            objectDefault = arrayObjects.get(indexObject);
            if(objectDefault.isCommendable()){
                commandable.setSelected(true);
                notCommandable.setSelected(false);
            }else{
                commandable.setSelected(false);
                notCommandable.setSelected(true);
            }
            if(objectDefault.getPurchasePrice() != Types.NULL){
                textPrice.setText(objectDefault.getPurchasePrice() + "");
            }
            if(objectDefault.getDeposit() != Types.NULL){
                textDeposit.setText(objectDefault.getDeposit() +"");
            }

            spinnerPeriod.setValue(objectDefault.getMaxRentalPeriod());
            GregorianCalendar date = objectDefault.getPurchaseDate();
            formatDate.setCalendar(date);
            if(date != null){
                spinnerDate.setValue(date.getTime());
                spinnerDate.setEnabled(true);
                buttonDate.setText("Retirer");
            }else{
                spinnerDate.setEnabled(false);
                buttonDate.setText("Ajouter");
            }

        }
    }

    private class RadioButtonListener implements ItemListener {
        public void itemStateChanged(ItemEvent event){
            if(event.getSource() == commandable && event.getStateChange() == ItemEvent.SELECTED) commandableValue = true;
            else if(event.getSource() == notCommandable && event.getStateChange() == ItemEvent.SELECTED) commandableValue = false;
        }
    }

    private class AddDate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(buttonDate.getText().equals("Ajouter")){
                spinnerDate.setEnabled(true);
                buttonDate.setText("Retirer");
            }else{
                spinnerDate.setEnabled(false);
                buttonDate.setText("Ajouter");
            }

        }
    }
}
