package view;
import controler.*;
import type.OneObject;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class ListingObjetWindow extends JFrame{
    private JPanel listPanel;
    private ArrayList<OneObject> listObjects;
    private ObjectControler controler;
    private int nbObjects;
    private SimpleDateFormat formatDate;

    public ListingObjetWindow(){
        super("List of the objects");
        setBounds(500, 200, 1000, 400);
        this.setLayout(new FlowLayout());
        controler = new ObjectControler();
        listObjects = controler.getAllObjects();
        nbObjects = listObjects.size();
        listPanel = new JPanel();
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);

        listPanel.setLayout(new GridLayout(nbObjects+1,8, 10, 15));
        listPanel.add(new JLabel("IdObject"));
        listPanel.add(new JLabel("Name"));
        listPanel.add(new JLabel("idCollectiveOwner"));
        listPanel.add(new JLabel("isCommandable"));
        listPanel.add(new JLabel("purchaseDate"));
        listPanel.add(new JLabel("purchasePrice"));
        listPanel.add(new JLabel("deposit"));
        listPanel.add(new JLabel("MaxRentalPeriod"));

        for(OneObject object : listObjects){
            listPanel.add(new JLabel(String.valueOf(object.getIdObject())));
            listPanel.add(new JLabel(object.getName()));
            listPanel.add(new JLabel(String.valueOf(object.getIdCollectiveOwner())));
            listPanel.add(new JLabel(String.valueOf(object.isCommendable())));
            GregorianCalendar date = new GregorianCalendar();
            date = object.getPurchaseDate();
            formatDate.setCalendar(date);
            String dateFormatted = formatDate.format(date.getTime());
            listPanel.add(new JLabel(dateFormatted));
            if(object.getPurchasePrice() == 0){
                listPanel.add(new JLabel(" - "));
            }else{
                listPanel.add(new JLabel(String.valueOf(object.getPurchasePrice())));
            }
            if(object.getDeposit() == 0){
                listPanel.add(new JLabel(" - "));
            }else{
                listPanel.add(new JLabel(String.valueOf(object.getDeposit())));
            }
            listPanel.add(new JLabel(String.valueOf(object.getMaxRentalPeriod())));
        }
        this.add(listPanel);
        this.setVisible(true);
    }
}
