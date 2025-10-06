package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public GuiApp() {
        // Frame setup
        frame = new JFrame("Peer-to-Peer Skill Exchange Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        // Card layout for switching screens
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add pages
        mainPanel.add(createHomePage(), "home");
        mainPanel.add(createLoginPage(), "login");
        mainPanel.add(createRegisterPage(), "register");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // ---------------- Home Page ----------------
    private JPanel createHomePage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Welcome to Skill Exchange!", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        panel.add(title, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Traditional ActionListeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "register");
            }
        });

        return panel;
    }

    // ---------------- Login Page ----------------
    private JPanel createLoginPage() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 cols
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton backBtn = new JButton("Back");

        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(passLabel);
        formPanel.add(passwordField);
        formPanel.add(loginBtn);
        formPanel.add(backBtn);

        panel.add(formPanel, BorderLayout.CENTER);

        // Traditional ActionListeners
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = String.valueOf(passwordField.getPassword());

                if (user.equals("admin") && pass.equals("1234")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    //  Redirect to dashboard
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials!");
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "home");
            }
        });

        return panel;
    }

    // ---------------- Register Page ----------------
    private JPanel createRegisterPage() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Register", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("New Username:");
        JLabel passLabel = new JLabel("New Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(passLabel);
        formPanel.add(passwordField);
        formPanel.add(registerBtn);
        formPanel.add(backBtn);

        panel.add(formPanel, BorderLayout.CENTER);

        // Traditional ActionListeners
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = String.valueOf(passwordField.getPassword());

                if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Account created for: " + user);
                    // Save to database
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "home");
            }
        });

        return panel;
    }

    // ---------------- Main Launcher ----------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp();
            }
        });
    }
}
