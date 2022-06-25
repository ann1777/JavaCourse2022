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
        if (!isBlond) {
            return false;
        } else {
            return true;
        }
    }
    public HashMap<TestPersonWoman, String> getParseLocaleData() {
        return parseLocaleData;
    }

    @Test(description = "this is check if setIsBlond return isBlond")
    public void testIsBlond() {
        System.out.println("----- START OF testing function isBlond in TestClassWoman class -------------");
        woman1.setIsBlond();
        Assert.assertEquals(woman1.isBlond(true), this.isBlond(true));
        Assert.assertEquals(woman1.setIsBlond(), this.isBlond(true));
        Assert.assertEquals(woman2.isBlond(false), this.isBlond(false));
        Assert.assertEquals(woman2.setIsBlond(), this.isBlond(true));
        System.out.println("----- END OF testing function isBlond in TestClassWoman class -------------");
    }

    @Test(description = "this is check if setNumberOfChildren works")
    public void setNumberOfChildren() {
        System.out.println("----- START OF testing function setNumberOfChildren in TestClassWoman class -------------");
        woman1.setAge(15);
        System.out.println("Woman1 is " + woman1.getAge() + " age old");
        woman1.setNumberOfChildren(2);
        System.out.println("She has " + woman1.getNumberOfChildren() + " children");
        Assert.assertEquals(this.getNumberOfChildren(), 0);
        woman2.setAge(22);
        System.out.println("Woman2 is " + woman2.getAge() + " age old");
        woman2.setNumberOfChildren(4);
        System.out.println("She has already " + woman2.getNumberOfChildren() + " children");
        Assert.assertEquals(woman2.getNumberOfChildren(), 4);
        System.out.println("----- END OF testing function setNumberOfChildren in TestClassWoman class -------------");
    }

    @Test(description = "this is check if isRetired works for class Woman")
    public void setIsRetired() {
        System.out.println("----- START OF testing function isRetired in TestClassWoman class -------------");
        woman1.setAge(18);
        System.out.println("Woman1 is " + woman1.getAge() + " age old");
        woman1.isRetired();
        woman2.setAge(61);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        Assert.assertEquals(woman2.getAge(), 61);
        woman2.setAge(59);
        System.out.println("\nWoman2 is " + woman2.getAge() + " age old");
        woman2.isRetired();
        System.out.println("\n----- END OF testing function isRetired in TestClassWoman class -------------");
    }

    @Test(description = "this is check if getCurrentWeight works for class Woman")
    public void getCurrentWeight() {
        System.out.println("----- START OF testing function getCurrentWeight in TestClassWoman class -------------");
        woman1.setCurrentWeight(55.00);
        System.out.println("A few months ago she has " + woman1.weight + " kg of weight");
        woman1.getCurrentWeight(55.00, 12.40);
        System.out.println("After she lost 12.4 kg she has " + woman1.getCurrentWeight(55.00, 12.40) + " kg of weight now");
        Assert.assertEquals(woman1.getCurrentWeight(55.00, 12.40), 42.6);
        System.out.println("----- END OF testing function getCurrentWeight in TestClassWoman class -------------");
    }
}

