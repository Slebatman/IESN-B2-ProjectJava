package view;

import exception.DAOException;

import javax.swing.*;
import java.awt.*;

public class SecondSearchWindows extends JFrame {
    private JTable table;
    public SecondSearchWindows(int idTypeOfProlem) throws DAOException {
        super("Second search");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueSecondSearch(idTypeOfProlem));
        System.out.println(tableau.getRowCount());
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
