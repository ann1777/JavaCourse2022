package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DBTest extends BaseTest {
    private PreparedStatement preparedStatement;
    private String sqlPattern;
    private ResultSet rs;
    private static final Logger log = LogManager.getLogger();
    private Object DBConnection;

    @Test
    public void testCreateDB() throws SQLException {
        sqlPattern = "CREATE DATABASE users";
        preparedStatement = getConnectionServer().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("DataBase 'users' has been created successfully");
        } catch (SQLException e) {
            log.warning("DataBase 'users' already exist");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateTable() throws SQLException {
        sqlPattern = "CREATE TABLE IF NOT EXISTS users" +
                "(user_id serial PRIMARY KEY," +
                "user_firstname VARCHAR (40) NOT NULL," +
                "user_lastname  VARCHAR (40) NOT NULL," +
                "user_email VARCHAR (120) UNIQUE NOT NULL);";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("Table 'users' has been created successfully");
        } catch (SQLException e) {
            System.err.println("Table 'users' has not been created");
            e.printStackTrace();
        }
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Users test data")
    public void testInsertDataIntoTable(String data, int countRec) throws SQLException {
        sqlPattern = "INSERT INTO students(id,firstname,lastname,email) VALUES (" + data + ")";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("User " + data + "has been added successfully");
        } catch (SQLException e) {
            System.err.println("User " + data + "has not been added");
            e.printStackTrace();
        }

        sqlPattern = "SELECT count(*) FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        rs.next();
        Assert.assertEquals(rs.getInt(1), countRec);
    }
    
    @Test(dataProviderClass = DataProviders.class, dataProvider = "Users test data")
    public void testSelectDataFromTable() throws SQLException {
        sqlPattern = "SELECT * FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.printf("User is : %d %s %s  \n", rs.getInt("user_id"),
                    rs.getString("user_firstname"),
                    rs.getString("user_lastname"));
        }
    }
    
    @Test(dataProviderClass = DataProviders.class, dataProvider = "Users test data")
    public void testUpdateDataTable() throws SQLException {
        sqlPattern = "UPDATE students SET firstname = 'ChangedName' WHERE id > 2";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);

        try {
            preparedStatement.executeUpdate();
            log.info("Firstname of the first user with ID greater than 2 has been changed successfully");
        } catch (SQLException e) {
            System.err.println("Firstname of the first user with ID greater than 2 has not been changed");
            e.printStackTrace();
        }

        sqlPattern = "SELECT * FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.printf("User is : %d %s %s  \n", rs.getInt("user_id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"));
        }
    }
    
    @Test(dataProviderClass = DataProviders.class, dataProvider = "Users test data")
    public void testDeleteRecordIntoTable() throws SQLException {
        sqlPattern = "DELETE FROM students WHERE id >?;";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        preparedStatement.setInt(1, 2);
        preparedStatement.executeUpdate();

        sqlPattern = "SELECT count(*) FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        rs.next();
        Assert.assertEquals(rs.getInt(1), 2);
    }
    
    @Test(dataProviderClass = DataProviders.class, dataProvider = "Users test data")
    public void testDropTable() throws SQLException {
        sqlPattern = "DROP TABLE IF EXISTS students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Connection getDBConnection() throws SQLException {
        if (DBConnection != null) {
            DBConnection.getInstance(dbAddress, dbUser, dbPassword).getConnection();
        }
        return null;
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
            System.err.printf("Failed to close connection {}", e.getMessage());
        }
    }
}