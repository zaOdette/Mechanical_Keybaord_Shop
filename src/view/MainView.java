package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import database.Database;
import model.Keycap;
import model.Switch;

public class MainView extends JFrame implements ActionListener {

    public JButton homeButton;

    public JComboBox switchNamesComboBox;
    public JLabel switchImage;
    public JLabel switchType;
    public JLabel switchActuationForce;
    public JLabel switchPrice;
    public JButton switchesAddToCartButton;

    public JComboBox keycapNamesComboBox;
    public JLabel keycapImage;
    public JLabel keycapMaterial;
    public JLabel keycapProfile;
    public JLabel keycapPrice;
    public JButton keycapsAddToCartButton;

    public JTextField totalSum;

    public MainView() {
        this.setSize(690, 690); // sets the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the application
        this.setVisible(true); // makes frame visible
        this.setTitle("Keyboard Shop"); // sets the title of the frame
        this.setResizable(false); // makes the frame not resizable
        this.setLocationRelativeTo(null); // sets the frame to the center of the screen

        ImageIcon logo = new ImageIcon("src/images/PC.png"); // creates an ImageIcon
        this.setIconImage(logo.getImage()); // sets the icon of the frame
        this.getContentPane().setBackground(new Color(0x8a5d94)); // sets the background color of the frame

        this.setLayout(new GridLayout(1,2)); // sets the layout of the frame

        JPanel switchesPanel = new JPanel();
        switchesPanel.setOpaque(false);
        switchesPanel.setLayout(new BoxLayout(switchesPanel, BoxLayout.Y_AXIS));

        homeButton = new JButton("Home");
        homeButton.addActionListener(this);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setSize(75, 40);

        switchImage = new JLabel();
        switchImage.setBorder(new EmptyBorder(50, 0, 0, 0)); // adds a top margin of 50 pixels
        switchImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        switchType = new JLabel("Type: " + Database.getType("switches", "HMX Joker"));
        switchType.setAlignmentX(Component.CENTER_ALIGNMENT);

        switchActuationForce = new JLabel("Actuation force: " + Database.getActuationForce("switches", "HMX Joker"));
        switchActuationForce.setAlignmentX(Component.CENTER_ALIGNMENT);

        switchPrice = new JLabel(Database.getPrice("switches", "HMX Joker") + " RON");
        switchPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<String> switchNames = Database.getNames("switches");
        switchNamesComboBox = new JComboBox(switchNames.toArray());
        switchNamesComboBox.setMaximumSize(new Dimension(150, 25));
        switchNamesComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchNamesComboBox.addActionListener(this);

        switchesAddToCartButton = new JButton("Buy");
        switchesAddToCartButton.addActionListener(this);
        switchesAddToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchesAddToCartButton.setMaximumSize(new Dimension(70, 30));

        // FROM HERE STARTS THE KEYCAPS PANEL

        JPanel keycapsPanel = new JPanel();
        keycapsPanel.setOpaque(false);
        keycapsPanel.setLayout(new BoxLayout(keycapsPanel, BoxLayout.Y_AXIS));

        totalSum = new JTextField("0");
        totalSum.setEditable(false);
        totalSum.setMaximumSize(new Dimension(150, 25));

        keycapImage = new JLabel();
        keycapImage.setBorder(new EmptyBorder(50, 0, 0, 0)); // adds a top margin of 50 pixels
        keycapImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        keycapMaterial = new JLabel("Material: " + Database.getMaterial("keycaps", "LiftOff"));
        keycapMaterial.setAlignmentX(Component.CENTER_ALIGNMENT);

        keycapProfile = new JLabel("Profile: " + Database.getProfile("keycaps", "LiftOff"));
        keycapProfile.setAlignmentX(Component.CENTER_ALIGNMENT);

        keycapPrice = new JLabel(Database.getPrice("keycaps", "LiftOff") + " RON");
        keycapPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

        List<String> keycapNames = Database.getNames("keycaps");
        keycapNamesComboBox = new JComboBox(keycapNames.toArray());
        keycapNamesComboBox.setMaximumSize(new Dimension(200, 25));
        keycapNamesComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        keycapNamesComboBox.addActionListener(this);

        keycapsAddToCartButton = new JButton("Buy");
        keycapsAddToCartButton.addActionListener(this);
        keycapsAddToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        keycapsAddToCartButton.setMaximumSize(new Dimension(70, 30));

        // HERE STARTS THE ADDING OF COMPONENTS TO THE PANELS

        this.add(switchesPanel);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(homeButton);
        switchesPanel.add(switchImage);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(switchNamesComboBox);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(switchPrice);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(switchType);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(switchActuationForce);
        switchesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        switchesPanel.add(switchesAddToCartButton);

        this.add(keycapsPanel);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(totalSum);
        keycapsPanel.add(keycapImage);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(keycapNamesComboBox);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(keycapPrice);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(keycapMaterial);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(keycapProfile);
        keycapsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        keycapsPanel.add(keycapsAddToCartButton);

        this.revalidate();
        this.repaint();

        Database.loadImage("HMX Joker", switchImage, "switches"); // loads image from database
        Database.loadImage("LiftOff", keycapImage, "keycaps"); // loads image from database
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == switchNamesComboBox) {
            String selectedSwitch = (String) switchNamesComboBox.getSelectedItem();
            Switch sw = Database.getSwitch(selectedSwitch);
            Database.loadImage(selectedSwitch, switchImage, "switches");
            switchPrice.setText(sw.getPrice() + " RON");
            switchType.setText("Type: " + sw.getType());
            switchActuationForce.setText("Actuation force: " + sw.getActuationForce() + " g");
        }
        if (e.getSource() == keycapNamesComboBox) {
            String selectedKeycap = (String) keycapNamesComboBox.getSelectedItem();
            Keycap kc = Database.getKeycap(selectedKeycap);
            Database.loadImage(selectedKeycap, keycapImage, "keycaps");
            keycapPrice.setText(kc.getPrice() + " RON");
            keycapMaterial.setText("Material: " + kc.getMaterial());
            keycapProfile.setText("Profile: " + kc.getProfile());
        }
        if(e.getSource() == switchesAddToCartButton) {
            String selectedSwitch = (String) switchNamesComboBox.getSelectedItem();
            Switch sw = Database.getSwitch(selectedSwitch);
            Integer total = Integer.parseInt(totalSum.getText());
            total += sw.getPrice();
            totalSum.setText(total.toString());
        }
        if(e.getSource() == keycapsAddToCartButton) {
            String selectedKeycap = (String) keycapNamesComboBox.getSelectedItem();
            Keycap kc = Database.getKeycap(selectedKeycap);
            Integer total = Integer.parseInt(totalSum.getText());
            total += kc.getPrice();
            totalSum.setText(total.toString());
        }
        if(e.getSource() == homeButton) {
            new MenuView();
            this.dispose();
        }
    }
}
