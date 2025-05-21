package ru.otus.chat.server;

import ru.otus.chat.server.service.UserService;

public class DataBaseProvider implements AuthorizationProvider, AuthenticatedProvider {
    private final Server server;
    private final UserService userService;

    public DataBaseProvider(Server server, UserService userService) {
        this.server = server;
        this.userService = userService;
    }

    @Override
    public void initialize() {
        System.out.println("PostgresProvider initialized");
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = userService.authenticate(login, password);
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
            return false;
        }
        if (userName.length() < 3) {
            clientHandler.sendMessage("Длина имени пользователя должна быть больше 3");
            return false;
        }
        if (password.length() < 3) {
            clientHandler.sendMessage("Длина пароля должна быть больше 3");
            return false;
        }
        if (userService.isLoginExists(login)) {
            clientHandler.sendMessage("Такой логин занят");
            return false;
        }
        if (userService.isUserNameExists(userName)) {
            clientHandler.sendMessage("Такое имя пользователя занято ");
            return false;
        }
        int userId = userService.registerUser(login, password, userName);
        if (userId != 0) {
            clientHandler.setUserName(userName);
            server.subscribe(clientHandler);
            clientHandler.sendMessage("/regok " + userName);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAdmin(String userName) {
        return userService.isAdmin(userName);
    }
}
