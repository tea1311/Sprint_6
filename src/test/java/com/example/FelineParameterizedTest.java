package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "kittensCount = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0},
                {1},
                {5},
                {11}
        });
    }

    @Test
    public void getKittensShouldReturnPassedValueTest() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actualKittensCount);
    }
}


