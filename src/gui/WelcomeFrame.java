package gui;

import java.awt.*;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    JButton loginButton;
    JButton registerButton;
    JButton exitButton;

    public WelcomeFrame() {

        setTitle("TicArena");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("TicArena");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Real-Time Multiplayer Board Game");

        subtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setPreferredSize(subtitle.getPreferredSize());
        subtitle.setForeground(Color.DARK_GRAY);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");

        Dimension buttonSize = new Dimension(180, 40);

        loginButton.setMaximumSize(buttonSize);
        registerButton.setMaximumSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalGlue());

        mainPanel.add(title);

        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(subtitle);

        mainPanel.add(Box.createVerticalStrut(35));

        mainPanel.add(loginButton);

        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(registerButton);

        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(exitButton);

        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);

        exitButton.addActionListener(
                e -> System.exit(0));

        setVisible(true);
    }
}