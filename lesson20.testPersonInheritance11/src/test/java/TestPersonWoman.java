import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonWoman extends Woman {
    private static final TestPersonWoman woman1 = new TestPersonWoman();
    private static final TestPersonWoman woman2 = new TestPersonWoman();
    private final HashMap<TestPersonWoman, String> parseLocaleData = new HashMap<>();
    private double setWeight;

    public TestPersonWoman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond, double lostWeight) {
        super(name, lastname, age, isPartnerMale, numberOfChildren, isBlond, lostWeight);
        this.name = name;
        this.lastname = birthLastname;
        this.age = age;
        this.isBlond = isBlond;
    }

    public TestPersonWoman() {

    }


    @BeforeClass
    private void Setup(){
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
    private boolean isBlond(boolean isBlond) {
        if (!isBlond) {
            return false;
        } else {
            return true;
        }
    }

    public HashMap<TestPersonWoman, String> getParseLocaleData() {
        return parseLocaleData;
    }
    public boolean setIsBlond() {
        System.out.println("----- START OF Verify function isBlond in TestClassWoman class -------------");
        if (this.isBlond(false)){
            try {
                return this.isBlond(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("----- END OF Verify function isBlond in TestClassWoman class -------------");
        return this.isBlond(true);
    }

    public int setNumberOfChildren(int age, int numberOfChildren) {
        System.out.println("----- START OF Verify function setNumberOfChildren in TestClassWoman class -------------");
        if (this.age > 18) {
            try {
                this.setNumberOfChildren(numberOfChildren);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("She is too young woman to have children.");
            }
            System.out.println("----- END OF Verify function setNumberOfChildren in TestClassWoman class -------------");
            return numberOfChildren;
    }

    public int getNumberOfChildren() {
        return this.numberOfChildren;
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
    public void setNumberOfChildren(){
        System.out.println("----- START OF testing function setNumberOfChildren in TestClassWoman class -------------");
        woman1.setAge(15);
        System.out.println("Woman1 is "+woman1.getAge()+" age old");
        woman1.setNumberOfChildren(16, 2);
        System.out.println("She has "+woman1.getNumberOfChildren()+" children");
        woman2.setAge(22);
        System.out.println("Woman2 is "+woman2.getAge()+" age old");
        woman2.setNumberOfChildren(22, 4);
        System.out.println("She has already "+woman2.getNumberOfChildren()+" children");
        System.out.println("----- END OF testing function setNumberOfChildren in TestClassWoman class -------------");
    }

    @Test(description = "this is check if isRetired works for class Woman")
    public void setIsRetired(){
        System.out.println("----- START OF testing function isRetired in TestClassWoman class -------------");
        woman1.setAge(18);
        System.out.println("Woman1 is "+woman1.getAge()+" age old");
        woman1.isRetired();
        woman2.setAge(60);
        System.out.println("Woman2 is "+woman2.getAge()+" age old");
        woman2.isRetired();
        woman2.setAge(59);
        System.out.println("Woman2 is "+woman2.getAge()+" age old");
        woman2.isRetired();
        System.out.println("----- END OF testing function isRetired in TestClassWoman class -------------");

    }

    @Test(description = "this is check if setLostWeight works for class Woman")
    public void setLostWeight() {
        System.out.println("----- START OF testing function setLostWeight in TestClassWoman class -------------");
        woman1.weight = (double) 55.00;
        System.out.println("This woman had have " + woman1.weight + " kg of weight");
        woman1.setLostWeight(12.4);
        System.out.println("She had lost " + 12.4 + " kg of weight");
        System.out.println("----- END OF testing function setLostWeight in TestClassWoman class -------------");
    }

    @Test(description = "this is check if getCurrentWeight works for class Woman")
    public void getCurrentWeight() {
        System.out.println("----- START OF testing function getCurrentWeight in TestClassWoman class -------------");
        woman1.setWeight(55.00);
        System.out.println("A few months ago she has "+woman1.getWeight()+" kg of weight");
        woman1.getCurrentWeight(55.00, 12.40);
        System.out.println("After she lost 12.4 kg she has "+ woman1.getCurrentWeight(55.00, 12.40) + " kg of weight now");
        System.out.println("----- END OF testing function getCurrentWeight in TestClassWoman class -------------");
    }

}
