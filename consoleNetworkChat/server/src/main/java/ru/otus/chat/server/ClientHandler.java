package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String userName;
    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        userName = "user" + socket.getPort();
        sendMessage("Вы подключились под ником: " + userName);
        new Thread(() -> {
            try {
                System.out.println("Client connected: " + socket.getPort());
                while (true) {
                    String message = in.readUTF();
                    if(message.startsWith("/")) {
                        if(message.equals("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if(message.startsWith("/w")) {
                            var messageParse = message.split(" ");
                            String clients = messageParse[1];
                            String newMessage = "Приватное сообщение от пользователя " + this.getUserName() + ": " + messageParse[2];
                            server.sendPrivateMessage(clients, newMessage);
                        }
                    }
                    else {
                        server.broadcastMessage(userName + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            finally {
                disconnect();
            }
        }).start();
    }
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getUserName() {
        return userName;
    }
    public void disconnect() {
        try {
            server.unsubscribe(this);
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
            if(socket != null){
                socket.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
