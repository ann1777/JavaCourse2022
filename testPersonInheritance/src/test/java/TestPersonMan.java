import lesson16.src.main.java.inheritance.Man;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.internal.thread.ThreadTimeoutException;

import java.util.HashMap;

public class TestPersonMan extends Man {
    private static final TestPersonMan man1 = new TestPersonMan();
    private static final TestPersonMan man2 = new TestPersonMan();
//    private final HashMap<TestPersonMan, String> parseLocaleData = new HashMap<>();

//    public TestPersonMan(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double salary) {
//        super(name, lastname, age, isPartnerMale, isSmoking, salary);
//    }

    public TestPersonMan() {
        super();
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @BeforeClass
    private void Setup() {
        System.out.println("This is executed before each Class");
    }

    @AfterClass
    void tearDown() {
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

//    private static Object getMan1() {
//        return man1;
//    }
//
//    private static Object getMan2() {
//        return man2;
//    }

    @Test(description = "this is check if isRetired, setAge and getAge works for class Woman")
    public void setIsRetired() {
        System.out.println("\n----- START OF testing function setIsRetired in TestClassMan class -------------");
        man1.setAge(18);
        System.out.println("Man1 is " + man1.getAge() + " age old");
        man1.isRetired();
        Assert.assertEquals(man1.getAge(), 18);
        man2.setAge(65);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        Assert.assertEquals(man2.getAge(), 65);
        man2.setAge(64);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        System.out.println("\n----- END OF testing function setIsRetired in TestClassMan class -------------");
    }
    @Test(description = "this is check if setGrossSalary and getGrossSalary works")
    public void setGrossSalary() {
        System.out.println("\n----- START OF testing function setGrossSalary in TestClassMan class -------------");
        man1.setGrossSalary(1200000.00);
        System.out.println("Man1 has " + man1.getGrossSalary() + " per month");
        Assert.assertEquals(man1.getGrossSalary(), 1200000.00);
        man2.setGrossSalary(2000500.00);
        System.out.println("And Man2 has " + man2.getGrossSalary() + " per month");
        Assert.assertEquals(man2.getGrossSalary(), 2000500.00);
        System.out.println("----- END OF testing function setGrossSalary in TestClassMan class -------------");
    }
    @Test(description = "this is check if setPartnerMale and setLastname works", invocationCount = 10)
    public void setPartnerMale(){
        System.out.println("\n----- START OF testing function setPartnerMale and setLastname in TestClassMan class -------------");
        man1.setPartnerMale(true);
        man1.setLastname("Krugovoy");
        Assert.assertEquals("Krugovoy", man1.lastname);
        System.out.println("Man1' lastname is "+man1.lastname);
        man1.registerPartnership2(man2, true);
        man2.setLastname("Davidenko");
        System.out.println("Man1's boyfriend name is "+ man2.getLastname());
        System.out.println("But after registerPartnership man1 lastname is still "+man1.getLastname());
        Assert.assertEquals("Davidenko", man2.lastname);
        System.out.println("----- END OF testing function setPartnerMale and setLastname in TestClassMan class -------------");
    }

    @Test(description = "this is check if isSmoking and setLastname works", timeOut = 5000)
    public void isThisSmoking(){
        System.out.println("\n----- START OF testing function isThisSmoking and setLastname in TestClassMan class -------------");
        man1.setSmoking(true);
        man1.setLastname("Krugovoy");
        Assert.assertEquals("Krugovoy", man1.getLastname(), "Man1 has lastname Krugovoy");
        Assert.assertTrue(man1.isSmoking, String.valueOf(true));
        System.out.println(man1.getLastname()+ " is smoking " +man1.isSmoking());
        man2.setSmoking(false);
        man2.setLastname("Bureviy");
        Assert.assertEquals("Bureviy", man2.getLastname(), "Man1 has lastname Bureviy");
        Assert.assertFalse(man2.isSmoking());
        System.out.println(man2.getLastname()+ " is smoking " +man2.isSmoking());
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- END OF testing function isThisSmoking and setLastname in TestClassMan class -------------");
    }

}
