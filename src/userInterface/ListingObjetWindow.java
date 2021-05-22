package userInterface;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueListingObjects;

import javax.swing.*;
import java.awt.*;


public class ListingObjetWindow extends JFrame{
    public ListingObjetWindow() throws DAOException, ModelException {
        super("List of the objects");
        setBounds(500, 200, 650, 500);
        JTable tableau = new JTable(new ModeleStatiqueListingObjects());
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
