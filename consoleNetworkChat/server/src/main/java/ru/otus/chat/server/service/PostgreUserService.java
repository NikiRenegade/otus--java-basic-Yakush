package ru.otus.chat.server.service;

import javax.sql.DataSource;
import java.sql.*;

public class PostgreUserService implements UserService, AutoCloseable {

    private final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "P@$$w0rd";
    private final Connection connection;

    public PostgreUserService() throws SQLException {

        this.connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    @Override
    public String authenticate(String login, String password) {
        String sql = "SELECT authenticate_user(?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isLoginExists(String login) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT is_login_exists(?)")) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean isUserNameExists(String userName) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT is_username_exists(?)")) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public int registerUser(String login, String password, String userName) {
        String sql = "SELECT register_user(?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public boolean isAdmin(String userName) {

        try (PreparedStatement ps = connection.prepareStatement("SELECT is_user_admin(?)")) {
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
