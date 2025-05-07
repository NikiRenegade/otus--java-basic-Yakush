package ru.otus.chat.server;

public class ServerApplication {
    public static void main(String[] args) {
        int port = 8087;
        new Server(port).start();
    }
}
