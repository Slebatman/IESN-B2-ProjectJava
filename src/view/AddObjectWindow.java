package view;
import controler.*;
import type.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddObjectWindow extends JFrame {
    private JLabel labelCollective, labelName, labelCommandable, labelDate, labelPrice, labelDeposit, labelPeriod;
    private JTextField textName, textPrice, textDeposit, textPeriod;
    private JRadioButton commandable, notCommandable;
    private ButtonGroup radioGroup;
    private JComboBox listCollective;
    private JPanel panel, panelRadio, panelButton, panelWindow;
    private JButton buttonValid, buttonCancel;
    private JFormattedTextField dateArea;
    private AddObjectControler addObjectControler;

    public AddObjectWindow(){
        super("Create an object");
        setBounds(250, 200, 600, 400);
        String[] collectives = {"info", "math", "philo", "éco" ,"chygé"};
        listCollective = new JComboBox(collectives);
        listCollective.setSelectedItem("info");

        this.setLayout(new FlowLayout());


        DateFormat formatDate = new SimpleDateFormat("yyyy/mm/dd");


        labelCollective = new JLabel("Collectif : ");
        labelName = new JLabel("Nom de l'objet : ");
        labelCommandable = new JLabel("Commandable : ");
        labelDate = new JLabel("Date de l'achat (dd/mm/yyyy) : ");
        labelPrice = new JLabel("Prix d'achat : ");
        labelDeposit = new JLabel("Montant de la caution : ");
        labelPeriod = new JLabel("Combien de jours maximum peut-il être loué :");
        textName = new JTextField();
        dateArea = new JFormattedTextField(formatDate);
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
        panelButton = new JPanel();
        panelWindow = new JPanel();
        panel.setLayout(new GridLayout(7,2, 10, 5));
        panel.add(labelCollective);
        panel.add(listCollective);
        panel.add(labelName);
        panel.add(textName);
        panel.add(labelCommandable);
        panel.add(panelRadio);
        panel.add(labelDate);
        panel.add(dateArea);
        panel.add(labelPrice);
        panel.add(textPrice);
        panel.add(labelDeposit);
        panel.add(textDeposit);
        panel.add(labelPeriod);
        panel.add(textPeriod);

        buttonCancel.addActionListener(new CancelButtonListener());
        panelButton.add(buttonCancel);
        buttonValid.addActionListener(new CreateObject());
        panelButton.add(buttonValid);

        panelWindow.setLayout(new GridLayout(2,1, 10, 30));;
        panelWindow.add(panel);
        panelWindow.add(panelButton);
        panelWindow.setVisible(true);
        this.add(panelWindow);
        setVisible(true);
    }

    private class ExitButtonListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent evt){
            AddObjectWindow.this.dispose();
        }
    }

    private class CancelButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            AddObjectWindow.this.dispose();
        }
    }

    private class CreateObject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){

        }
    }

}
