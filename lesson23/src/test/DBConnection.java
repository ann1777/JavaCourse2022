package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DBConnection {
    private static DBConnection instance;
    private static Connection dbConnection;
    private static String dbUrl;
    private final String dbUser;
    private static final Logger log = LogManager.getLogManager().getLogger(String.valueOf(DBConnection.class));

    private DBConnection(String url, String dbUser, String dbPassword) throws SQLException {
        dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUrl = url;
        this.dbUser = dbUser;
    }

    public static Connection getConnection() {
        return dbConnection;
    }

    public static DBConnection getInstance(String dbAddress, String dbUser, String dbPassword) throws SQLException {
        DBConnection instance = null;
        if (instance == null) {
            instance = new DBConnection(dbUrl, dbUser, dbPassword);
        } else if (!instance.equals(dbUser)) {
            log.warning("Connection is open with wrong credentials");
        }
        return instance;
    }

    public static void closeConnection() {
        if (instance != null) {
            try {
                dbConnection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}