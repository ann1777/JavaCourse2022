import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class TestPersonWoman {
    protected static TestPersonWoman woman1 = new TestPersonWoman();
    protected static TestPersonWoman woman2 = new TestPersonWoman();
    private final HashMap<TestPersonWoman, String> parseLocaleData = new HashMap<TestPersonWoman, String>();

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
}
