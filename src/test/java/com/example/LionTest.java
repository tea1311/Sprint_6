package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensReturnsValueFromFelineTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", feline);
        int actualKittens = lion.getKittens();
        assertEquals(5, actualKittens);
    }

    @Test
    public void getFoodReturnsValueFromFelineTest() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(foodExpected);
        Lion lion = new Lion( "Самка", feline);
        List<String> actualFood = lion.getFood();
        assertEquals(foodExpected, actualFood);
    }


    @Test(expected =  Exception.class)
    public void shouldThrowExceptionsForInvalidSexTest() throws Exception {
        String invalidSex = "Киса";
        new Lion(invalidSex, feline);
    }

    @Test
    public void doesHaveManeShouldReturnTrueForMaleTest() throws Exception {
        Lion maleLion = new Lion("Самец", feline);
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
        public void doesHaveManeShouldReturnTrueForFemaleTest() throws Exception {
        Lion femaleLion = new Lion("Самка", feline);
        assertFalse(femaleLion.doesHaveMane());
    }
}






