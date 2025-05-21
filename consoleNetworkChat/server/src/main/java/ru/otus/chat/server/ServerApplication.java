package ru.otus.chat.server;

import java.sql.SQLException;

public class ServerApplication {
    public static void main(String[] args) throws SQLException {
        int port = 8087;
        new Server(port).start();
    }
}
