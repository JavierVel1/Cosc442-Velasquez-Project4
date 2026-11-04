package edu.towson.cis.cosc442.project4.coffeemaker; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryTest {
    @ParameterizedTest 
    @CsvSource({
        "15, 10, 7, 1",
        "3, 15, 4, 11",
        "1, 12, 15, 9",
        "12, 6, 5, 15"
    })
    void testEnoughIngredientsValid(int coffee, int milk, int sugar, int chocolate) {
        //arrange
        Inventory inventory = new Inventory();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setPrice(5);
        latte.setAmtChocolate(chocolate); 
        latte.setAmtCoffee(coffee);
        latte.setAmtMilk(milk);
        latte.setAmtSugar(sugar);
        //
        assertTrue(inventory.enoughIngredients(latte));
    }

    @ParameterizedTest 
    @CsvSource({
        "20, 10, 7, 1",
        "3, 20, 4, 11",
        "1, 12, 20, 9",
        "12, 6, 5, 20"
    })
    void testEnoughIngredientsInvalid(int coffee, int milk, int sugar, int chocolate) {
        //arrange
        Inventory inventory = new Inventory();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setAmtChocolate(chocolate); 
        latte.setAmtCoffee(coffee);
        latte.setAmtMilk(milk);
        latte.setAmtSugar(sugar);
        //
        assertFalse(inventory.enoughIngredients(latte));
    }


    @ParameterizedTest 
    @CsvSource({
        "0, 0", "20, 20", "1, 1"
    })
    void testSetChocolateValid(int amount, int expected) {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setChocolate(amount);
        //assert
        assertEquals(expected, inventory.getChocolate());
    }

    @Test
    void testSetChocolateInvalid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setChocolate(-1);
        //assert
        assertEquals(0, inventory.getChocolate());
    }

    @ParameterizedTest 
    @CsvSource({
        "0, 0", "20, 20", "1, 1"
    })
    void testSetCoffeeValid(int amount, int expected) {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setCoffee(amount);
        //assert
        assertEquals(expected, inventory.getCoffee());

    }

    @Test
    void testSetCoffeeInvalid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setCoffee(-1);
        //assert
        assertEquals(0, inventory.getCoffee());

    }

    @ParameterizedTest 
    @CsvSource({
        "0, 0", "20, 20", "1, 1"
    })
    void testSetMilkValid(int amount, int expected) {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setMilk(amount);
        //assert
        assertEquals(expected, inventory.getMilk());
    }

    @Test
    void testSetMilkInvalid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setMilk(-1);
        //assert
        assertEquals(0, inventory.getMilk());
    }

    @ParameterizedTest 
    @CsvSource({
        "0, 0", "20, 20", "1, 1"
    })
    void testSetSugarValid(int amount, int expected) {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setSugar(amount);
        //assert
        assertEquals(expected, inventory.getSugar());
    }

    @Test
    void testSetSugarInvalid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setSugar(-1);
        //assert
        assertEquals(0, inventory.getSugar());
    }

    @Test
    void testToString() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        String result = inventory.toString();
        //assert
        assertEquals("Coffee: " + inventory.getCoffee() + "\n" +
                "Milk: " + inventory.getMilk() + "\n" +
                "Sugar: " + inventory.getSugar() + "\n" +
                "Chocolate: " + inventory.getChocolate() + "\n", result);
    }
}
