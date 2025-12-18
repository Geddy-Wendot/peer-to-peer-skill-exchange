package com.peertopeer.gui;

import com.peertopeer.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login {
    private JPanel panel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private final App appController;

    public Login(App app) {
        this.appController = app;
        initializeUI();
    }

    private void initializeUI() {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255)); // Light Alice Blue
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel titleLabel = new JLabel("Student Skill Exchange");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Email Label & Field (Attribute: email )
        gbc.gridwidth = 1; gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Password Label & Field (Attribute: password )
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Login Button (Method: login() )
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        JButton loginButton = getJButton();
        panel.add(loginButton, gbc);

        // Register Link (Method: createAccount() )
        gbc.gridy = 4;
        JButton registerButton = new JButton("Create New Account");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setForeground(Color.BLUE);
        panel.add(registerButton, gbc);
    }

    private JButton getJButton() {
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);

        loginButton.addActionListener((ActionEvent e) -> {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());

            // Mock authentication
            if (!email.isEmpty() && !pass.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Login Successful!");
                appController.showDashboard();
            } else {
                JOptionPane.showMessageDialog(panel, "Please enter credentials.");
            }
        });
        return loginButton;
    }

    public JPanel getPanel() {
        return panel;
    }
}