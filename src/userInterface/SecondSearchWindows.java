package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueSecondSearch;

import javax.swing.*;
import java.awt.*;

public class SecondSearchWindows extends JFrame {
    private JTable table;
    private ModeleStatiqueSecondSearch modele;
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException, ModelException, BusinessException, ControllerException {
        super("Second search");
        setBounds(500, 200, 650, 500);
        modele = new ModeleStatiqueSecondSearch(idTypeOfProlem);
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des problèmes dans une location pour ce type de problème est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            SecondSearchWindows.this.dispose();
        }
    }
}
