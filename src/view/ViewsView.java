package view;

import database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewsView extends JFrame implements ActionListener {

    JButton backButton;
    JComboBox<String> viewsComboBox;
    //DefaultTableModel tableModel;
    //JTable table;
    JLabel resultLabel;

    public ViewsView() {
        this.setSize(690, 690); // sets the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the application
        this.setVisible(true); // makes frame visible
        this.setTitle("Statistics"); // sets the title of the frame
        this.setResizable(false); // makes the frame not resizable
        this.setLocationRelativeTo(null); // sets the frame to the center of the screen

        ImageIcon logo = new ImageIcon("src/images/PC.png"); // creates an ImageIcon
        this.setIconImage(logo.getImage()); // sets the icon of the frame
        this.getContentPane().setBackground(new Color(0x8a5d94)); // sets the background color of the frame

        this.setLayout(new BorderLayout());

        JPanel viewsPanel = new JPanel();
        viewsPanel.setOpaque(false);
        viewsPanel.setLayout(new BoxLayout(viewsPanel, BoxLayout.Y_AXIS));

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        viewsComboBox = new JComboBox<>();
        viewsComboBox.addActionListener(this);
        viewsComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewsComboBox.setMaximumSize(new Dimension(550, 25));
        viewsComboBox.addItem("Keyboards that have switches that cost more than 200");
        viewsComboBox.addItem("Keycaps with Cherry profile");
        viewsComboBox.addItem("Users that gave under 4 stars");
        viewsComboBox.addItem("How many types of switches are there");

        //tableModel = new DefaultTableModel();
        //table = new JTable(tableModel);
        //JScrollPane scrollPane = new JScrollPane(table);
        resultLabel = new JLabel();
        resultLabel.setText("result");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setMaximumSize(new Dimension(550, 400));
//        JScrollPane scrollPane = new JScrollPane(resultLabel);
//        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
//        scrollPane.setMaximumSize(new Dimension(550, 400));

        this.add(viewsPanel, BorderLayout.CENTER);
        viewsPanel.add(Box.createVerticalGlue());
        viewsPanel.add(backButton);
        viewsPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        viewsPanel.add(viewsComboBox);
        viewsPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        //viewsPanel.add(scrollPane);
        viewsPanel.add(resultLabel);
        viewsPanel.add(Box.createVerticalGlue());

        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MenuView();
            this.dispose();
        }
        if (e.getSource() == viewsComboBox) {
//            String selectedQuery = (String) viewsComboBox.getSelectedItem();
//            Database.executeQuery(tableModel, selectedQuery);
//        }
            String selectedQuery = (String) viewsComboBox.getSelectedItem();
            String result = Database.executeQuery(selectedQuery);
            //resultLabel.setText("<html>" + result.replaceAll("\n", "<br>") + "</html>");
        }
    }
}
