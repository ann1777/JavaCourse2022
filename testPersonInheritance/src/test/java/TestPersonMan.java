import lesson16.src.main.java.inheritance.Person;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonMan extends Person {
    private static final TestPersonMan man1 = new TestPersonMan();
    private static final TestPersonMan man2 = new TestPersonMan();
    private final HashMap<TestPersonMan, String> parseLocaleData = new HashMap<>();
    protected double grossSalary = 100000.00;
    private boolean isSmoking = false;

    public TestPersonMan(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double grossSalary) {
        super(name, lastname, age, isPartnerMale);
    }

    public TestPersonMan() {
        super();
    }

    public HashMap<TestPersonMan, String> getParseLocaleData() {
        return parseLocaleData;
    }

    private static Object getMan1() {
        return man1;
    }
    private static Object getMan2() {
        return man2;
    }

    private boolean setSmoking() {
            return this.isSmoking = true;
    }


    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    private double getGrossSalary() {
        return grossSalary;
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

    @Test(description = "This is check if setName and getName methods works")
    public void setManName(){
        System.out.println("\n----- START OF testing function setManName in TestClassMan class -------------");
        man1.setName("Oleg");
        Assert.assertEquals("Oleg", man1.getName());
        System.out.println("Man1 has name Oleg");
        man2.setName("Sergiy");
        assert "Sergiy".equals(man2.getName());
        System.out.println("Man2 has name Sergiy");
        System.out.println("----- END OF testing function setManName in TestClassMan class -------------");
    }

    @Test(description = "This is check if setLastname and getLastname methods works")
    public void setManLastname(){
        System.out.println("\n----- START OF testing function setManLastname in TestClassMan class -------------");
        man1.setLastname("Shevchenko");
        Assert.assertEquals("Shevchenko", man1.getLastname());
        System.out.println("Man1 has lastname Shevchenko");
        man2.setLastname("Lopata");
        assert "Lopata".equals(man2.getLastname());
        System.out.println("Man2 has lastname Lopata");
        System.out.println("----- END OF testing function setManLastname in TestClassMan class -------------");
    }

    @Test(description = "This is check if setAge and getAge methods works")
    public void setAge(){
        System.out.println("\n----- START OF testing function setAge in TestClassMan class -------------");
        man1.setAge(22);
        Assert.assertEquals(22, man1.getAge());
        System.out.println("Man1 is "+man1.getAge()+" years old.");
        man2.setAge(58);
        Assert.assertEquals(58, man2.getAge());
        System.out.println("Man2 is "+man2.getAge()+" years old.");
        System.out.println("----- END OF testing function setAge in TestClassMan class -------------");
    }

    @Test(description = "this is check if isRetired, setAge and getAge works for class Woman")
    public void setIsRetired() {
        System.out.println("\n----- START OF testing function setIsRetired in TestClassMan class -------------");
        man1.setAge(18);
        System.out.println("Man1 is " + man1.getAge() + " age old");
        man1.isRetired();
        Assert.assertEquals(man1.getAge(), 18);
        man2.setAge(65);
        System.out.println("Man2 is " + man2.getAge() + " age old");
        man2.isRetired();
        Assert.assertEquals(man2.getAge(), 65);
        man2.setAge(64);
        System.out.println("Man2 is " + man2.getAge() + " age old");
        man2.isRetired();
        System.out.println("----- END OF testing function setIsRetired in TestClassMan class -------------");
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
        man1.setSmoking();
        man1.setLastname("Krugovoy");
        Assert.assertEquals("Krugovoy", man1.getLastname(), "Man1 has lastname Krugovoy");
        Assert.assertTrue(man1.isSmoking, String.valueOf(true));
        System.out.println(man1.getLastname()+ " is smoking " +man1.isSmoking);
//        man2.setSmoking(false);
        man2.setLastname("Bureviy");
        Assert.assertEquals("Bureviy", man2.getLastname(), "Man1 has lastname Bureviy");
        Assert.assertFalse(man2.isSmoking);
        System.out.println(man2.getLastname()+ " is smoking " +man2.isSmoking);
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- END OF testing function isThisSmoking and setLastname in TestClassMan class -------------");
    }
}
