package ru.otus.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;
    private AuthorizationProvider authorizationProvider;

    public Server(int port) {
        this.clients = new CopyOnWriteArrayList<>();
        this.port = port;
        InMemoryProvider inMemoryProvider = new InMemoryProvider(this);
        this.authenticatedProvider = inMemoryProvider;
        this.authorizationProvider = inMemoryProvider;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        broadcastMessage("Клиент " + clientHandler.getUserName() + " подключен");
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        broadcastMessage("Клиент " + clientHandler.getUserName() + " отключен");
        clients.remove(clientHandler);
    }

    public void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public boolean sendPrivateMessage(String clientName, String message) {
        for (ClientHandler clientHandler : clients) {
            if (clientHandler.getUserName().equals(clientName)) {
                clientHandler.sendMessage(message);
                return true;
            }
        }
        return false;
    }

    public boolean isUserNameBusy(String userName) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public void kickUser(String userName) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equals(userName)) {
                client.sendMessage("Админ отключил вас от сервера");
                client.sendMessage("/exitok");
                clients.remove(client);

            }
        }
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }
    public AuthorizationProvider getAuthorizationProvider() {
        return authorizationProvider;
    }
}
