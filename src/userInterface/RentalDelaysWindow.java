package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueDelays;
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
    public RentalDelaysWindow() throws DAOException, ModelException {
        super("Delays");
        setBounds(500, 200, 650, 500);
        JTable tableau = new JTable(new ModeleStatiqueDelays());
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
