package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class FirstSearchWindow extends JFrame {
<<<<<<< HEAD
    private ModeleStatiqueFirstSearch modele;
=======
    // Constructor
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    FirstSearchWindow(String category) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialization
        super("First search");
        setBounds(500, 200, 650, 500);
<<<<<<< HEAD
        modele = new ModeleStatiqueFirstSearch(category);
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
=======

        // Display search results
        ModeleStatiqueFirstSearch modeleStatiqueFirstSearch = new ModeleStatiqueFirstSearch(category);
        JTable tableau = new JTable(modeleStatiqueFirstSearch);

        if (!modeleStatiqueFirstSearch.isEmpty()) {
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "La liste des locations pour cette catégorie est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            FirstSearchWindow.this.dispose();
        }
    }
}
