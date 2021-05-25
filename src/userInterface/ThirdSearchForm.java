package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

public class ThirdSearchForm extends JFrame {
    // Variables
    private JLabel label;
    private JSpinner spinnerFirstDate, spinnerSecondDate;
    private JButton button;
    private GregorianCalendar firstDate, secondDate;

    // Constructor
    public ThirdSearchForm() {
        // Frame initialization
        super("Cherchez les locations entre 2 dates");
        setBounds(200, 150, 500, 100);
        this.setLayout(new FlowLayout());

        // Label and button
        label = new JLabel("Choisissez les dates : ");
        button = new JButton("Recherche");
        button.addActionListener(new ThirdSearchForm.SearchButton());

        // Models
        SpinnerDateModel firstModel = new SpinnerDateModel();
        SpinnerDateModel secondModel = new SpinnerDateModel();

        // Date spinners
        spinnerFirstDate = new JSpinner(firstModel);
        spinnerFirstDate.setModel(firstModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFirstDate, "dd/MM/yyyy");
        spinnerFirstDate.setEditor(editor);
        spinnerSecondDate = new JSpinner(secondModel);
        spinnerSecondDate.setModel(secondModel);
        JSpinner.DateEditor editorTwo = new JSpinner.DateEditor(spinnerSecondDate, "dd/MM/yyyy");
        spinnerSecondDate.setEditor(editorTwo);

        // Add to the frame
        this.add(label);
        this.add(spinnerFirstDate);
        this.add(spinnerSecondDate);
        this.add(button);

        this.setVisible(true);
    }

    // (Research n°3) All rentals between 2 dates
    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Date management
            firstDate = new GregorianCalendar();
            firstDate.setTime((Date)spinnerFirstDate.getModel().getValue());
            secondDate = new GregorianCalendar();
            secondDate.setTime((Date)spinnerSecondDate.getModel().getValue());


            if(firstDate.compareTo(secondDate) < 0) {
                try {
                    new ThirdSearchWindows(firstDate, secondDate);

                } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of Rentals between 2 dates Exception", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "La date de départ doit être avant la date de retour !", "Date Exception", JOptionPane.ERROR_MESSAGE);
            }

            ThirdSearchForm.this.dispose();
        }
    }
}
