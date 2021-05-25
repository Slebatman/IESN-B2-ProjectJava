package userInterface;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        // UIManager manages the current look and feel, the set of available look and feels
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // UIManager not required - Message only for debugging
            System.out.println(e.getMessage());
        }

        // Create & run MainWindows
        new MainWindow();

    }
}
