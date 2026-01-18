package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasManeExpected;

    public LionParameterizedTest(String sex, boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters(name = "sex = {0}, hasManeExpected = {1}")
    public static Object[][] getParams() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void doesHaveManeShouldReturnCorrectValue() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        boolean hasMane = lion.doesHaveMane();
        assertEquals (hasManeExpected, hasMane);

    }
}
