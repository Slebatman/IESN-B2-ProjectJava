package view;
import controler.*;
import model.OneObject;
import exception.DAOException;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ListingObjetWindow extends JFrame{
    private JPanel listPanel;
    private ArrayList<OneObject> listObjects;
    private ObjectControler controler;
    private int nbObjects;
    private SimpleDateFormat formatDate;
    private JTable table;

    public ListingObjetWindow() throws DAOException {
        super("List of the objects");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueListingObjects());
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
