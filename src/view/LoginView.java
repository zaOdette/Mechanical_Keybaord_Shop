package view;

import database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {

    JLabel usernameLabel;
    JTextField usernameTextField;
    JLabel passwordLabel;
    JPasswordField passwordTextField;
    JButton loginButton;

    public LoginView() {
        this.setSize(690, 690); // sets the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the application
        this.setVisible(true); // makes frame visible
        this.setTitle("Login"); // sets the title of the frame
        this.setResizable(false); // makes the frame not resizable
        this.setLocationRelativeTo(null); // sets the frame to the center of the screen

        ImageIcon logo = new ImageIcon("src/images/PC.png"); // creates an ImageIcon
        this.setIconImage(logo.getImage()); // sets the icon of the frame
        this.getContentPane().setBackground(new Color(0x8a5d94)); // sets the background color of the frame

        this.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        usernameLabel = new JLabel("Username:");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameTextField = new JTextField();
        usernameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameTextField.setMaximumSize(new Dimension(200, 25));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordTextField = new JPasswordField();
        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordTextField.setMaximumSize(new Dimension(200, 25));

        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(this);
        loginButton.setMaximumSize(new Dimension(100, 25));

        this.add(loginPanel, BorderLayout.CENTER);
        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(usernameLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(usernameTextField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(passwordLabel);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(passwordTextField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(loginButton);
        loginPanel.add(Box.createVerticalGlue());

        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            try {
                if (!Database.userExists(username)) {
                    throw new Exception("User not found");
                }
                    String correctPassword = Database.getPassword(username);
                    try {
                        if (!password.equals(correctPassword)) {
                            throw new Exception("Incorrect password");
                        } else {
                            JOptionPane.showMessageDialog(this, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();
                            new MenuView();
                        }
                    } catch (Exception exPassword) {
                        JOptionPane.showMessageDialog(this, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Username not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
