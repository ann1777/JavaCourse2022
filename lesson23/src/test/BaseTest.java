package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseTest {
    public static String dbServerAddress = "jdbc:postgresql://localhost:5432/";
    public static String dbAddress = "jdbc:postgresql://localhost:5432/students";
    public static String dbUser = "postgres";
    public static String dbPassword = "angel";

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected Connection getConnectionDB() throws SQLException {
        try {
            return DBConnection.getInstance(dbAddress, dbUser, dbPassword).getConnection();
        } catch (SQLException e) {
            log.error("Failed to get DBConnection\n {}", e.getMessage());
        }
        return null;
    }

    @BeforeSuite
    protected Connection getConnectionServer() {
        try {
            return DBConnection.getInstance(dbServerAddress, dbUser, dbPassword).getConnection();
        } catch (SQLException ex) {
            log.error("Failed to get ServerConnection\n {}", ex.getMessage());
        }
        return null;
    }


    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException exc) {
            log.error("Failed to close connection {}", exc.getMessage());
        }
    }
}

