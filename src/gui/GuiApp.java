package gui;

import javax.swing.*;

public class GuiApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Peer-to-Peer Skill Exchange");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hurry up with the other parts guys !!!! :)", SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}
