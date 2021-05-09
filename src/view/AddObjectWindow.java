package view;

import javax.swing.*;
import java.awt.*;

public class AddObjectWindow extends JFrame {
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod;
    private JTextField textName, textDate, textPrice, textDeposit, textPeriod;
    private JRadioButton commandable, notCommandable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio;
    private JButton buttonValid, buttonCancel;

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
        textName = new JTextField();
        textDate = new JTextField();
        textDeposit = new JTextField();
        textPrice = new JTextField();
        textPeriod = new JTextField();
        commandable = new JRadioButton("Yes");
        notCommandable = new JRadioButton("No");
        radioGroup = new ButtonGroup();
        radioGroup.add(notCommandable);
        radioGroup.add(commandable);
        panelRadio = new JPanel();
        panelRadio.add(commandable);
        panelRadio.add(notCommandable);
        buttonValid = new JButton("Create");
        buttonCancel= new JButton("Cancel");
        panel = new JPanel();
        panel.setLayout(new GridLayout(7,2));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(textName);
        panel.add(labelCommandable);
        panel.add(panelRadio);
        panel.add(labelDate);
        panel.add(textDate);
        panel.add(labelPrice);
        panel.add(textPrice);
        panel.add(labelDeposit);
        panel.add(textDeposit);
        panel.add(labelPeriod);
        panel.add(textPeriod);
        panel.setVisible(true);
        this.add(panel);
        buttonCancel.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonValid.setVerticalAlignment(SwingConstants.BOTTOM);
        this.add(buttonCancel);
        this.add(buttonValid);
        setVisible(true);
    }
}
