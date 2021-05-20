package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {
    private JLabel label1;
    private JLabel imageAnimation;

    public MainWindowPanel(){
        new AnimationThread(this).start();
        label1 = new JLabel("Bienvenue dans la gestion de votre inventaire !");
        this.add(label1);
    }

}
