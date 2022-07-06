package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DBConnection {
    private static DBConnection instance;
    private static Connection dbConnection;
    private final String dbUrl;
    private final String dbUser;
    private static final Logger log = LogManager.getLogManager().getLogger(String.valueOf(DBConnection.class));

    private DBConnection(String url, String dbUser, String dbPassword) throws SQLException {
        dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUrl = url;
        this.dbUser = dbUser;
    }
}