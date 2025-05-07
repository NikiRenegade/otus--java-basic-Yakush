package ru.otus.chat.server;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryProvider implements AuthenticatedProvider, AuthorizationProvider {

    private List<User> users;
    private Server server;

    public InMemoryProvider(Server server) {
        this.users = new CopyOnWriteArrayList<>();
        this.server = server;
        User admin = new User("admin", "admin", "admin");
        admin.setRole(Role.ADMIN);
        users.add(admin);
        this.users.add(new User("qwe", "qwe", "qwe1"));
        this.users.add(new User("asd", "asd", "asd1"));
        this.users.add(new User("zxc", "zxc", "zxc1"));
    }

    @Override
    public void initialize() {
        System.out.println("InMemoryAuthenticatedProvider.initialize");

    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login.toLowerCase()) && user.getPassword().equals(password)) {
                return user.getUserName();
            }
        }
        return null;
    }

    private boolean isLoginAlreadyExists(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserNameAlreadyExists(String userName) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin(String userName) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getRole().equals(Role.ADMIN)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMessage("Некорректный логин/пароль");
            return false;
        }
        if (server.isUserNameBusy(authUsername)) {
            clientHandler.sendMessage("Указанная учетная запись уже занята");
            return false;
        }
        clientHandler.setUserName(authUsername);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/authok " + authUsername);


        return true;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String userName) {
        if (login.length() < 3) {
            clientHandler.sendMessage("Длина логина должна быть больше 3");

        }
        if (userName.length() < 3) {
            clientHandler.sendMessage("Длина имени пользователя должна быть больше 3");
            return false;
        }
        if (password.length() < 3) {
            clientHandler.sendMessage("Длина пароля должна быть больше 3");
            return false;
        }
        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMessage("Такой логин занят");
            return false;
        }
        if (isUserNameAlreadyExists(userName)) {
            clientHandler.sendMessage("Такое имя пользователя занято ");
            return false;
        }
        users.add(new User(userName, password, userName));
        clientHandler.setUserName(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMessage("/regok " + userName);
        return true;
    }

}
