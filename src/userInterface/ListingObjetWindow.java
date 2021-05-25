package userInterface;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueListingObjects;
import userInterface.modelesStatiques.ModeleStatiqueThirdSearch;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD

public class ListingObjetWindow extends JFrame{
    private ModeleStatiqueListingObjects modele;
=======
public class ListingObjetWindow extends JFrame {
    // Constructor
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    public ListingObjetWindow() throws DAOException, ModelException {
        // Frame initialization
        super("List of the objects");
        setBounds(500, 200, 650, 500);
<<<<<<< HEAD
        modele = new ModeleStatiqueListingObjects();
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des objets est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            ListingObjetWindow.this.dispose();
        }
=======

        // Display all objects via JTable
        JTable tableau = new JTable(new ModeleStatiqueListingObjects());
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    }
}
