package edu.towson.cis.cosc442.project4.coffeemaker; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

public class RecipeTest {
    @Test
    void testEqualsValid() {
        //arrange
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        //act
        latte.setName("Latte");
        latte2.setName("Latte");
        //assert
        assertTrue(latte.equals(latte2));
    }

    @Test
    void testEqualsInvalid() {
        //arrange
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        //act
        latte.setName("Latte");
        latte2.setName("Latte2");
        //assert
        assertFalse(latte.equals(latte2));
    }

    @Test
    void testEqualsInvalid2() {
        //arrange
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        //act
        latte.setName("Latte");
        //assert
        assertFalse(latte.equals(latte2));
    }

    @ParameterizedTest 
    @CsvSource({
        "20, 20", "1, 1", "-1, 0"  
    })
    void testSetAmtChocolateValid(int amount, int expected) {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtChocolate(amount);
        //assert
        assertEquals(expected, latte.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffeeValid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtCoffee(20);
        //assert
        assertEquals(20, latte.getAmtCoffee());
    }

    @Test
    void testSetAmtCoffeeInvalid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtCoffee(-1);
        //assert
        assertEquals(0, latte.getAmtCoffee());
    }

    @Test
    void testSetAmtMilkValid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtMilk(20);
        //assert
        assertEquals(20, latte.getAmtMilk());
    }

    @Test
    void testSetAmtMilkInvalid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtMilk(-1);
        //assert
        assertEquals(0, latte.getAmtMilk());
    }

    @Test
    void testSetAmtSugarValid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtSugar(20);
        //assert
        assertEquals(20, latte.getAmtSugar());
    }

    @Test
    void testSetAmtSugarInvalid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setAmtSugar(-1);
        //assert
        assertEquals(0, latte.getAmtSugar());
    }

    @Test
    void testSetName() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setName("Latte");
        //assert
        assertEquals("Latte", latte.getName());
    }

    @Test
    void testSetPriceValid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setPrice(20);
        //assert
        assertEquals(20, latte.getPrice());
    }

    @Test
    void testSetPriceInvalid() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setPrice(-1);
        //assert
        assertEquals(0, latte.getPrice());
    }

    @Test
    void testToString() {
        //arrange
        Recipe latte = new Recipe();
        //act
        latte.setName("latte");
        String result = latte.toString(); 
        //assert
        assertEquals("latte", result);
    }
}
