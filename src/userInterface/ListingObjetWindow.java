package userInterface;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueListingObjects;

import javax.swing.*;
import java.awt.*;

public class ListingObjetWindow extends JFrame {
    // Variable
    private ModeleStatiqueListingObjects modele;

    // Constructor
    public ListingObjetWindow() throws DAOException, ModelException {
        // Frame initialization
        super("List of the objects");
        setBounds(500, 200, 650, 500);

        // Display all objects via JTable
        modele = new ModeleStatiqueListingObjects();
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des objets est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            ListingObjetWindow.this.dispose();
        }
    }
}
