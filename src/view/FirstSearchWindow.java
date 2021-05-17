package view;

import exception.DAOException;
import view.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class FirstSearchWindow extends JFrame {
    FirstSearchWindow(String category) throws DAOException {
        super("First search");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueFirstSearch(category));
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
