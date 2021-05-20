package userInterface;

import userInterface.modelesStatiques.ModeleStatiqueFirstSearch;

import javax.swing.*;
import java.awt.*;

public class RentalDelaysWindow extends JFrame {
    public RentalDelaysWindow(){
        super("Delays");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable();
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
