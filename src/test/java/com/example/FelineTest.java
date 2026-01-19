package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private Feline feline;

    @Before
    public void initializeFeline() {
        feline = new Feline();
    }

    @Test
    public void shouldReturnCorrectPredatorFoodWhenCalledEatFoodTest() throws Exception {
        List<String> actualFood = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void shouldReturnFelineFamilyWhenGetFamilyTest() {
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи",actualFamily);
    }

    @Test
    public void shouldReturnOneKittenWhenGetKittensWithoutParamsTest() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

}



