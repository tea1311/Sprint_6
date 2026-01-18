package com.example;

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

    @Test
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodReturnCorrectFood() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertEquals(foodExpected, actualFood);
    }

    @Test
    public void shouldVerifyCallToEatMeatInGetFood() throws Exception {
        List<String> foodExpected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodExpected);
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void foodShouldExceptionIfPredatorExceptions() throws Exception {
        Mockito.when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));
        Cat cat = new Cat(feline);
        cat.getFood();
    }
}