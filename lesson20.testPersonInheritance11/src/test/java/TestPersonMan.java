import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonMan extends Man {
    private static final TestPersonMan man1 = new TestPersonMan();
    private static final TestPersonMan man2 = new TestPersonMan();
    private final HashMap<TestPersonMan, String> parseLocaleData = new HashMap<>();

    @BeforeClass
    private void Setup() {
        parseLocaleData.put(man1, TestPersonMan.getMan1().toString());
        parseLocaleData.put(man2, TestPersonMan.getMan2().toString());
        System.out.println("This is executed before each Class");
    }

    @AfterClass
    void tearDown() {
        parseLocaleData.clear();
        System.out.println("This is executed after each Class");
    }

    @BeforeTest
    public void BeforeEachTest() {
        System.out.println("This is executed before each Test");
    }

    @AfterTest
    public void AfterEachTest() {
        System.out.println("This is executed after each Test");
    }

    private static Object getMan1() {
        return man1;
    }

    private static Object getMan2() {
        return man2;
    }

    @Test(description = "this is check if isRetired works for class Woman")
    public void setIsRetired() {
        System.out.println("----- START OF testing function isRetired in TestClassWoman class -------------");
        man1.setAge(18);
        System.out.println("\nMan1 is " + man1.getAge() + " age old");
        man1.isRetired();
        man2.setAge(65);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        man2.setAge(64);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        System.out.println("\n----- END OF testing function isRetired in TestClassWoman class -------------");


    }
}
