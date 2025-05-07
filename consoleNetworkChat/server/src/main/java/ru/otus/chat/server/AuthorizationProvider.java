package ru.otus.chat.server;

public interface AuthorizationProvider {
    boolean isAdmin(String userName);
}
