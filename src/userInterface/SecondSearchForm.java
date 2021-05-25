package userInterface;

import controller.TypeOfProblemRentalControler;
import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SecondSearchForm extends JFrame {
    // Variables
    private JLabel labelProblem;
    private JComboBox listProblems;
    private JButton button;
    private TypeOfProblemRentalControler controller;
    private ArrayList<String> problemList;

    // Constructor
    public SecondSearchForm() throws DAOException {
        // Frame initialization
        super("Recherche des locations par type de problème");
        setBounds(200, 150, 400, 100);
        this.setLayout(new FlowLayout());

        // Controller
        controller = new TypeOfProblemRentalControler();

        // Type of problem listing
        problemList = controller.getDistinctNameOfTypeOfProblemExitRental();
        listProblems = new JComboBox(problemList.toArray());

        // Assignment
        labelProblem = new JLabel("Choisissez un type de problème : ");
        button = new JButton("Recherche");
        button.addActionListener(new SecondSearchForm.SearchButton());

        // Add to the frame
        this.add(labelProblem);
        this.add(listProblems);
        this.add(button);

        this.setVisible(true);
    }

    // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int idTypeOfProblem = listProblems.getSelectedIndex()+1;

            try {
                new SecondSearchWindows(idTypeOfProblem);

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Get idTypeOfProblem Exception", JOptionPane.ERROR_MESSAGE);
            }

            SecondSearchForm.this.dispose();
        }
    }
}
