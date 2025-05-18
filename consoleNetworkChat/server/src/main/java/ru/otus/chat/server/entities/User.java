package ru.otus.chat.server.entities;

public class User {
    private String login;
    private String password;
    private String userName;
    private Role role;
    public User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.role = Role.USER;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getUserName(){
        return userName;
    }
    public Role getRole(){
        return role;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setRole(Role role){
        this.role = role;
    }
}
