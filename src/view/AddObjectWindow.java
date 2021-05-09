package view;

import javax.swing.*;
import java.awt.*;

public class AddObjectWindow extends JFrame {
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod;
    private JComboBox listCollective;
    private JPanel panel;

    public AddObjectWindow(){
        super("Create an object");
        setBounds(250, 200, 600, 400);
        String[] collectives = {"info", "math", "philo", "éco" ,"chygé"};
        listCollective = new JComboBox(collectives);
        listCollective.setSelectedItem("info");
        this.add(listCollective);

        this.setLayout(new FlowLayout());


        labelCollective = new JLabel("Collectif : ");
        labelName = new JLabel("Nom de l'objet : ");
        labelCommandable = new JLabel("Commandable : ");
        labelDate = new JLabel("Date de l'achat : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué :");
        panel = new JPanel();
        panel.setLayout(new GridLayout(7,2));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(labelCommandable);
        panel.add(labelDate);
        panel.add(labelPrice);
        panel.add(labelDeposit);
        panel.add(labelPeriod);
        panel.setVisible(true);
        this.add(panel);
        setVisible(true);
    }
}
