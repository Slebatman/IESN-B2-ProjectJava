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
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException, ModelException, BusinessException, ControllerException {
        super("Second search");
        setBounds(500, 200, 650, 500);
        JTable tableau = new JTable(new ModeleStatiqueSecondSearch(idTypeOfProlem));
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
