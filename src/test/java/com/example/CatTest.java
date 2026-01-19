package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }
    @Test
    public void getSoundShouldReturnMeowTest() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodReturnCorrectFoodTest() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);
        List<String> actualFood = cat.getFood();
        assertEquals(foodExpected, actualFood);
    }

    @Test
    public void shouldVerifyCallToEatMeatInGetFoodTest() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void foodShouldExceptionIfPredatorExceptionsTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));
        cat.getFood();
    }
}