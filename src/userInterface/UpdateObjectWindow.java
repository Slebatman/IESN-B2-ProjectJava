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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UpdateObjectWindow extends JFrame {
    // Variables
    private JLabel labelCollective, labelName, labelCommendable, labelDate, labelPrice, labelDeposit, labelPeriod, obligatoryLabel;
    private JTextField textName, textPrice, textDeposit;
    private JRadioButton commendable, notCommendable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio, panelButton, panelWindow, panelCollectives, panelDate;
    private JButton buttonUpdate, buttonCancel, buttonDate;
    private ArrayList<Collective> arrayCollectives;
    private CollectiveController collectiveController;
    private ArrayList<String> collectives;
    private ArrayList<OneObject> arrayObjects;
    private OneObjectController oneObjectController;
    private JComboBox<String> listObjects;
    private GregorianCalendar dateObject;
    private JSpinner spinnerDate, spinnerPeriod;
    private Boolean commendableValue, dateEncoded;
    private OneObject objectDefault;
    private SimpleDateFormat formatDate;
    int idCollective;

    // Constructor
    UpdateObjectWindow() throws DAOException, ModelException, BusinessException, ControllerException {
        // Setup windows
        super("Mettre à jour un object");
        setBounds(250, 200, 800, 450);
        this.setLayout(new FlowLayout());

        // Controllers
        collectiveController = new CollectiveController();
        oneObjectController = new OneObjectController();

        // List of collectives
        arrayCollectives = collectiveController.getAllCollectives();
        collectives = new ArrayList<String>();

        for (Collective col : arrayCollectives) {
            if (oneObjectController.getAllObjectsForOneCollective(col.getIdCollective()).size() > 0) {
                collectives.add(col.getName());
            }
        }
        listCollective = new JComboBox(collectives.toArray());
        listCollective.addActionListener(new RefreshObjects());

        //List of objects for one collective
        String value = listCollective.getItemAt(0).toString();
        idCollective = collectiveController.getACollectiveIDBasedName(value);
        arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);
        listObjects = new JComboBox<String>();

        for(OneObject object : arrayObjects) {
            listObjects.addItem(object.getName());
        }
        listObjects.addActionListener(new RefreshValues());
        objectDefault = arrayObjects.get(0);

        // Formats creation
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
        SpinnerDateModel model = new SpinnerDateModel();
        spinnerDate = new JSpinner(model);
        spinnerDate.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(editor);
        SpinnerNumberModel modelSpinnerPeriod = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerPeriod = new JSpinner(modelSpinnerPeriod);

        // View creation
        labelCollective = new JLabel("Collectif : ");
        labelName = new JLabel("Nom de l'objet : ");
        labelCommendable = new JLabel("Commandable : ");
        labelDate = new JLabel("Date de l'achat (dd/mm/yyyy) : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué :");
        textName = new JTextField();
        textDeposit = new JTextField();
        textPrice = new JTextField();
        commendable = new JRadioButton("Oui");
        notCommendable = new JRadioButton("Non");
        radioGroup = new ButtonGroup();
        radioGroup.add(notCommendable);
        radioGroup.add(commendable);
        panelRadio = new JPanel();
        panelRadio.add(commendable);
        panelRadio.add(notCommendable);
        buttonUpdate = new JButton("Mettre à jour");
        buttonCancel= new JButton("Annuler");
        panel = new JPanel();
        panelButton = new JPanel();
        panelWindow = new JPanel();
        panelCollectives = new JPanel();
        panelCollectives.setLayout(new GridLayout(1,2, 5, 5));
        listCollective.addActionListener(new RefreshValues());
        listObjects.addActionListener(new RefreshValues());
        panelCollectives.add(labelCollective);
        panelCollectives.add(listCollective);

        // Data import
        importDepositPriceCommendable();
        GregorianCalendar date = objectDefault.getPurchaseDate();
        formatDate.setCalendar(date);
        buttonDate = new JButton("Ajouter");
        buttonDate.addActionListener(new AddDate());

        if (date != null) {
            spinnerDate.setValue(date.getTime());
            dateEncoded = true;
            spinnerDate.setEnabled(true);
            buttonDate.setText("Retirer");
        } else {
            dateEncoded = false;
            spinnerDate.setEnabled(false);
            buttonDate.setText("Ajouter");
        }

        spinnerPeriod.setValue(objectDefault.getMaxRentalPeriod());
        obligatoryLabel = new JLabel("(* : champs obligatoires)");
        obligatoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Create panel
        panelDate = new JPanel();
        panelDate.setLayout(new GridLayout(1,2, 10, 5));
        panelDate.add(labelDate);
        panelDate.add(buttonDate);
        panel.setLayout(new GridLayout(8,2, 10, 5));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(listObjects);
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

        dateObject = new GregorianCalendar();
        dateObject.setTime((Date)spinnerDate.getModel().getValue());

        buttonCancel.addActionListener(new CancelButtonListener());
        panelButton.add(buttonCancel);
        buttonUpdate.addActionListener(new UpdateObject());
        panelButton.add(buttonUpdate);

        RadioButtonListener listener = new RadioButtonListener();
        commendable.addItemListener(listener);
        notCommendable.addItemListener(listener);

        panelWindow.setLayout(new GridLayout(2,1, 10, 30));
        panelWindow.add(panel);
        panelWindow.add(panelButton);
        panelWindow.setVisible(true);

        this.add(panelWindow);

        setVisible(true);
    }

    // Cancelling the update of an object
    private class CancelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            UpdateObjectWindow.this.dispose();
        }
    }

    // Updating an object
    private class UpdateObject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // All required field must be completed
            if(textName.getText().equals("") && commendableValue != null) {
                try {
                Boolean canUpdate = true;
            // Not null value
                // IdCollective
                int idCollective = collectiveController.getACollectiveIDBasedName(listCollective.getSelectedItem().toString());

                // ObjectName
                int indexObject = listObjects.getSelectedIndex();
                int idObject = arrayObjects.get(indexObject).getIdObject();
                String objectName = listObjects.getItemAt(indexObject);

                // IsCommendable
                Boolean isCommendable = commendableValue;

                // MaxPeriodRental
                Integer maxPeriodRental = (Integer)spinnerPeriod.getValue();

                // Create object
                OneObject oneObject = new OneObject(objectName, idCollective, isCommendable, maxPeriodRental);
                oneObject.setIdObject(idObject);
            // Null values
                // PurchaseDate
                    if(dateObject != null && dateEncoded) {
                        dateObject.setTime((Date)spinnerDate.getModel().getValue());
                        try{
                            oneObject.setPurchaseDate(dateObject);
                        }catch(ModelException e){
                            canUpdate = false;
                            showErrorMessage("La date d'achat doit être antérieure");
                        }
                    }
                // PurchasePrice
                    if(!textPrice.getText().equals("")) {
                        // Verification if deposit is a number
                        try {
                            Double purchasePrice = Double.parseDouble(textPrice.getText());

                            if (purchasePrice < 0) {
                                canUpdate = false;
                                showErrorMessage("Le prix d'achat ne peut être négatif");
                            } else {
                                oneObject.setPurchasePrice(purchasePrice);
                            }
                        } catch (NumberFormatException e) {
                            canUpdate = false;
                            showErrorMessage("Le prix d'achat doit être un nombre");
                        }
                    }
                    // Deposit
                        if(!textDeposit.getText().equals("")) {
                            // Test if deposit is a number
                            try {
                                Integer deposit = Integer.parseInt(textDeposit.getText());
                                if (deposit < 0) {
                                    canUpdate = false;
                                    showErrorMessage("La caution ne peut pas être négative");
                                } else {
                                    oneObject.setDeposit(deposit);
                                }
                            } catch (NumberFormatException e) {
                                canUpdate = false;
                                showErrorMessage("La caution doit être un nombre");
                            }
                        }

                // Add object & close windows
                if (canUpdate) {
                    oneObjectController.updateAnObject(oneObject);
                    UpdateObjectWindow.this.dispose();
                }

                } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                    showErrorMessage(e.getMessage());
                }
            } else {
                labelCollective.setForeground(Color.red);
                labelCommendable.setForeground(Color.red);
                labelName.setForeground(Color.red);
                labelPeriod.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Veuillez remplir les champs obligatoires !", "Addobject Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Refreshing the object list
    private class RefreshObjects implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String value = listCollective.getSelectedItem().toString();

            try {
                int idCollective = collectiveController.getACollectiveIDBasedName(value);
                arrayObjects = oneObjectController.getAllObjectsForOneCollective(idCollective);

                listObjects.removeAllItems();
                for (OneObject object : arrayObjects) {
                    listObjects.addItem(object.getName());
                }

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get idCollective or list of objects from a collective Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Refresh values for an object
    private class RefreshValues implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Setup idObjet
            int indexObject = listObjects.getSelectedIndex();
            if(indexObject < 0) indexObject =0;

            objectDefault = arrayObjects.get(indexObject);
            GregorianCalendar date = objectDefault.getPurchaseDate();

            if(date != null) {
                spinnerDate.setValue(date.getTime());
                spinnerDate.setEnabled(true);
                buttonDate.setText("Retirer");
            } else {
                spinnerDate.setEnabled(false);
                buttonDate.setText("Ajouter");
            }
            importDepositPriceCommendable();

            spinnerPeriod.setValue(objectDefault.getMaxRentalPeriod());
            formatDate.setCalendar(date);
        }
    }

    // Radio button management
    private class RadioButtonListener implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if(event.getSource() == commendable && event.getStateChange() == ItemEvent.SELECTED) commendableValue = true;
            else if(event.getSource() == notCommendable && event.getStateChange() == ItemEvent.SELECTED) commendableValue = false;
        }
    }

    // Method managing the date field of the form
    private class AddDate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            changeDateNullable();
        }
    }

    // Method managing the date nullable
    private void changeDateNullable() {
        if (buttonDate.getText().equals("Ajouter")) {
            dateEncoded = true;
            spinnerDate.setEnabled(true);
            buttonDate.setText("Retirer");
        } else {
            dateEncoded = false;
            spinnerDate.setEnabled(false);
            buttonDate.setText("Ajouter");
        }
    }

    // Method managing commendable, purchasePrice & deposit value
    public void importDepositPriceCommendable(){
        if (objectDefault.isCommendable()) {
            commendable.setSelected(true);
            notCommendable.setSelected(false);
            commendableValue = true;
        } else {
            commendable.setSelected(false);
            notCommendable.setSelected(true);
            commendableValue = false;
        }

        if(objectDefault.getPurchasePrice() != Types.NULL) {
            textPrice.setText(objectDefault.getPurchasePrice() + "");
        } else {
            textPrice.setText("");
        }

        if (objectDefault.getDeposit() != Types.NULL){
            textDeposit.setText(objectDefault.getDeposit() +"");
        } else {
            textDeposit.setText("");
        }
    }

    // Error message
    private void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erreur lors de la mise à jour de l'objet", JOptionPane.ERROR_MESSAGE);
    }
}
