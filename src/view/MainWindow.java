package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private Container frameContainer;
    private MainWindowPanel panel;
    private JMenuBar menu;
    private JMenu application, objects, research;
    JMenuItem leave, createObject, updateObject, deleteObject, showObjects;
    public MainWindow(){
        super("Gestion d'inventaire");
        setBounds(100, 100, 500, 500);

        panel = new MainWindowPanel();

        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(panel, BorderLayout.CENTER);

        menu = new JMenuBar();
        this.setJMenuBar(menu);
        application = new JMenu("Application");
        objects = new JMenu("Object");
        research = new JMenu("Research");

        menu.add(application);
        menu.add(objects);
        menu.add(research);

        leave = new JMenuItem("Leave");
        leave.addActionListener(new ExitListener());
        application.add(leave);

        createObject = new JMenuItem("Create");
        createObject.addActionListener(new AddObject());
        objects.add(createObject);

        updateObject = new JMenuItem("Update");
        updateObject.addActionListener(new UpdateObject());
        objects.add(updateObject);

        deleteObject = new JMenuItem("Delete");
        deleteObject.addActionListener(new DeleteObject());
        objects.add(deleteObject);

        showObjects = new JMenuItem("Show all");
        objects.add(showObjects);


        setVisible(true);
    }

    private class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            System.exit(0);
        }
    }

    private class AddObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            AddObjectWindow addObjectWindow = new AddObjectWindow();
        }
    }

    private class DeleteObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            DeleteObjectWindow deleteWindow = new DeleteObjectWindow();
        }
    }

    private class UpdateObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            UpdateObjectWindow updateWindow = new UpdateObjectWindow();
        }
    }

}
