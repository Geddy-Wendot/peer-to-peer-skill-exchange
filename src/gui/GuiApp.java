package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class GuiApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Simple in-memory database
    private HashMap<String, User> users = new HashMap<>();
    private User loggedInUser;

    public GuiApp() {
        frame = new JFrame("Peer-to-Peer Skill Exchange Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Pages
        mainPanel.add(createHomePage(), "home");
        mainPanel.add(createLoginPage(), "login");
        mainPanel.add(createRegisterPage(), "register");
        mainPanel.add(createDashboardPage(), "dashboard");

        frame.add(mainPanel);
        frame.setResizable(false);
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

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
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

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = String.valueOf(passwordField.getPassword());

                if (users.containsKey(user)) {
                    User existingUser = users.get(user);
                    if (existingUser.password.equals(pass)) {
                        loggedInUser = existingUser;
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                        updateDashboard();
                        cardLayout.show(mainPanel, "dashboard");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Incorrect password!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "User not found!");
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

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel offerLabel = new JLabel("Skill Offered:");
        JLabel wantLabel = new JLabel("Skill Wanted:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField offerField = new JTextField();
        JTextField wantField = new JTextField();
        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(passLabel);
        formPanel.add(passwordField);
        formPanel.add(offerLabel);
        formPanel.add(offerField);
        formPanel.add(wantLabel);
        formPanel.add(wantField);
        formPanel.add(registerBtn);
        formPanel.add(backBtn);

        panel.add(formPanel, BorderLayout.CENTER);

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = String.valueOf(passwordField.getPassword());
                String offer = offerField.getText();
                String want = wantField.getText();

                if (user.isEmpty() || pass.isEmpty() || offer.isEmpty() || want.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                } else if (users.containsKey(user)) {
                    JOptionPane.showMessageDialog(frame, "Username already exists!");
                } else {
                    users.put(user, new User(user, pass, offer, want));
                    JOptionPane.showMessageDialog(frame, "Registration successful for: " + user);
                    cardLayout.show(mainPanel, "home");
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

    // ---------------- Dashboard Page ----------------
    private JPanel dashboardPanel;
    private JLabel welcomeLabel;
    private JLabel offerLabel;
    private JLabel wantLabel;

    private JPanel createDashboardPage() {
        dashboardPanel = new JPanel(new BorderLayout());

        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        offerLabel = new JLabel();
        wantLabel = new JLabel();
        infoPanel.add(offerLabel);
        infoPanel.add(wantLabel);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loggedInUser = null;
                cardLayout.show(mainPanel, "home");
            }
        });

        dashboardPanel.add(welcomeLabel, BorderLayout.NORTH);
        dashboardPanel.add(infoPanel, BorderLayout.CENTER);
        dashboardPanel.add(logoutBtn, BorderLayout.SOUTH);

        return dashboardPanel;
    }

    // ---------------- Update Dashboard ----------------
    private void updateDashboard() {
        if (loggedInUser != null) {
            welcomeLabel.setText("Welcome, " + loggedInUser.username + "!");
            offerLabel.setText("You Offer: " + loggedInUser.skillOffered);
            wantLabel.setText("You Want: " + loggedInUser.skillWanted);
        }
    }

    // ---------------- User Class ----------------
    private static class User {
        String username, password, skillOffered, skillWanted;

        User(String username, String password, String offer, String want) {
            this.username = username;
            this.password = password;
            this.skillOffered = offer;
            this.skillWanted = want;
        }
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
