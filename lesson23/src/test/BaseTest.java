package test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    public static String dbServerAddress = "jdbc:postgresql://localhost:5432/";
    public static String dbAddress = "jdbc:postgresql://localhost:5432/students";
    public static String dbUser = "postgres";
    public static String dbPassword = "angel";

    private static final Logger log = LogManager.getLogger(BaseTest.class);
}

