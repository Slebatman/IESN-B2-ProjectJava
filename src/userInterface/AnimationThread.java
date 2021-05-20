package userInterface;

import javax.swing.*;
import java.awt.*;

public class AnimationThread extends Thread {
    // Variables
    private JPanel panel;
    private JLabel imageAnimation;

    // Constructor
    public AnimationThread(JPanel panel) {
        this.panel = panel;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("ressources/animation.gif"));
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        imageAnimation = new JLabel();
        imageAnimation.setIcon(imageIcon1);
        imageAnimation.setHorizontalAlignment(JLabel.CENTER);

    }

    // Start method
    @Override
    public void run() {
        try {
            panel.add(imageAnimation, BorderLayout.CENTER);
            sleep(1000);

        } catch(InterruptedException e) {
            // ToDo : throws exception
            e.printStackTrace();
        }
    }
}
