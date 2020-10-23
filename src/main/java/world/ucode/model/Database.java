package world.ucode.model;

import java.sql.*;

public class Database {
  private ResultSet resultSet;
  private Statement statement;
  private Connection connection;

  Database() {
    createDB();
    createTables();
  }

  private void createDB() {
    String url = "jdbc:sqlite:dontTryToHackMePlease.s3db";

    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection(url);
    } catch (SQLException | ClassNotFoundException throwables) {
      throwables.printStackTrace();
    }
  }

  private void createTables() {
    String insertLogins = "CREATE TABLE IF NOT EXISTS 'users' (name text PRIMARY KEY NOT NULL);";

    try {
      statement = connection.createStatement();
      statement.execute(insertLogins);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public boolean loadGame(String login) {
    String findQuery = "SELECT name FROM users WHERE name = '" + login + "'";

    try {
      resultSet = statement.executeQuery(findQuery);
      return !resultSet.getString("name").isEmpty();
    } catch (SQLException throwables) {
      return false;
    }
  }

  public boolean newGame(String login) {
    String addQuery = "INSERT INTO users(name) VALUES('" + login + "')";

    try {
      statement.execute(addQuery);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }
}
