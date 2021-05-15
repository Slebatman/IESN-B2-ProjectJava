package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondSearchForm extends JFrame {
    private JLabel labelProblem;
    private JComboBox listProblems;
    private JButton button;

    public SecondSearchForm(){
        super("Search rentals by type of problem");
        setBounds(200, 150, 400, 100);
        String[] list = {"Retard", "Dégradation", "Jamais rendu"};
        this.setLayout(new FlowLayout());
        labelProblem = new JLabel("Select a category : ");
        listProblems = new JComboBox(list);
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
            SecondSearchForm.this.dispose();
        }
    }
}
