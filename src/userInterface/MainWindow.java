package userInterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    // Variables
    private Container contentPane;
    private MainWindowPanel panel;
    private JMenuBar menu;

    // Constructor
    public MainWindow() {
        // Frame
        super("Gestion de l'inventaire - Animation namuroise");
        setBounds(100, 100, 600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame content panel
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        panel = new MainWindowPanel();
        contentPane.add(panel, BorderLayout.CENTER);

        // Frame menu
        menu = new MainWindowsMenu();
        setJMenuBar(menu);

        // Frame icon
        this.setIconImage(new ImageIcon(getClass().getResource("ressources/age.gif")).getImage());

        setVisible(true);
    }
}
