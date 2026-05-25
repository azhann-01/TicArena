package gui;

import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    JButton loginButton;
    JButton backButton;

    public LoginFrame() {

        setTitle("Login");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Arial", Font.BOLD,35)
        );
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Welcome Back");
        subtitle.setFont(new Font("Arial",Font.PLAIN,15)
        );
        subtitle.setForeground(Color.DARK_GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel formWrapper = new JPanel();
        formWrapper.setLayout(new FlowLayout());

        JPanel formPanel = new JPanel(new GridLayout(3,2,10,10)
        );
        formPanel.setPreferredSize(new Dimension(320,140));

        JLabel l1 = new JLabel("Username :");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Password :");
        JPasswordField p1 = new JPasswordField();

        formWrapper.add(formPanel);
        formPanel.add(l1);
        formPanel.add(t1);
        formPanel.add(l2);
        formPanel.add(p1);

        loginButton = new JButton("Login");
        backButton = new JButton("Back");

        Dimension buttonSize = new Dimension(150,40);

        loginButton.setMaximumSize(buttonSize);
        backButton.setMaximumSize(buttonSize);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT
        );
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT
        );

        backButton.addActionListener(
            e -> {
                new WelcomeFrame();
                dispose();
            }
        );

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(30)
        );
        mainPanel.add(subtitle);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(formWrapper);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(backButton);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);
        setVisible(true);
    }
}