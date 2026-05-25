package main;

import database.DBConnection;
import gui.WelcomeFrame;

public class TestDB {

    public static void main(String[] args) {

        DBConnection.getConnection();

        new WelcomeFrame();
    }
}