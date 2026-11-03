import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.towson.cis.cosc442.project4.coffeemaker.Inventory;
import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

public class InventoryTest {
    @Test
    void testEnoughIngredientsValid() {
        //arrange
        Inventory inventory = new Inventory();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setPrice(5);
        //
        assertTrue(inventory.enoughIngredients(latte));
    }

    @ParameterizedTest 
    @CsvSource({
        "20, 15, 15, 15",
        "15, 20, 15, 15",
        "15, 15, 20, 15",
        "15, 15, 15, 20"
    })
    void testEnoughIngredientsInvalid(int coffee, int milk, int sugar, int chocolate) {
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
        assertFalse(inventory.enoughIngredients(latte));
    }


    @Test
    void testSetChocolateValid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setChocolate(20);
        //assert
        assertEquals(20, inventory.getChocolate());
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

    @Test
    void testSetCoffeeValid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setCoffee(20);
        //assert
        assertEquals(20, inventory.getCoffee());

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

    @Test
    void testSetMilkValid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setMilk(20);
        //assert
        assertEquals(20, inventory.getMilk());
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

    @Test
    void testSetSugarValid() {
        //arrange
        Inventory inventory = new Inventory();
        //act
        inventory.setSugar(20);
        //assert
        assertEquals(20, inventory.getSugar());
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
}
