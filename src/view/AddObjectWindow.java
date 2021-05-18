package view;
import controller.*;
import model.Collective;
import model.OneObject;
import exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddObjectWindow extends JFrame {
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod, obligatoryLabel;
    private JTextField textName, textPrice, textDeposit;
    private JRadioButton commandable, notCommandable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio, panelButton, panelWindow, panelDate;
    private JButton buttonValid, buttonCancel, buttonDate;
    private OneObject object;
    private Boolean commandableValue;
    private GregorianCalendar dateObject;
    private JSpinner spinnerDate, spinnerPeriod;
    private ArrayList<Collective> arrayCollectives;
    private CollectiveController collectiveController;
    private ArrayList<String> collectives;
    private OneObjectController controler;

    public AddObjectWindow() throws DAOException {
        super("Create an object");
        setBounds(250, 200, 600, 450);
        this.setLayout(new FlowLayout());

        //Controlers et liste des collectives
        controler  = new OneObjectController();
        collectiveController = new CollectiveController();
        arrayCollectives = collectiveController.getAllCollectives();
        collectives = new ArrayList<String>();
        for(Collective col : arrayCollectives){
            collectives.add(col.getName());
        }
        listCollective = new JComboBox(collectives.toArray());

        SpinnerNumberModel modelSpinnerPeriod = new SpinnerNumberModel(1, 1, 100, 1);

        labelCollective = new JLabel("Collectif : *");
        labelName = new JLabel("Nom de l'objet : *");
        labelCommandable = new JLabel("Commandable : *");
        labelDate = new JLabel("Date de l'achat : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué : *");
        textName = new JTextField();
        textDeposit = new JTextField();
        textPrice = new JTextField();
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
        spinnerPeriod = new JSpinner(modelSpinnerPeriod);
        obligatoryLabel = new JLabel("(* : champs obligatoires)");
        obligatoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel = new JPanel();
        panelButton = new JPanel();
        panelWindow = new JPanel();
        panelDate = new JPanel();
        buttonDate = new JButton("Ajouter");
        panelDate.setLayout(new GridLayout(1,2, 10, 5));
        panelDate.add(labelDate);
        buttonDate.addActionListener(new AddDate());
        panelDate.add(buttonDate);
        panel.setLayout(new GridLayout(8,2, 10, 5));
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
        panel.add(new JLabel());
        panel.add(obligatoryLabel);

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

        panelWindow.setLayout(new GridLayout(2,1, 10, 30));
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
            if(!textName.getText().equals("") && commandableValue != null){
                if(dateObject != null){
                    dateObject.setTime((Date)spinnerDate.getModel().getValue());
                }
                String value = listCollective.getSelectedItem().toString();
                int idCollective = 0;

                try {
                    idCollective = collectiveController.getACollectiveIDBasedName(value);
                } catch (DAOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Collective name exception", JOptionPane.ERROR_MESSAGE);
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

                try {
                    controler.addObject(object);
                } catch (DAOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Addobject Exception", JOptionPane.ERROR_MESSAGE);
                }
                AddObjectWindow.this.dispose();
            }
            else{
                labelCollective.setForeground(Color.red);
                labelCommandable.setForeground(Color.red);
                labelName.setForeground(Color.red);
                labelPeriod.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Veuillez remplir les champs obligatoires !", "Addobject Exception", JOptionPane.ERROR_MESSAGE);
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
