package gui;

import database.UserDAO;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LeaderboardFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public LeaderboardFrame() {

        setTitle("Leaderboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String columns[] = {
                "Username",
                "Score",
                "Wins",
                "Losses",
                "Draws"
        };

        model = new DefaultTableModel(columns, 0);

        JLabel title = new JLabel("TICARENA LEADERBOARD", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.setEnabled(false);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        loadLeaderboard();

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        add(scrollPane);
        setVisible(true);
    }

    public void loadLeaderboard() {

        try {
            UserDAO dao = new UserDAO();
            ResultSet rs = dao.getLeaderboard();

            while (rs.next()) {
                Object row[] = {
                        rs.getString("username"),
                        rs.getInt("score"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws")
                };

                model.addRow(row);
            }
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
}