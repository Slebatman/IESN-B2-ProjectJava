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
    private JLabel label;
    private JSpinner spinnerFirstDate, spinnerSecondDate;
    private JButton button;
    private GregorianCalendar firstDate, secondDate;

    public ThirdSearchForm(){
        super("Search rentals between 2 dates");
        setBounds(200, 150, 500, 100);
        this.setLayout(new FlowLayout());
        label = new JLabel("Select the dates : ");
        button = new JButton("Search");
        SpinnerDateModel firstModel = new SpinnerDateModel();
        SpinnerDateModel secondModel = new SpinnerDateModel();
        spinnerFirstDate = new JSpinner(firstModel);
        spinnerFirstDate.setModel(firstModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFirstDate, "dd/MM/yyyy");
        spinnerFirstDate.setEditor(editor);
        spinnerSecondDate = new JSpinner(secondModel);
        spinnerSecondDate.setModel(secondModel);
        JSpinner.DateEditor editorTwo = new JSpinner.DateEditor(spinnerSecondDate, "dd/MM/yyyy");
        spinnerSecondDate.setEditor(editorTwo);
        button.addActionListener(new ThirdSearchForm.SearchButton());
        this.add(label);
        this.add(spinnerFirstDate);
        this.add(spinnerSecondDate);
        this.add(button);
        this.setVisible(true);
    }

    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            firstDate = new GregorianCalendar();
            firstDate.setTime((Date)spinnerFirstDate.getModel().getValue());
            secondDate = new GregorianCalendar();
            secondDate.setTime((Date)spinnerSecondDate.getModel().getValue());
            if(firstDate.compareTo(secondDate) < 0){
                try {
                    ThirdSearchWindows thirdSearchWindows = new ThirdSearchWindows(firstDate, secondDate);
                } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Get list of Rentals between 2 dates Exception", JOptionPane.ERROR_MESSAGE);
                }
                ThirdSearchForm.this.dispose();
                }
            else{
                JOptionPane.showMessageDialog(null, "the start Date should be before the return date !", "Date Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
        }

}