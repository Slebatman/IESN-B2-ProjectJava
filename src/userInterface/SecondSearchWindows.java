package userInterface;

import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueSecondSearch;

import javax.swing.*;
import java.awt.*;

public class SecondSearchWindows extends JFrame {
    private JTable table;
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException, ModelException {
        super("Second search");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueSecondSearch(idTypeOfProlem));
        System.out.println(tableau.getRowCount());
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
