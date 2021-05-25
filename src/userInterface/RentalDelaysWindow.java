package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueDelays;
<<<<<<< HEAD
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;
import userInterface.modelesStatiques.ModeleStatiqueThirdSearch;
=======
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
<<<<<<< HEAD
    private ModeleStatiqueDelays modele;
=======
    // Constructor
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    public RentalDelaysWindow() throws DAOException, ModelException {
        // Frame initialize
        super("Delays");
        setBounds(500, 200, 650, 500);
<<<<<<< HEAD
        modele = new ModeleStatiqueDelays();
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des locations en retard est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            RentalDelaysWindow.this.dispose();
        }
=======

        // (Job task) Management of rental arrears
        JTable tableau = new JTable(new ModeleStatiqueDelays());
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    }
}
