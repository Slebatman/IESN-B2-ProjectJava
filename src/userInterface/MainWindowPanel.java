package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindowPanel extends JPanel {
    private JLabel label;

    public MainWindowPanel() {
        // Layout
        setBorder(BorderFactory.createEmptyBorder(15,30,10,30));
        setLayout(new BorderLayout(0, 15));

        // Label
        label = new JLabel("Bienvenue dans la gestion de l'inventaire de l'animation namuroise");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);

        // Start thread
        new AnimationThread(this).start();
    }
}
