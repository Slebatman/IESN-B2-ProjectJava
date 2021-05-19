package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class FirstSearchWindow extends JFrame {
    FirstSearchWindow(String category) throws DAOException, ModelException, BusinessException, ControllerException {
        super("First search");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueFirstSearch(category));
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
