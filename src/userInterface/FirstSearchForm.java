package userInterface;

import controller.CollectiveController;
import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstSearchForm extends JFrame {
    // Variables
    private JLabel labelCategory;
    private JComboBox listCategory;
    private JButton button;
    private CollectiveController controller;
    private ArrayList<String> categoryList;

    // Constructor
    public FirstSearchForm() throws DAOException {
        // Initialize frame
        super("Recherche des locations par catégorie du collectif");
        setBounds(200, 150, 400, 100);
        this.setLayout(new FlowLayout());

        // Controller
        controller = new CollectiveController();

        // Category listing
        categoryList = controller.getDistinctCategoryCollective();
        listCategory = new JComboBox(categoryList.toArray());

        // Label and button
        labelCategory = new JLabel("Choisissez une catégorie : ");
        button = new JButton("Recherche");
        button.addActionListener(new SearchButton());

        //Add to the frame
        this.add(labelCategory);
        this.add(listCategory);
        this.add(button);
        this.setVisible(true);
    }

    // (Research n°1) All rentals for a category of collectives
    private class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String category = listCategory.getSelectedItem().toString();

            try {
                new FirstSearchWindow(category);

            } catch (DAOException | ModelException | BusinessException | ControllerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "First research Exception", JOptionPane.ERROR_MESSAGE);
            }

            FirstSearchForm.this.dispose();
        }
    }
}
