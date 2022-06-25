import lesson16.src.main.java.inheritance.Man;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonMan extends Man {
    private static final TestPersonMan man1 = new TestPersonMan();
    private static final TestPersonMan man2 = new TestPersonMan();
    private final HashMap<TestPersonMan, String> parseLocaleData = new HashMap<>();
    private int age;

    public TestPersonMan(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double salary) {
        super(name, lastname, age, isPartnerMale, isSmoking, salary);
    }

    public TestPersonMan() {
        super();
    }

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

    public HashMap<TestPersonMan, String> getParseLocaleData() {
        return parseLocaleData;
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
    @Test(description = "this is check if setGrossSalary and getGrossSalary works")
    public void setGrossSalary() {
        System.out.println("----- START OF testing function setNumberOfChildren in TestClassWoman class -------------");
        man1.setGrossSalary(1200000.00);
        System.out.println("Man1 has " + man1.getGrossSalary() + " per month");
        man2.setGrossSalary(2000500.00);
        System.out.println("And Man2 has " + man2.getGrossSalary() + " per month");
        System.out.println("----- END OF testing function setNumberOfChildren in TestClassWoman class -------------");
    }
    @Test(description = "this is check if setPartnerMale works")
    public void setPartnerMale(){
        System.out.println("----- START OF testing function setNumberOfChildren in TestClassWoman class -------------");
        man1.setPartnerMale(true);
        man1.setLastname("Krugovoy");
        System.out.println("Man1 has boyfriend.");
        man1.registerPartnership2(man2, true);
        man2.setLastname("Davidenko");
        System.out.println("Man1's boyfriend name is "+ man2.getLastname());
        System.out.println("But man1 lastname is still "+man1.getLastname());
        System.out.println("----- END OF testing function setNumberOfChildren in TestClassWoman class -------------");
    }

    @Test(description = "this is check if isSmoking works")
    public void isSmoking(){
        System.out.println("----- START OF testing function setNumberOfChildren in TestClassWoman class -------------");
        man1.setSmoking(true);
        man1.setLastname("Krugovoy");
        System.out.println(man1.getLastname()+" is smoking "+man1.isSmoking);
        man2.setSmoking(false);;
        man2.setLastname("Davidenko");
        System.out.println(man2.getLastname()+" is smoking "+man2.isSmoking);
        System.out.println("----- END OF testing function setNumberOfChildren in TestClassWoman class -------------");
    }

}
