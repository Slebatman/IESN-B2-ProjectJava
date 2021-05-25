package userInterface;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueListingObjects;
import userInterface.modelesStatiques.ModeleStatiqueThirdSearch;

import javax.swing.*;
import java.awt.*;


public class ListingObjetWindow extends JFrame{
    private ModeleStatiqueListingObjects modele;
    public ListingObjetWindow() throws DAOException, ModelException {
        super("List of the objects");
        setBounds(500, 200, 650, 500);
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
