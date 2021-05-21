package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    // Constructor
    public MainWindow() {
        // Frame
        super("Gestion de l'inventaire - Animation namuroise");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame content panel
        getContentPane().add(new MainWindowPanel());

        // Frame menu
        setJMenuBar(new MainWindowsMenu());

        // Frame icon
        setIconImage(new ImageIcon(getClass().getResource("ressources/age.gif")).getImage());

        setVisible(true);
    }
}
