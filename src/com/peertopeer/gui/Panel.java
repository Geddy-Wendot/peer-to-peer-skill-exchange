package com.peertopeer.gui;

import com.peertopeer.App;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;


public class Panel {
    private JPanel panel;
    private JTable skillsTable;
    private DefaultTableModel tableModel;
    private final App appController;

    public Panel(App app) {
        this.appController = app;
        initializeUI();
    }

    private void initializeUI() {
        panel = new JPanel(new BorderLayout());

        // --- TOP HEADER ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.setBackground(new Color(70, 130, 180));
        JLabel welcomeLabel = new JLabel("Welcome, Student!  ");
        welcomeLabel.setForeground(Color.WHITE);
        JButton logoutBtn = new JButton("Logout");

        logoutBtn.addActionListener(e -> appController.showLogin());

        headerPanel.add(welcomeLabel);
        headerPanel.add(logoutBtn);
        panel.add(headerPanel, BorderLayout.NORTH);

        // --- CENTER: SKILLS LIST ---
        // Objective: Categorize skills by academic, extracurricular, etc.
        String[] columns = {"Skill ID", "Skill Name", "Category", "Provider"};
        // Mock Data representing the 'Platform' class attributes [cite: 46]
        Object[][] data = {
                {"101", "Java Programming", "Academic", "Alice M."},
                {"102", "Public Speaking", "Personal", "John D."},
                {"103", "Guitar Basics", "Extracurricular", "Sarah L."},
                {"104", "Calculus II", "Academic", "Mike T."}
        };

        tableModel = new DefaultTableModel(data, columns);
        skillsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(skillsTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // --- BOTTOM: ACTIONS ---
        JPanel actionPanel = getJPanel();
        panel.add(actionPanel, BorderLayout.SOUTH);
    }

    private JPanel getJPanel() {
        JPanel actionPanel = new JPanel();

        // Button to request skill (Method: createRequest() )
        JButton requestBtn = new JButton("Request Appointment");
        requestBtn.setFont(new Font("Arial", Font.BOLD, 14));
        requestBtn.setBackground(new Color(60, 179, 113)); // Medium Sea Green
        requestBtn.setForeground(Color.WHITE);

        requestBtn.addActionListener(e -> {
            int selectedRow = skillsTable.getSelectedRow();
            if (selectedRow != -1) {
                String skillName = (String) tableModel.getValueAt(selectedRow, 1);
                String provider = (String) tableModel.getValueAt(selectedRow, 3);

                // Simulates scheduling an appointment [cite: 40]
                String message = "Request sent to " + provider + " for " + skillName + ".\nStatus: Pending";
                JOptionPane.showMessageDialog(panel, message, "Request Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a skill to learn first.", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Button to Add Skill (Method: addSkill() [cite: 36])
        JButton addSkillBtn = new JButton("Post Your Skill");
        addSkillBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Feature to 'addSkill()' would open here.");
        });

        actionPanel.add(requestBtn);
        actionPanel.add(addSkillBtn);
        return actionPanel;
    }

    public JPanel getPanel() {
        return panel;
    }
}