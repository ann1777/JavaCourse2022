package test;

import com.company.lesson20.src.main.inheritance.Man;
import com.company.lesson20.src.main.inheritance.Woman;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "isRetired test data")
    public static Object[][] getTestData1(){
        return new Object[][]{
                {new Man("Volodymir", "Zelensky", 46, false, false, 45000000.00), false},
                {new Man("Vasyl", "Stus", 78, true, true, 20000.00), true},
                {new Man("Borys", "Jonson", 58, false, true, 1500000000.00), false},
                {new Man("Donald", "Tramp", 76, false, true, 7500000.00), true},
                {new Man("Emmanuel", "Makron", 44, true, false,586000000.00), false},
                {new Man("Djo", "Baiden", 79, false, true, 12220000.00), true},
       };
    }
    @DataProvider(name = "setGrossSalary test data")
    public static Object[][] getTestData2() {
        return new Object[][]{
                {new Man("Volodymyr", "Zelensky", 46, false, false, 4500000.00), 4500000.00},
                {new Man("Vasyl", "Stus", 78, true, true, 20000.00), 20000.00},
                {new Man("Borys", "Jonson", 58, false, true, 1500000.00), 1500000.00},
                {new Man("Donald", "Tramp", 76, false, true, 7500000.00), 7500000.00},
                {new Man("Emmanuel", "Macron", 44, true, false,5000000.00), 5000000.00},
                {new Man("Djo", "Baden", 79, false, true, 1222000.00), 1222000.00},
       };
    }

    @DataProvider(name = "setPartnerMale test data")
    public static Object[][] getTestData3() {
        return new Object[][]{
                {new Man("Volodymyr", "Zelensky", 46, false, false, 4500000.00), false},
                {new Man("Vasyl", "Stus", 78, true, true, 20000.00), true},
                {new Man("Borys", "Jonson", 58, false, true, 1500000.00), false},
                {new Man("Donald", "Tramp", 76, false, true, 7500000.00), false},
                {new Man("Emmanuel", "Macron", 44, true, false,5000000.00), true},
                {new Man("Djo", "Baden", 79, false, true, 1222000.00), false},
        };
    }

    @DataProvider(name = "isThisSmoking test data")
    public static Object[][] getTestData4() {
        return new Object[][]{
                {new Man("Volodymyr", "Zelensky", 46, false, false, 4500000.00), false},
                {new Man("Vasyl", "Stus", 78, true, true, 20000.00), true},
                {new Man("Borys", "Jonson", 58, false, true, 1500000.00), true},
                {new Man("Donald", "Tramp", 76, false, true, 7500000.00), true},
                {new Man("Emmanuel", "Macron", 44, true, false,5000000.00), false},
                {new Man("Djo", "Baden", 79, false, true, 1222000.00), true},
        };
    }

    @DataProvider(name = "setName test data")
    public static Object[][] getTestData5() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), "Svetlana"},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), "Olena"},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), "Olga"},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), "Lesya"},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), "Lina"},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), "Ada"},
        };
    }

    @DataProvider(name = "setLastname test data")
    public static Object[][] getTestData6() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), "Loboda"},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), "Zelenska"},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), "Sumska"},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), "Ukrainka"},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), "Kostenko"},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), "Rogovtseva"},
        };
    }

    @DataProvider(name = "setAge test data")
    public static Object[][] getTestData7() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), 42},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), 45},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), 55},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), 36},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), 74},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), 59},
        };
    }

    @DataProvider(name = "testIsBlond test data")
    public static Object[][] getTestData8() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), true},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), true},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), true},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), true},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), false},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), false},
        };
    }

    @DataProvider(name = "setNumberOfChildren test data")
    public static Object[][] getTestData9() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), 0},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), 2},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), 1},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), 0},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), 2},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), 0},
        };
    }

    @DataProvider(name = "setIsRetired test data")
    public static Object[][] getTestData10() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), false},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), false},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), true},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), false},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), true},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), true},
        };
    }

    @DataProvider(name = "getLostweight test data")
    public static Object[][] getTestData11() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), 4.00},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), 1.00},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), 2.30},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), 5.00},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), 1.80},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), 0.80},
        };
    }

    @DataProvider(name = "getLostWeight test data")
    public static Object[][] getTestData12() {
        return new Object[][]{
                {new Woman("Svetlana", "Loboda", 42, false, 0,true, 4.00), 4.00},
                {new Woman("Olena", "Zelenska", 45, true, 2, true, 1.00), 1.00},
                {new Woman("Olga", "Sumska", 55, true, 1, true, 2.30), 2.30},
                {new Woman("Lesya", "Ukrainka", 36, false, 0, true, 5.00), 5.00},
                {new Woman("Lina", "Kostenko", 74, true, 2, false,1.80), 1.80},
                {new Woman("Ada", "Rogovtseva", 59, false, 0, false, 0.80), 0.80},
        };
    }
}