package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueSecondSearch;

import javax.swing.*;
import java.awt.*;

public class SecondSearchWindows extends JFrame {
<<<<<<< HEAD
    private JTable table;
    private ModeleStatiqueSecondSearch modele;
=======
    // Constructor
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialize
        super("Second search");
        setBounds(500, 200, 650, 500);
<<<<<<< HEAD
        modele = new ModeleStatiqueSecondSearch(idTypeOfProlem);
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des problèmes dans une location pour ce type de problème est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            SecondSearchWindows.this.dispose();
        }
=======

        // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
        JTable tableau = new JTable(new ModeleStatiqueSecondSearch(idTypeOfProlem));
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    }
}
