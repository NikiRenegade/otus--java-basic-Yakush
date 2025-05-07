package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String userName;
    private boolean authenticated = false;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        //     sendMessage("Вы подключились под ником: " + userName);
        new Thread(() -> {
            try {
                System.out.println("Client connected: " + socket.getPort());
                while (true) {
                    sendMessage("Вы не аутентифицированы. Перед работой пройдите аутентификацию '/auth login password'" +
                            "или зарегистрируйтесь '/reg login password username");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (message.startsWith("/auth ")) {
                            String token[] = message.split(" ");
                            if (token.length != 3) {
                                sendMessage("Неверный формат комманды auth");
                                continue;
                            }
                            if (server.getAuthenticatedProvider().authenticate(this, token[1], token[2])) {
                                authenticated = true;
                                break;
                            }
                        }
                        if (message.startsWith("/reg ")) {
                            String token[] = message.split(" ");
                            if (token.length != 4) {
                                sendMessage("Неверный формат комманды reg");
                                continue;
                            }
                            if(server.getAuthenticatedProvider().registration(this, token[0], token[1], token[2])) {
                                authenticated = true;
                                break;
                            }
                        }
                    }
                }
                while (authenticated) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMessage("/exitok");
                            break;
                        }
                        if (message.startsWith("/w")) {
                            var messageParse = message.split(" ");
                            if (messageParse.length < 3) {
                                sendMessage("Произошла ошибка! Сообщение не корректно!");
                                continue;
                            }
                            String clients = messageParse[1];
                            String newMessage = Arrays.stream(messageParse).skip(2).collect(Collectors.joining(" "));
                            newMessage = "Приватное сообщение от пользователя " + this.getUserName() + ": " + newMessage;
                            if (!server.sendPrivateMessage(clients, newMessage)) {
                                sendMessage("Произошла ошибка! Пользователь с данным именем не найден!");
                            }
                        }
                        if (message.startsWith("/kick")) {
                            var kickParameters = message.split(" ");
                            if (kickParameters.length != 2) {
                                sendMessage("Не верный формат комманды kick");
                                continue;
                            }
                            if (!server.getAuthorizationProvider().isAdmin(userName)){
                                sendMessage("Вы не являетесь админом и не иммете права на удаления из чата других пользователей!");
                                continue;
                            }
                            server.kickUser(kickParameters[1]);
                        }
                        else {
                            sendMessage("Знак '/' преднозначен для отправки комманд. Данной команды не существует");
                        }
                    } else {
                        server.broadcastMessage(userName + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void disconnect() {
        try {
            server.unsubscribe(this);
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
