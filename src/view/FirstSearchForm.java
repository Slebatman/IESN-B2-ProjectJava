package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstSearchForm extends JFrame {
    private JLabel labelCategory;
    private JComboBox listCategory;
    private JButton button;

    public FirstSearchForm(){
        super("Search rentals by collective category");
        setBounds(200, 150, 400, 100);
        String[] list = {"Cercle", "Kap", "Régio"};
        this.setLayout(new FlowLayout());
        labelCategory = new JLabel("Select a category : ");
        listCategory = new JComboBox(list);
        button = new JButton("Search");
        button.addActionListener(new SearchButton());
        this.add(labelCategory);
        this.add(listCategory);
        this.add(button);
        this.setVisible(true);
    }

    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            FirstSearchForm.this.dispose();
        }
    }
}
