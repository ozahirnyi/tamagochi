package world.ucode.model;

import java.sql.*;

public class Database {
    private Statement statement;
    private Connection connection;
    private DatabaseMetaData metaData;

    Database() {
        createDB();
    }

    private void createDB() {
        String url = "jdbc:sqlite:dontTryToHackMePlease";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                this.connection = conn;
                this.metaData = conn.getMetaData();
                createTables();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTables() throws SQLException {
        String insertLogins = "CREATE TABLE IF NOT EXISTS logins (\n"
                + "	name text NOT NULL,\n"
                + ");";

        statement = connection.createStatement();
        statement.execute(insertLogins);
    }

//    public boolean loadGame(String login) {
//        if ()
//    }
}
