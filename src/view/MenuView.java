package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements ActionListener {

    public JButton shopButton;
    public JButton viewsButton;

    public MenuView() {
        this.setSize(690, 690); // sets the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the application
        this.setVisible(true); // makes frame visible
        this.setTitle("Menu"); // sets the title of the frame
        this.setResizable(false); // makes the frame not resizable
        this.setLocationRelativeTo(null); // sets the frame to the center of the screen

        ImageIcon logo = new ImageIcon("src/images/PC.png"); // creates an ImageIcon
        this.setIconImage(logo.getImage()); // sets the icon of the frame
        this.getContentPane().setBackground(new Color(0x8a5d94)); // sets the background color of the frame

        this.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        shopButton = new JButton("Shop");
        shopButton.addActionListener(this);
        shopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        shopButton.setMaximumSize(new Dimension(300, 200));
        shopButton.setFont(new Font("Arial", Font.PLAIN, 40));

        viewsButton = new JButton("Statistics");
        viewsButton.addActionListener(this);
        viewsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewsButton.setMaximumSize(new Dimension(300, 200));
        viewsButton.setFont(new Font("Arial", Font.PLAIN, 40));

        this.add(menuPanel, BorderLayout.CENTER);
        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(shopButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        menuPanel.add(viewsButton);
        menuPanel.add(Box.createVerticalGlue());

        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shopButton) {
            new MainView();
            this.dispose();
        }
        if(e.getSource() == viewsButton) {
            new ViewsView();
            this.dispose();
        }
    }
}
