package ru.otus.chat.server.service;

public interface UserService {
    String authenticate(String login, String password);

    boolean isLoginExists(String login);

    boolean isUserNameExists(String userName);

    int registerUser(String login, String password, String userName);

    boolean isAdmin(String userName);
}
