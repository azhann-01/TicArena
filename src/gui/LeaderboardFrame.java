package gui;

import database.UserDAO;
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

        table = new JTable(model);

        loadLeaderboard();

        JScrollPane scrollPane = new JScrollPane(table);

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