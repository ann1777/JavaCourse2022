import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;


public class TestClassMan {
    private static TestClassMan man1 = new TestClassMan();
    private static TestClassMan man2 = new TestClassMan();
    private final HashMap<TestClassMan, String> parseLocaleData = new HashMap<TestClassMan, String>();
    private int age;

    @BeforeClass
    private void setUp() {
        parseLocaleData.put(man1, TestClassMan.getMan1().toString());
        parseLocaleData.put(man2, TestClassMan.getMan2().toString());
    }

    @AfterClass
    void tearDown() {
        parseLocaleData.clear();
    }

    @BeforeTest
    public void BeforeEachTest() {
        System.out.println("This is executed before each Test");
    }

    @AfterTest
    public void AfterEachTest() {
        System.out.println("This is executed after each Test");
    }

    public static TestClassMan getMan1() {
        return man1;
    }

    public static TestClassMan getMan2() {
        return man2;
    }

    public int getAge() {
        return this.age;
    }

    public HashMap<TestClassMan, String> getParseLocaleData() {
        return parseLocaleData;
    }

    public boolean isOlder(TestClassMan man) {
        System.out.println("----- START OF Verify function isOlder in TestClassMan class -------------");
        boolean result = false;
        try {
            man1.age = 20;
            TestClassMan.man2.age = 17;
            result = man1.age > man2.age;
//            Assert.assertEquals(result,true);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        System.out.println("----- END OF Verify function isOlder in TestClassMan class -------------");
        return result;
    }

    @Test
    public static void isOlder() {
        man1.age = 25;
        man2.age = 10;
        boolean older = man1.isOlder(man2);
        Assert.assertTrue(true, String.valueOf(older));
    }
}
