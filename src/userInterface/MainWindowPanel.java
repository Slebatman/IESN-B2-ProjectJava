package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {
    private JLabel label1;

    public MainWindowPanel(){
        label1 = new JLabel("Bienvenue dans la gestion de votre inventaire !");

        this.setLayout(new FlowLayout());

        this.add(label1);
    }
}
