import lesson16.src.main.java.inheritance.Person;
import lesson16.src.main.java.inheritance.Woman;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonWoman extends Woman {
    private static final TestPersonWoman woman1 = new TestPersonWoman();
    private static final TestPersonWoman woman2 = new TestPersonWoman();
    private final HashMap<TestPersonWoman, String> parseLocaleData = new HashMap<>();

    public TestPersonWoman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond, double lostWeight) {
        super(name, lastname, age, isPartnerMale, numberOfChildren, isBlond, lostWeight);
    }

    public TestPersonWoman() {
        super();
    }

    @BeforeClass
    private void Setup() {
        parseLocaleData.put(woman1, TestPersonWoman.getWoman1().toString());
        parseLocaleData.put(woman2, TestPersonWoman.getWoman2().toString());
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

    private static Object getWoman1() {
        return woman1;
    }
    private static Object getWoman2() {
        return woman2;
    }
    public boolean isBlond(boolean isBlond) {
        return isBlond;
    }
    public HashMap<TestPersonWoman, String> getParseLocaleData() {
        return parseLocaleData;
    }
    public boolean isOlder(Person woman){
        return this.getAge() > woman.getAge();
    }

    public boolean getIsBlond(){
        return this.isBlond;
    }

    @Test(description = "This is check if setName and getName methods works")
    public void setWomanName(){
        System.out.println("\n----- START OF testing function setWomanName in TestClassWoman class -------------");
        System.out.println("Before setWomanName method Woman1 has name "+woman1.getName());
        woman1.setName("Maria");
        Assert.assertEquals("Maria", woman1.getName());
        System.out.println("After setWomanName method Woman1 has name "+woman1.getName());
        System.out.println("Before setWomanName method Woman2 has name "+woman2.getName());
        woman2.setName("Olesya");
        assert "Olesya".equals(woman2.getName());
        System.out.println("After setWomanName method Woman2 has name "+woman2.getName());
        woman2.setName("Tetiana");
        System.out.println("And now setWomanName method renamed Woman2 name to "+woman2.getName());
        System.out.println("----- END OF testing function setWomanName in TestClassWoman class -------------");
    }

    @Test(description = "This is check if setLastname and getLastname methods works for TestClassWoman class")
    public void setWomanLastname(){
        System.out.println("\n----- START OF testing function setWomanLastname in TestClassWoman class -------------");
        woman1.setLastname("Nechitailo");
        Assert.assertEquals("Nechitailo", woman1.getLastname());
        System.out.println("Woman1 has lastname "+woman1.getLastname());
        woman2.setLastname("Zhurba");
        assert "Zhurba".equals(woman2.getLastname());
        System.out.println("Woman2 has lastname "+woman2.getLastname());
        System.out.println("----- END OF testing function setWomanLastname in TestClassWoman class -------------");
    }

    @Test(description = "This is check if setAge and getAge methods works for TestClassWoman class")
    public void setAge(){
        System.out.println("\n----- START OF testing function setAge in TestClassWoman class -------------");
        System.out.println("By default Woman1 is "+woman1.getAge()+" years old.");
        woman1.setAge(18);
        Assert.assertEquals(18, woman1.getAge());
        System.out.println("After setAge method Woman1 age is "+woman1.getAge()+" years old.");
        System.out.println("By default Woman2 is "+woman2.getAge()+" years old.");
        woman2.setAge(55);
        Assert.assertEquals(55, woman2.getAge());
        Assert.assertTrue(woman1.getAge()<woman2.getAge());
        Assert.assertFalse(woman1.isOlder(woman2));
        System.out.println("After setAge method Woman2 is "+woman2.getAge()+" years old.");
        System.out.println("----- END OF testing function setAge in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setIsBlond return isBlond", invocationCount = 5)
    public void testIsBlond() {
        System.out.println("\n----- START OF testing function testIsBlond in TestClassWoman class -------------");
        System.out.println("By default Woman1 isBlond "+woman1.getIsBlond());
        woman1.setIsBlond();
        Assert.assertEquals(woman1.isBlond(true), this.isBlond(true));
        Assert.assertEquals(woman1.setIsBlond(), this.isBlond(true));
        System.out.print("But after setIsBlond method Woman1 is blond " + woman2.isBlond(true)+"\n");
        Assert.assertEquals(woman2.isBlond(false), this.isBlond(false));
        Assert.assertEquals(woman2.setIsBlond(), this.isBlond(true));
        System.out.println("Woman2 is still blond " + woman2.isBlond(false));
        System.out.println("----- END OF testing function testIsBlond in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setNumberOfChildren and getNumberOfChildren works", timeOut = 6000)
    public void setNumberOfChildren() {
        System.out.println("\n----- START OF testing function setNumberOfChildren and getNumberOfChildren in TestClassWoman class -------------");
        woman1.setAge(15);
        System.out.println("Woman1 is " + woman1.getAge() + " age old");
        woman1.setNumberOfChildren(2);
        System.out.println("Woman1 has " + woman1.getNumberOfChildren() + " children");
        Assert.assertEquals(this.getNumberOfChildren(), 0);
        woman2.setAge(22);
        System.out.println("Woman2 is " + woman2.getAge() + " age old");
        woman2.setNumberOfChildren(4);
        System.out.println("Woman2 has already " + woman2.getNumberOfChildren() + " children");
        Assert.assertEquals(woman2.getNumberOfChildren(), 4);
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- END OF testing function setNumberOfChildren and getNumberOfChildren in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setIsRetired snd setAge works for class Woman")
    public void setIsRetired() {
        System.out.println("\n----- START OF testing function setIsRetired and setAge in TestClassWoman class -------------");
        woman1.setAge(18);
        System.out.println("Woman1 is " + woman1.getAge() + " age old");
        woman1.isRetired();
        Assert.assertEquals(woman1.isRetired, false);
        Assert.assertFalse(woman1.isRetired);
        woman2.setAge(61);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        Assert.assertTrue(woman2.isRetired);
        Assert.assertEquals(woman2.getAge(), 61);
        woman2.setAge(59);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        Assert.assertFalse(woman2.isRetired);
        System.out.println("\n----- END OF testing function setIsRetired and setAge in TestClassWoman class -------------");
    }

    @Test(description = "this is check if getCurrentWeight, getLostWeight and setCurrentWeight works for class Woman")
    public void getCurrentWeight() {
        System.out.println("\n----- START OF testing function getCurrentWeight in TestClassWoman class -------------");
        System.out.println("By default Woman1 has " + woman1.weight + " kg of weight");
        woman1.setCurrentWeight(55.00);
        Assert.assertEquals(woman1.weight, 55.00);
        System.out.println("After setCurrentWeight method Woman1 has " + woman1.weight + " kg of weight");
        woman1.getCurrentWeight(55.00, 12.40);
        System.out.println("Then Woman1 has lost "+woman1.getLostWeight()+" kg now she has " + woman1.getCurrentWeight(55.00, 12.40) + " kg of weight");
        Assert.assertEquals(woman1.getCurrentWeight(55.00, 12.40), 42.6);
        System.out.println("----- END OF testing function getCurrentWeight in TestClassWoman class -------------");
    }
}

