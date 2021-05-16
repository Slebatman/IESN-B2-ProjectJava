package view;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class ThirdSearchWindows extends JFrame {
    private JTable table;
    public ThirdSearchWindows(GregorianCalendar firstDate, GregorianCalendar secondDate){
        super("Third search");
        setBounds(500, 200, 650, 500);
        this.setLayout(new FlowLayout());
        JTable tableau = new JTable(new ModeleStatiqueThirdSearch(firstDate, secondDate));
        this.add(new JScrollPane(tableau),BorderLayout.CENTER);
        this.setVisible(true);
    }
}
