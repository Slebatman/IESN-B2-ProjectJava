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
<<<<<<< HEAD
    private JTable table;
    private ModeleStatiqueThirdSearch modele;
=======
    // Constructor
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    public ThirdSearchWindows(GregorianCalendar firstDate, GregorianCalendar secondDate) throws DAOException, ModelException, BusinessException, ControllerException {
        // Frame initialize
        super("Third search");
        setBounds(500, 200, 650, 500);
<<<<<<< HEAD
        modele = new ModeleStatiqueThirdSearch(firstDate, secondDate);
        JTable tableau = new JTable(modele);
        if(!modele.isEmpty()){
            this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "La liste des locations entre ces 2 dates est vide", "Liste vide", JOptionPane.INFORMATION_MESSAGE);
            ThirdSearchWindows.this.dispose();
        }

=======

        // (Research n°3) All rentals between 2 dates
        JTable tableau = new JTable(new ModeleStatiqueThirdSearch(firstDate, secondDate));
        this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);

        this.setVisible(true);
>>>>>>> 5bd0a247d01786fc02974147f90975b2441cd4b3
    }
}
