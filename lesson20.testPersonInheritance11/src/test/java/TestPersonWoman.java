import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonWoman extends Woman {
    private static final TestPersonWoman woman1 = new TestPersonWoman();
    private static final TestPersonWoman woman2 = new TestPersonWoman();
    private final HashMap<TestPersonWoman, String> parseLocaleData = new HashMap<>();

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

}
