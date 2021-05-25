package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueDelays;

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
    // Constructor
    public RentalDelaysWindow() throws DAOException, ModelException {
        // Frame initialize
        super("Delays");
        setBounds(500, 200, 650, 500);

        // (Job task) Management of rental arrears
        JTable tableau = new JTable(new ModeleStatiqueDelays());
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
    }
}
