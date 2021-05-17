package view;

import dataAcces.CollectiveManager;
import dataAcces.exception.DAOConfigurationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstSearchForm extends JFrame {
    private JLabel labelCategory;
    private JComboBox listCategory;
    private JButton button;
    private CollectiveManager manager;
    private ArrayList<String> categoryList;

    public FirstSearchForm() throws DAOConfigurationException {
        super("Search rentals by collective category");
        setBounds(200, 150, 400, 100);
        manager = new CollectiveManager();
        categoryList = manager.getDistinctCategoryCollective();

        this.setLayout(new FlowLayout());
        labelCategory = new JLabel("Select a category : ");
        listCategory = new JComboBox(categoryList.toArray());
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
            String category = listCategory.getSelectedItem().toString();
            try {
                FirstSearchWindow firstSearchWindow = new FirstSearchWindow(category);
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
            FirstSearchForm.this.dispose();
        }
    }
}
