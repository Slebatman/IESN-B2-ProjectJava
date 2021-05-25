package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueDelays;
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;
import userInterface.modelesStatiques.ModeleStatiqueThirdSearch;

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
    private ModeleStatiqueDelays modele;
    public RentalDelaysWindow() throws DAOException, ModelException {
        super("Delays");
        setBounds(500, 200, 650, 500);
        modele = new ModeleStatiqueDelays();
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des locations en retard est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            RentalDelaysWindow.this.dispose();
        }
    }
}
