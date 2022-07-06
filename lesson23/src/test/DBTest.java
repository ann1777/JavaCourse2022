package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DBTest extends BaseTest {
    private PreparedStatement preparedStatement;
    private String sqlPattern;
    private ResultSet rs;
    private static final Logger log = LogManager.getLogger();
    private Object DBConnection;
}