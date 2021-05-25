package userInterface;

import exception.BusinessException;
import exception.ControllerException;
import exception.DAOException;
import exception.ModelException;
import userInterface.modelesStatiques.ModeleStatiqueThirdSearch;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class ThirdSearchWindows extends JFrame {
    // Constructor
    public ThirdSearchWindows(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialize
        super("Third search");
        setBounds(500, 200, 650, 500);

        // (Research n°3) All rentals between 2 dates
        JTable tableau = new JTable(new ModeleStatiqueThirdSearch(firstDate, secondDate));
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
    }
}
