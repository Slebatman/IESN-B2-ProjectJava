package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {
    private JLabel label1;

    public MainWindowPanel(){
        this.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.setLayout(new GridLayout(2,1));

        new AnimationThread(this).start();
        label1 = new JLabel("Bienvenue dans la gestion de votre inventaire !");
        this.add(label1);
    }

}
