package com.peertopeer;

import com.peertopeer.gui.Login;
import com.peertopeer.gui.Panel;
import javax.swing.*;
import java.awt.*;

public class App {
    private final CardLayout cardLayout;
    private final JPanel containerPanel;

    public App() {
        // Initialize main frame
        JFrame mainFrame = new JFrame("Peer-to-Peer Skill Exchange Platform");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        // use CardLayout to switch between Login and Main Panel
        cardLayout = new CardLayout();
        containerPanel = new JPanel(cardLayout);

        // Initialize views
        Login loginView = new Login(this);
        Panel dashboardView = new Panel(this);

        // Add views to the container
        containerPanel.add(loginView.getPanel(), "LOGIN");
        containerPanel.add(dashboardView.getPanel(), "DASHBOARD");

        mainFrame.add(containerPanel);
        mainFrame.setVisible(true);
    }

    // Method to switch views
    public void showDashboard() {
        cardLayout.show(containerPanel, "DASHBOARD");
    }

    public void showLogin() {
        cardLayout.show(containerPanel, "LOGIN");
    }

    static void main() {
        // Ensure UI updates are thread-safe
        SwingUtilities.invokeLater(App::new);
    }
}
