package com.company.lesson20.src.test.java;
import com.company.lesson20.src.main.inheritance.Man;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.HashMap;

public class TestPersonMan{
//    private static final Man man1 = new Man("Ivan", "Mazepa", 58, false, true, 25000000.00);
//    private static final Man man2 = new Man("Stepan", "Bandera", 29, true, false, 780000.00);

    private final HashMap<Man, String> parseLocaleData = new HashMap<>();
    public TestPersonMan() {
    }
    @BeforeClass
    private void setup() {
        System.out.println("This is executed before each Class");
    }

    @AfterClass
    void tearDown() {
        parseLocaleData.clear();
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

    public HashMap<Man, String> getParseLocaleData() {
        return parseLocaleData;
    }

    @Test(description = "this is check if isRetired works for class Woman", dataProviderClass = test.DataProviders.class, dataProvider = "isRetired test data")
    @Parameters({"manAge", "isRetired"})
    public void setIsRetired(Man man1, boolean retired) {
        System.out.println("\n----- START OF testing function setIsRetired in TestClassMan class -------------");
        System.out.println(man1.getName()+" "+man1.getLastname()+ " is "+man1.getAge()+". He is retired "+man1.isRetired()+".");
        Assert.assertEquals(man1.isRetired(), retired);
        System.out.println("----- END OF testing function setIsRetired in TestClassMan class -------------");
    }

    @Test(description = "this is check if setGrossSalary and getGrossSalary works", dataProviderClass = test.DataProviders.class, dataProvider = "setGrossSalary test data")
    @Parameters({"grossSalary"})
    public void setGrossSalary(Man man1, double grossSalary) {
        System.out.println("\n----- START OF testing function setGrossSalary in TestClassMan class -------------");
        System.out.println(man1.getName()+" "+man1.getLastname()+ " wage is "+man1.getGrossSalary()+"$ per year");
        Assert.assertEquals(man1.getGrossSalary(), grossSalary);
        System.out.println("----- END OF testing function setGrossSalary in TestClassMan class -------------");
    }

    @Test(description = "this is check if setPartnerMale works", dataProviderClass = test.DataProviders.class, dataProvider = "setPartnerMale test data")
    @Parameters({"isPartnerMail"})
    public void setPartnerMale(Man man1, boolean isPartnerMail){
        System.out.println("\n----- START OF testing function setPartnerMale in TestClassMan class -------------");
        System.out.println(man1.getName()+" "+man1.getLastname()+ " has partner maile is "+man1.isPartnerMale());
        Assert.assertEquals(man1.isPartnerMale(), isPartnerMail);
        System.out.println("----- END OF testing function setPartnerMale in TestClassMan class -------------");
    }

    @Test(description = "this is check if isSmoking works", dataProviderClass = test.DataProviders.class, dataProvider = "isThisSmoking test data")
    @Parameters({"isSmoking"})
    public void isThisSmoking(Man man1, boolean isSmoking){
        System.out.println("\n----- START OF testing function isThisSmoking in TestClassMan class -------------");
        System.out.println(man1.getName()+" "+man1.getLastname()+ " is smoking "+man1.isSmoking());
        Assert.assertEquals(man1.isSmoking(), isSmoking);
        System.out.println("----- END OF testing function isThisSmoking in TestClassMan class -------------");
    }
}