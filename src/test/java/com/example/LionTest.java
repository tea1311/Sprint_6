package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", feline);
        int actualKittens = lion.getKittens();
        assertEquals(5, actualKittens);
    }

    @Test
    public void getFoodReturnsValueFromFeline() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(foodExpected);
        Lion lion = new Lion( "Самка", feline);
        List<String> actualFood = lion.getFood();
        assertEquals(foodExpected, actualFood);
    }


    @Test(expected =  Exception.class)
    public void exceptionsForInvalidSex() throws Exception {
        String invalidSex = "Киса";
        new Lion(invalidSex, feline);
    }

    @Test
    public void returnsTrueForMaleAndFalseForFemale() throws Exception {
        Lion maleLion = new Lion("Самец", feline);
        assertEquals(true, maleLion.doesHaveMane());

        Lion femaleLion = new Lion("Самка", feline);
        assertEquals(false, femaleLion.doesHaveMane());
    }
}






