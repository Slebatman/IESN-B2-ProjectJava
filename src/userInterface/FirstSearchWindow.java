package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class FirstSearchWindow extends JFrame {
    // Variables
    private ModeleStatiqueFirstSearch modele;

    // Constructor
    FirstSearchWindow(String category) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialization
        super("First search");
        setBounds(500, 200, 650, 500);

        // Display search results
        modele = new ModeleStatiqueFirstSearch(category);
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()) {
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "La liste des locations pour cette catégorie est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            FirstSearchWindow.this.dispose();
        }
    }
}
