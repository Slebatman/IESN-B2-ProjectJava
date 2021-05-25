package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueSecondSearch;

import javax.swing.*;
import java.awt.*;

public class SecondSearchWindows extends JFrame {
    // Constructor
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialize
        super("Second search");
        setBounds(500, 200, 650, 500);

        // (Research n°2) Select all ProblemExitRental based on a TypeOfExitRental
        JTable tableau = new JTable(new ModeleStatiqueSecondSearch(idTypeOfProlem));
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
    }
}
