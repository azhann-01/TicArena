package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO users(username,password) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public void addWin(String username) {

        String query = "UPDATE users " +
                "SET wins = wins + 1, " +
                "score = score + 3 " +
                "WHERE username = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLoss(String username) {

        String query = "UPDATE users " +
                "SET losses = losses + 1 " +
                "WHERE username = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDraw(String username) {

        String query = "UPDATE users " +
                "SET draws = draws + 1, " +
                "score = score + 1 " +
                "WHERE username = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getLeaderboard() {

        try {
            Connection con = DBConnection.getConnection();

            String query = 
                "SELECT username, score, wins, losses, draws " +
                "FROM users " +
                "ORDER BY score DESC";
            PreparedStatement ps = con.prepareStatement(query);
            return ps.executeQuery();
        }

        catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}