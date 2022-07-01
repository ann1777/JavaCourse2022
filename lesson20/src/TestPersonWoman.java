import main.java.inheritance.Woman;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestPersonWoman {
    private static final Woman woman1 = new Woman("Swetlana", "Loboda", 38, true, 0, false, 3.20);
    private static final Woman woman2 = new Woman("Olga", "Sumska", 49, false, 3, false, 1.50);

    public TestPersonWoman() {
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

    @Test(description = "This is check if setName and getName methods works")
    public void setName() {
        System.out.println("\n----- START OF testing function setWomanName in TestClassWoman class -------------");
        System.out.println("Before setWomanName method Woman1 has name " + woman1.getName());
        woman1.setName("Maria");
        Assert.assertEquals("Maria", woman1.getName());
        System.out.println("After setWomanName method Woman1 has name " + woman1.getName());
        System.out.println("Before setWomanName method Woman2 has name " + woman2.getName());
        woman2.setName("Olesya");
        assert "Olesya".equals(woman2.getName());
        System.out.println("After setWomanName method Woman2 has name " + woman2.getName());
        woman2.setName("Tetiana");
        System.out.println("And now setWomanName method renamed Woman2 name to " + woman2.getName());
        System.out.println("----- END OF testing function setWomanName in TestClassWoman class -------------");
    }

    @Test(description = "This is check if setLastname and getLastname methods works for TestClassWoman class")
    public void setLastname(){
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
        woman1.setIsBlond();
        System.out.println("Woman1 isBlond "+woman1.getIsBlond());
        Assert.assertTrue(woman1.getIsBlond());
        System.out.println("----- END OF testing function testIsBlond in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setNumberOfChildren and getNumberOfChildren works", timeOut = 6000)
    public void setNumberOfChildren(){
        System.out.println("\n----- START OF testing function setNumberOfChildren and getNumberOfChildren in TestClassWoman class -------------");
        woman1.setAge(15);
        System.out.println("Woman1 is " + woman1.getAge() + " age old");
        woman1.setNumberOfChildren(2);
        System.out.println("Woman1 has " + woman1.getNumberOfChildren() + " children");
        Assert.assertEquals(woman1.getNumberOfChildren(), 0);
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
        Assert.assertFalse(woman1.isRetired());
        woman2.setAge(61);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        Assert.assertTrue(woman2.isRetired());
        Assert.assertEquals(woman2.getAge(), 61);
        woman2.setAge(59);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        Assert.assertFalse(woman2.isRetired());
        System.out.println("\n----- END OF testing function setIsRetired and setAge in TestClassWoman class -------------");
    }

    @Test(description = "this is check if getCurrentWeight, getLostWeight and setCurrentWeight works for class Woman")
    public void getCurrentWeight() {
        System.out.println("\n----- START OF testing function getCurrentWeight in TestClassWoman class -------------");
        woman1.setCurrentWeight(55.00);
        System.out.println("By default Woman1 has " + woman1.getCurrentWeight(57.5, 2.5) + " kg of weight");
        Assert.assertEquals(woman1.getCurrentWeight(57.5, 2.5), 55.00);
        woman1.getCurrentWeight(55.00, 12.40);
        System.out.println("After Woman1 has lost "+woman1.getLostWeight()+" kg she has " + woman1.getCurrentWeight(55.00, 12.40) + " kg of weight.");
        Assert.assertEquals(woman1.getCurrentWeight(55.00, 12.40), 42.6);
        System.out.println("----- END OF testing function getCurrentWeight in TestClassWoman class -------------");
    }
}

