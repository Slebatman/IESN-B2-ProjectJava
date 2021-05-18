package userInterface;

import business.TypeOfProblemRentalManager;
import exception.DAOException;
import exception.ModelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SecondSearchForm extends JFrame {
    private JLabel labelProblem;
    private JComboBox listProblems;
    private JButton button;
    private TypeOfProblemRentalManager manager;
    private ArrayList<String> problemList;

    public SecondSearchForm() throws DAOException {
        super("Search rentals by type of problem");
        setBounds(200, 150, 400, 100);
        manager = new TypeOfProblemRentalManager();
        problemList = manager.getDistinctNameOfTypeOfProblemExitRental();
        this.setLayout(new FlowLayout());
        labelProblem = new JLabel("Select a type of problem : ");
        listProblems = new JComboBox(problemList.toArray());
        button = new JButton("Search");
        button.addActionListener(new SecondSearchForm.SearchButton());
        this.add(labelProblem);
        this.add(listProblems);
        this.add(button);
        this.setVisible(true);
    }

    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            int idTypeOfProblem = listProblems.getSelectedIndex()+1;
            try {
                SecondSearchWindows secondSearchWindows = new SecondSearchWindows(idTypeOfProblem);
            } catch (DAOException | ModelException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get idTypeOfProblem Exception", JOptionPane.ERROR_MESSAGE);
            }
            SecondSearchForm.this.dispose();
        }
    }
}
