import main.java.inheritance.Man;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestPersonMan{
    private static final Man man1 = new Man("Ivan", "Mazepa", 58, false, true, 25000000.00);
    private static final Man man2 = new Man("Stepan", "Bandera", 29, true, false, 780000.00);

    public TestPersonMan() {
    }

    @BeforeClass
    private void setup() {
        System.out.println("This is executed before each Class");
    }

    @AfterClass
    void tearDown() {
        System.out.println("This is executed after each Class");
    }

    @BeforeTest
    public void beforeEachTest() {
        System.out.println("This is executed before each Test");
    }

    @AfterTest
    public void afterEachTest() {
        System.out.println("This is executed after each Test");
    }

    @Test(description = "This is check if setName and getName methods works")
    public void setName() {
        System.out.println("\n----- START OF testing function setManName in TestClassMan class -------------");
        System.out.println("Before setWomanName method Man1 has name " + man1.getName());
        man1.setName("Stepan");
        Assert.assertEquals("Stepan", man1.getName());
        System.out.println("After setManName method Man1 has name " + man1.getName());
        System.out.println("Before setManName method Man2 has name " + man2.getName());
        man2.setName("Borys");
        assert "Borys".equals(man2.getName());
        System.out.println("After setManName method Man2 has name " + man2.getName());
        man2.setName("Oleg");
        System.out.println("And now setManName method renamed Man2 name to " + man2.getName());
        System.out.println("----- END OF testing function setManName in TestClassMan class -------------");
    }

    @Test(description = "This is check if setLastname and getLastname methods works for TestClassMan class")
    public void setLastname(){
        System.out.println("\n----- START OF testing function setManLastname in TestClassMan class -------------");
        man1.setLastname("Mazepa");
        Assert.assertEquals("Mazepa", man1.getLastname());
        System.out.println("Man1 has lastname "+man1.getLastname());
        man2.setLastname("Shevchenko");
        assert "Shevchenko".equals(man2.getLastname());
        System.out.println("Man2 has lastname "+man2.getLastname());
        System.out.println("----- END OF testing setLastname and getLastname methods in TestClassMan class -------------");
    }

    @Test(description = "This is check if setAge and getAge methods works for TestClassMan class")
    public void setAge() {
        System.out.println("\n----- START OF testing function setAge and getAge in TestClassMan class -------------");
        System.out.println("By default Man1 is " + man1.getAge() + " years old.");
        man1.setAge(95);
        Assert.assertEquals(95, man1.getAge());
        System.out.println("After setAge method Man1 age is " + man1.getAge() + " years old.");
        System.out.println("By default Man2 is " + man2.getAge() + " years old.");
        man2.setAge(35);
        Assert.assertEquals(35, man2.getAge());
        Assert.assertTrue(man1.getAge() > man2.getAge());
        System.out.println("After setAge method Man2 is " + man2.getAge() + " years old.");
        System.out.println("----- END OF testing function setAge and getAge in TestClassMan class -------------");
    }

    @Test(description = "This is check if setGrossSalary and getGrossSalary methods works for TestClassMan class")
    public void getGrossSalary(){
        System.out.println("\n----- START OF testing function setGrossSalary and getGrossSalary in TestClassMan class -------------");
        man1.setGrossSalary(2580000.00);
        System.out.println("By default Man1 gets "+man1.getGrossSalary()+"$ per month.");
        Assert.assertEquals(2580000.00, man1.getGrossSalary());
        man2.setGrossSalary(1111000.00);
        System.out.println("By default Man1 gets "+man2.getGrossSalary()+"$ per month.");
        Assert.assertEquals(1111000.00, man2.getGrossSalary());
        Assert.assertTrue(man1.getGrossSalary()>man2.getGrossSalary());
        System.out.println("----- END OF testing function setGrossSalary and getGrossSalary in TestClassMan class -------------");
    }

    @Test(description = "This is check if setSmoking and isSmoking method works for TestClassMan class")
    public void setSmoking(){
        System.out.println("\n----- START OF testing function setSmoking and isSmoking in TestClassMan class -------------");
        man1.setSmoking(true);
        System.out.println("By default Man1 is smoking "+man1.isSmoking);
        Assert.assertTrue(man1.isSmoking);
        man2.setSmoking(false);
        System.out.println("By default Man2 is smoking "+man2.isSmoking);
        Assert.assertFalse(man2.isSmoking);
        System.out.println("----- END OF testing function setSmoking and isSmoking in TestClassMan class -------------");
    }

    @Test(description = "this is check if isRetired works for class TestClassMan")
    public void setIsRetired() {
        System.out.println("----- START OF testing function isRetired in TestClassMan class -------------");
        man1.setAge(18);
        System.out.println("\nMan1 is " + man1.getAge() + " age old");
        man1.isRetired();
        Assert.assertFalse(man1.isRetired());
        man2.setAge(66);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        Assert.assertEquals(man2.getAge(), 66);
        Assert.assertTrue(man2.isRetired());
        man2.setAge(64);
        System.out.println("\nMan2 is " + man2.getAge() + " age old");
        man2.isRetired();
        Assert.assertFalse(man2.isRetired());
        System.out.println("\n----- END OF testing function isRetired in TestClassMan class -------------");
    }
    @Test(description = "this is check if setGrossSalary and getGrossSalary works")
    public void setGrossSalary() {
        System.out.println("----- START OF testing function setGrossSalary in TestClassMan class -------------");
        man1.setGrossSalary(1200000.00);
        System.out.println("Man1 has " + man1.getGrossSalary() + " per month");
        Assert.assertEquals(man1.getGrossSalary(), 1200000.00);
        man2.setGrossSalary(2000500.00);
        System.out.println("And Man2 has " + man2.getGrossSalary() + " per month");
        Assert.assertEquals(man2.getGrossSalary(), 2000500.00);
        System.out.println("----- END OF testing function setGrossSalary in TestClassMan class -------------");
    }
    @Test(description = "this is check if setPartnerMale works")
    public void setPartnerMale(){
        System.out.println("----- START OF testing function setPartnerMale in TestClassMan class -------------");
        man1.setPartnerMale(true);
        man1.setLastname("Krugovoy");
        System.out.println("Man1 has boyfriend.");
        man1.registerPartnership2(man2, true);
        man2.setLastname("Davidenko");
        System.out.println("Man1's boyfriend name is "+ man2.getLastname());
        System.out.println("But man1 lastname is still "+man1.getLastname());
        Assert.assertEquals(man1.getLastname(), "Krugovoy");
        Assert.assertTrue(man2.getLastname() == "Davidenko");
        System.out.println("----- END OF testing function setPartnerMale in TestClassMan class -------------");
    }

    @Test(description = "this is check if isSmoking works")
    public void isThisSmoking(){
        System.out.println("----- START OF testing setSmoking and isSmoking methods in TestClassMan class -------------");
        man1.setSmoking(true);
        man1.setLastname("Krugovoy");
        Assert.assertEquals(man1.isSmoking, true);
        System.out.println(man1.getLastname()+ " is smoking " +man1.isSmoking());
        man2.setSmoking(false);
        man2.setLastname("Bureviy");
        Assert.assertFalse(man2.isSmoking());
        System.out.println(man2.getLastname()+ " is smoking " +man2.isSmoking());
        System.out.println("----- END OF testing setSmoking and isSmoking methods in TestClassMan class -------------");
    }

}