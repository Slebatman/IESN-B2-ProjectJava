package userInterface;

import javax.swing.*;

public class MainWindow extends JFrame {
    // Variables
    private JPanel panel;

    // Constructor
    public MainWindow() {
        // Frame
        super("Gestion de l'inventaire - Animation namuroise");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame content panel
        getContentPane().add(new MainWindowPanel());

        // Frame menu
        setJMenuBar(new MainWindowsMenu(this));

        // Frame icon
        setIconImage(new ImageIcon(getClass().getResource("ressources/age.gif")).getImage());

        setVisible(true);
    }
}
