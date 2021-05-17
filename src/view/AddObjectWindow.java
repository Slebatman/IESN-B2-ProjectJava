package view;
import controler.*;
import Model.Collective;
import Model.OneObject;
import dataAcces.exception.DAOConfigurationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddObjectWindow extends JFrame {
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod;
    private JTextField textName, textPrice, textDeposit, textPeriod;
    private JRadioButton commandable, notCommandable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio, panelButton, panelWindow, panelDate;
    private JButton buttonValid, buttonCancel, buttonDate;
    private JTextField dateArea;
    private ObjectControler addObjectControler;
    private OneObject object;
    private Boolean commandableValue;
    private GregorianCalendar dateObject;
    private JSpinner spinnerDate, spinnerPeriod;
    private ArrayList<Collective> arrayCollectives;
    private CollectiveControler collectiveControler;
    private ArrayList<String> collectives;
    private ObjectControler controler;
    private boolean dateNull;

    public AddObjectWindow() throws DAOConfigurationException {
        super("Create an object");
        setBounds(250, 200, 600, 400);
        controler  = new ObjectControler();
        collectiveControler = new CollectiveControler();
        arrayCollectives = collectiveControler.getAllCollectives();
        collectives = new ArrayList<String>();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }

        listCollective = new JComboBox(collectives.toArray());

        this.setLayout(new FlowLayout());


        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        SpinnerNumberModel modelSpinnerPeriod = new SpinnerNumberModel(1, 1, 100, 1);

        labelCollective = new JLabel("Collectif : ");
        labelName = new JLabel("Nom de l'objet : ");
        labelCommandable = new JLabel("Commandable : ");
        labelDate = new JLabel("Date de l'achat : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué :");
        textName = new JTextField();
        dateArea = new JTextField();
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
        buttonValid = new JButton("Create");
        buttonCancel= new JButton("Cancel");
        SpinnerDateModel model = new SpinnerDateModel();
        spinnerDate = new JSpinner(model);
        spinnerDate.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(editor);
        //spinnerDate.setEnabled(false);
        spinnerPeriod = new JSpinner(modelSpinnerPeriod);
        panel = new JPanel();
        panelButton = new JPanel();
        panelWindow = new JPanel();
        panelDate = new JPanel();
        buttonDate = new JButton("Ajouter");
        panelDate.setLayout(new GridLayout(1,2, 10, 5));
        panelDate.add(labelDate);
        buttonDate.addActionListener(new AddDate());
        panelDate.add(buttonDate);
        panel.setLayout(new GridLayout(7,2, 10, 5));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(textName);
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

        spinnerDate.setEnabled(false);

        RadioButtonListener listener = new RadioButtonListener();
        commandable.addItemListener(listener);
        notCommandable.addItemListener(listener);

        dateObject = new GregorianCalendar();
        dateObject.setTime((Date)spinnerDate.getModel().getValue());

        buttonCancel.addActionListener(new CancelButtonListener());
        panelButton.add(buttonCancel);
        buttonValid.addActionListener(new CreateObject());
        panelButton.add(buttonValid);

        panelWindow.setLayout(new GridLayout(2,1, 10, 30));;
        panelWindow.add(panel);
        panelWindow.add(panelButton);
        panelWindow.setVisible(true);
        this.add(panelWindow);
        setVisible(true);
    }

    private class ExitButtonListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent evt){
            AddObjectWindow.this.dispose();
        }
    }

    private class CancelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            AddObjectWindow.this.dispose();
        }
    }

    private class CreateObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(!textName.getText().equals("")){
                if(dateObject != null){
                    dateObject.setTime((Date)spinnerDate.getModel().getValue());
                }
                String value = listCollective.getSelectedItem().toString();
                int idCollective = 0;
                // Todo : implement exception
                try {
                    idCollective = collectiveControler.searchACollectiveIDBasedName(value);
                } catch (DAOConfigurationException e) {
                    e.printStackTrace();
                }
                boolean price = false;
                boolean deposit = !textDeposit.getText().equals("");
                if(!textPrice.getText().equals("")){
                    price = true;
                }
                if(buttonDate.getText().equals("Ajouter")){
                    dateObject = null;
                }
                object = new OneObject(textName.getText(), idCollective, commandableValue, dateObject, (price ? Double.parseDouble(textPrice.getText()) : Types.NULL), (deposit ? Integer.parseInt(textDeposit.getText()): Types.NULL),(Integer)spinnerPeriod.getValue());
                // Todo : implement exception
                try {
                    controler.addObject(object);
                } catch (DAOConfigurationException e) {
                    e.printStackTrace();
                }
                AddObjectWindow.this.dispose();
            }
            else{
                System.out.println("Nom incorrect");
            }
        }
    }

    private class RadioButtonListener implements ItemListener{
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
