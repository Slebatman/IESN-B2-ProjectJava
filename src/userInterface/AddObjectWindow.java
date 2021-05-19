package userInterface;
import controller.*;
import exception.BusinessException;
import exception.ModelException;
import model.Collective;
import model.OneObject;
import exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddObjectWindow extends JFrame {
    // Variables
    private JLabel labelCollective, labelName, labelCommendable, labelDate, labelPrice, labelDeposit, labelPeriod, obligatoryLabel;
    private JTextField textName, textPrice, textDeposit;
    private JRadioButton commendable, notCommendable;
    private ButtonGroup radioGroup;
    private JComboBox comboboxAllCollectives;
    private JPanel panel, panelRadio, panelButton, panelWindow, panelDate;
    private JButton buttonValid, buttonCancel, buttonDate;
    private OneObject object;
    private Boolean commendableValue;
    private GregorianCalendar dateObject;
    private JSpinner spinnerDate, spinnerPeriod;
    private ArrayList<Collective> arrayAllCollectives;
    private CollectiveController collectiveController;
    private ArrayList<String> listAllCollectives;
    private OneObjectController oneObjectController;

    // Constructor
    public AddObjectWindow() throws DAOException, ModelException {
        // Title frame
        super("Créer et ajouter un nouvel objet");
        setBounds(250, 200, 600, 450);
        this.setLayout(new FlowLayout());

        // Controllers
        oneObjectController = new OneObjectController();
        collectiveController = new CollectiveController();

        // Collective
        labelCollective = new JLabel("Collectif : *");
        arrayAllCollectives = collectiveController.getAllCollectives();
        listAllCollectives = new ArrayList<>();

        for(Collective col : arrayAllCollectives){
            listAllCollectives.add(col.getName());
        }
        comboboxAllCollectives = new JComboBox(listAllCollectives.toArray());

        // ObjectName
        labelName = new JLabel("Nom de l'objet : *");
        textName = new JTextField();

        // IsCommendable
        labelCommendable = new JLabel("Commandable : *");
        commendable = new JRadioButton("Yes");
        notCommendable = new JRadioButton("No");
        radioGroup = new ButtonGroup();
        radioGroup.add(notCommendable);
        radioGroup.add(commendable);
        panelRadio = new JPanel();
        panelRadio.add(commendable);
        panelRadio.add(notCommendable);
        RadioButtonListener listener = new RadioButtonListener();
        commendable.addItemListener(listener);
        notCommendable.addItemListener(listener);

        // PurchaseDate
        labelDate = new JLabel("Date de l'achat : ");
        SpinnerDateModel model = new SpinnerDateModel();
        spinnerDate = new JSpinner(model);
        spinnerDate.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(editor);
        panelDate = new JPanel();
        buttonDate = new JButton("Ajouter");
        panelDate.setLayout(new GridLayout(1,2, 10, 5));
        panelDate.add(labelDate);
        buttonDate.addActionListener(new AddDate());
        panelDate.add(buttonDate);
        spinnerDate.setEnabled(false);
        dateObject = new GregorianCalendar();
        dateObject.setTime((Date)spinnerDate.getModel().getValue());

        // PurchasePrice
        labelPrice = new JLabel("Prix d'achat : ");
        textPrice = new JTextField();

        // Deposit
        labelDeposit = new JLabel("Montant de la caution : ");
        textDeposit = new JTextField();

        // MaxPeriodRental
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué : *");
        SpinnerNumberModel modelSpinnerPeriod = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerPeriod = new JSpinner(modelSpinnerPeriod);

        // Information about require field
        obligatoryLabel = new JLabel("(* : champs obligatoires)");
        obligatoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Validation
        panelButton = new JPanel();
        buttonValid = new JButton("Create");
        buttonCancel= new JButton("Cancel");
        buttonCancel.addActionListener(new CancelButtonListener());
        panelButton.add(buttonCancel);
        buttonValid.addActionListener(new CreateObject());
        panelButton.add(buttonValid);

        // Create Panel & Window
        panel = new JPanel();
        panel.setLayout(new GridLayout(8,2, 10, 5));
        panel.add(labelCollective);
        panel.add(comboboxAllCollectives);
        panel.add(labelName);
        panel.add(textName);
        panel.add(labelCommendable);
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

        panelWindow = new JPanel();
        panelWindow.setLayout(new GridLayout(2,1, 10, 30));
        panelWindow.add(panel);
        panelWindow.add(panelButton);
        panelWindow.setVisible(true);
        this.add(panelWindow);
        setVisible(true);
    }

    // Events
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
        public void actionPerformed(ActionEvent evt) {
            if(!textName.getText().equals("") && commendableValue != null) {
                try {
                    Boolean canAdd = true;
                    // Collective
                        String collectiveName = comboboxAllCollectives.getSelectedItem().toString();
                        int idCollective = collectiveController.getACollectiveIDBasedName(collectiveName);
                    // Name
                        String objectName = textName.getText();
                    // isCommendable
                        Boolean isCommendable = commendableValue;
                    // PurchaseDate
                        if(dateObject != null) {
                            dateObject.setTime((Date)spinnerDate.getModel().getValue());
                        }
                    // PurchasePrice
                        Double purchasePrice = null;
                        if(!textPrice.getText().equals("")) {
                            purchasePrice = Double.parseDouble(textPrice.getText());
                            if (purchasePrice < 0) {
                                showErrorMessage("Le prix d'achat ne peut être négatif");
                                canAdd = false;
                            }
                        }
                    // Deposit
                        Integer deposit = null;
                        if(!textDeposit.getText().equals("")){
                            deposit = Integer.parseInt(textDeposit.getText());
                            if (deposit < 0) {
                                showErrorMessage("La caution ne peut pas être négative");
                                canAdd = false;
                            }
                        }
                    // MaxPeriodRental
                        Integer maxPeriodRental = (Integer)spinnerPeriod.getValue();

                    // Add object
                        if (canAdd) {
                            oneObjectController.addObject(
                                    new OneObject(
                                            objectName,
                                            idCollective,
                                            isCommendable,
                                            dateObject,
                                            purchasePrice,
                                            deposit,
                                            maxPeriodRental)
                            );

                            AddObjectWindow.this.dispose();
                        }

                } catch (DAOException | ModelException | BusinessException e) {
                    showErrorMessage(e.getMessage());
                }
            }
            else {
                labelCollective.setForeground(Color.red);
                labelCommendable.setForeground(Color.red);
                labelName.setForeground(Color.red);
                labelPeriod.setForeground(Color.red);
                showErrorMessage("Attention de bien compléter l'ensemble des champs obligatoires"); }
        }
    }

    private class RadioButtonListener implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            if(event.getSource() == commendable && event.getStateChange() == ItemEvent.SELECTED) commendableValue = true;
            else if(event.getSource() == notCommendable && event.getStateChange() == ItemEvent.SELECTED) commendableValue = false;
        }
    }

    private class AddDate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(buttonDate.getText().equals("Ajouter")) {
                spinnerDate.setEnabled(true);
                buttonDate.setText("Retirer");
            } else {
                spinnerDate.setEnabled(false);
                buttonDate.setText("Ajouter");
            }
        }
    }

    // Error message
    private void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erreur lors de l'ajout de l'objet", JOptionPane.ERROR_MESSAGE);
    }

}
