package app;

import menu.MainMenu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new MainMenu().start();
    }
}
