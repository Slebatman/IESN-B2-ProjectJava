package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueDelays;

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
    // Variables
    private ModeleStatiqueDelays modele;

    // Constructor
    public RentalDelaysWindow() throws DAOException, ModelException {
        // Frame initialize
        super("Delays");
        setBounds(500, 200, 650, 500);

        // (Job task) Management of rental arrears
        modele = new ModeleStatiqueDelays();
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()) {
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La liste des locations en retard est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            RentalDelaysWindow.this.dispose();
        }
    }
}
