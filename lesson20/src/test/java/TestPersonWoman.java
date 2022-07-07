package com.company.lesson20.src.test.java;
import com.company.lesson20.src.main.inheritance.Woman;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.HashMap;

public class TestPersonWoman {
    private static final Woman woman1 = new Woman("Swetlana", "Loboda", 38, true, 0, false, 3.20);
    private static final Woman woman2 = new Woman("Olga", "Sumska", 49, false, 3, true, 1.50);
    private final HashMap<Woman, String> parseLocaleData = new HashMap<Woman, String>();
    private String name;
    private String lastname;
    private int age;
    protected boolean isPartnerMale;
    private int numberOfChildren;
    private boolean isBlond;
    private double lostWeight;

    public TestPersonWoman() {
    }


    @BeforeClass
    private void Setup() {
//        parseLocaleData.put(woman1, TestPersonWoman.getWoman1().toString());
//        parseLocaleData.put(woman2, TestPersonWoman.getWoman2().toString());
        System.out.println("This is executed before each Class");
    }

    @AfterClass
    void tearDown() {
//        parseLocaleData.clear();
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

    private static Object getWoman1() {
        return woman1;
    }

    private static Object getWoman2() {
        return woman2;
    }

    public boolean isBlond(boolean isBlond) {
        return isBlond;
    }

    public HashMap<Woman, String> getParseLocaleData() {
        return parseLocaleData;
    }

    public boolean isOlder(TestPersonWoman woman) {
        return this.getAge() > woman.getAge();
    }

    private String getName() {
        return this.name;
    }

    private String getLastname() {
        this.lastname = lastname;
        return lastname;
    }

    private int getAge() {
        return this.age;
    }

    public int getNumberOfChildren() {
        return this.numberOfChildren;
    }

    private boolean setIsBlond() {
        return isBlond;
    }


    @Test(description = "This is check if setName and getName methods works for TestClassWoman class", dataProviderClass = test.DataProviders.class, dataProvider = "setName test data")
    @Parameters({"womanName", "name"})
    public void setName(Woman woman1, String name) {
        System.out.println("\n----- START OF testing function setName in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " is set name "+woman1.getName());
        Assert.assertEquals(woman1.getName(), name);
        System.out.println("----- END OF testing function setName in TestClassWoman class -------------");
    }


    @Test(description = "This is check if setLastname and getLastname methods works for TestClassWoman class",  dataProviderClass = test.DataProviders.class, dataProvider = "setLastname test data")
    @Parameters({"womanLastname", "lastname"})
    public void setLastname(Woman woman1, String lastname){
        System.out.println("\n----- START OF testing function setWomanLastname in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " is set name "+woman1.getLastname());
        Assert.assertEquals(woman1.getLastname(), lastname);
        System.out.println("----- END OF testing function setWomanLastname in TestClassWoman class -------------");
    }

    @Test(description = "This is check if setAge and getAge methods works for TestClassWoman class",  dataProviderClass = test.DataProviders.class, dataProvider = "setAge test data")
    @Parameters({"womanLastname", "lastname"})
    public void setAge(Woman woman1, int age){
        System.out.println("\n----- START OF testing function setAge in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " is set name "+woman1.getAge());
        Assert.assertEquals(woman1.getAge(), age);
        System.out.println("----- END OF testing function setAge in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setIsBlond return isBlond", invocationCount = 5, dataProviderClass = test.DataProviders.class, dataProvider = "testIsBlond test data")
    @Parameters({"womanNatural", "isBlond"})
    public void testIsBlond(Woman woman1, boolean isBlond) {
        System.out.println("\n----- START OF testing function testIsBlond in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " is blond "+woman1.isBlond());
        Assert.assertEquals(woman1.isBlond(), isBlond);
        System.out.println("----- END OF testing function testIsBlond in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setNumberOfChildren and getNumberOfChildren works", timeOut = 6000, dataProviderClass = test.DataProviders.class, dataProvider = "setNumberOfChildren test data")
    @Parameters({"numberChildren", "children"})
    public void setNumberOfChildren(Woman woman1, int numberOfChildren){
        System.out.println("\n----- START OF testing function setNumberOfChildren and getNumberOfChildren in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " has "+woman1.getNumberOfChildren()+ " children.");
        Assert.assertEquals(woman1.getNumberOfChildren(), numberOfChildren);
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- END OF testing function setNumberOfChildren and getNumberOfChildren in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setIsRetired snd setAge works for class Woman", dataProviderClass = test.DataProviders.class, dataProvider = "setIsRetired test data")
    @Parameters({"isRetires", "age"})
    public void setIsRetired(Woman woman1, boolean getIsRetired) {
        System.out.println("\n----- START OF testing function setIsRetired and setAge in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " is retired "+woman1.isRetired()+ ". She is "+woman1.getAge()+" years old.");
        Assert.assertEquals(woman1.isRetired(), getIsRetired);
        System.out.println("\n----- END OF testing function setIsRetired and setAge in TestClassWoman class -------------");
    }

    @Test(description = "this is check if getCurrentWeight, getLostWeight and setCurrentWeight works for class Woman", dataProviderClass = test.DataProviders.class, dataProvider = "getLostweight test data")
    @Parameters({"currentWeight", "lostweight"})
    public void getLostWeight(Woman woman1, double lostWeight) {
        System.out.println("\n----- START OF testing function getCurrentWeight in TestClassWoman class -------------");
        System.out.println(woman1.getName()+" "+woman1.getLastname()+ " has current weight "+woman1.getLostWeight()+ ".");
        Assert.assertEquals(woman1.getLostWeight(), lostWeight);
        System.out.println("----- END OF testing function getCurrentWeight in TestClassWoman class -------------");
    }
}