package edu.towson.cis.cosc442.project4.coffeemaker; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.towson.cis.cosc442.project4.coffeemaker.CoffeeMaker;
import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

public class CoffeeMakerTest {

    
    @Test
    void testAddInventoryValid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        //Act and assert
        assertTrue(coffeeMaker.addInventory(1, 01, 1, 01));
        assertEquals(16, coffeeMaker.checkInventory().getChocolate());  
        assertEquals(16, coffeeMaker.checkInventory().getCoffee()); 
        assertEquals(16, coffeeMaker.checkInventory().getMilk()); 
        assertEquals(16, coffeeMaker.checkInventory().getSugar()); 

    }

    @ParameterizedTest 
    @CsvSource({
        "-1, 1, 1, 1",
        "1, -1, 1, 1",
        "1, 1, -1, 1",
        "1, 1, 1, -2"
    })
    void testAddInventoryInvalid(int coffee, int milk, int sugar, int chocolate) {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        //Act and assert
        assertFalse(coffeeMaker.addInventory(coffee, milk, sugar, chocolate));
    }

    @Test
    void testAddRecipeValid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        //act
        latte.setName("Latte");
        coffeeMaker.addRecipe(latte);
        //assert
        assertEquals("Latte", coffeeMaker.getRecipeForName("Latte").getName());
    }

    @Test
    void testAddRecipeInvalid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        Recipe latte3 = new Recipe();
        Recipe latte4 = new Recipe();
        Recipe latte5 = new Recipe();
        //act
        latte.setName("Latte");
        latte2.setName("Latte2");
        latte3.setName("Latte3");
        latte4.setName("Latte4");
        latte5.setName("Latte5");
        coffeeMaker.addRecipe(latte);
        coffeeMaker.addRecipe(latte2);
        coffeeMaker.addRecipe(latte3);
        coffeeMaker.addRecipe(latte4);
        //assert
        assertFalse(coffeeMaker.addRecipe(latte));
        assertFalse(coffeeMaker.addRecipe(latte5)); 

    }
   
    @Test
    void testCheckInventory() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        //Act
        coffeeMaker.addInventory(1, 01, 0, 01);
        //assert
        assertEquals(16, coffeeMaker.checkInventory().getCoffee());
        assertEquals(16, coffeeMaker.checkInventory().getMilk());
        assertEquals(15, coffeeMaker.checkInventory().getSugar());
        assertEquals(16, coffeeMaker.checkInventory().getChocolate());
    }

    @Test
    void testDeleteRecipeValid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        //act
        latte.setName("Latte");
        coffeeMaker.addRecipe(latte);
        //assert
        assertEquals("Latte", coffeeMaker.getRecipeForName("Latte").getName());
        assertTrue(coffeeMaker.deleteRecipe(latte));

    
    }

    @Test
    void testDeleteRecipeInvalid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        //act
        latte.setName("Latte");
        //assert
        assertFalse(coffeeMaker.deleteRecipe(latte));

    
    }

    @Test
    void testEditRecipeValid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        //act
        latte.setName("Latte");
        latte2.setName("Latte2"); 
        coffeeMaker.addRecipe(latte);
        coffeeMaker.addRecipe(latte2);
        //assert
        assertTrue(coffeeMaker.editRecipe(latte, latte2));

    }

    @Test
    void testEditRecipeInvalid() {
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        Recipe latte2 = new Recipe();
        Recipe latte3 = new Recipe(); 
        //act
        latte.setName("Latte");
        latte2.setName("Latte2"); 
        coffeeMaker.addRecipe(latte);
        //assert
        assertFalse(coffeeMaker.editRecipe(latte, latte3));

    }

    @Test
    void testmakeCoffeeValid(){
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setPrice(5);
        coffeeMaker.addRecipe(latte);

        //assert
        assertEquals(0, coffeeMaker.makeCoffee(latte, 5));  
    }

    @Test
    void testmakeCoffeeValid1(){
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();
        //act
        latte.setName("Latte");
        latte.setPrice(5);
        coffeeMaker.addRecipe(latte);
        latte.setAmtChocolate(8);
        latte.setAmtCoffee(2);
        latte.setAmtMilk(4);
        latte.setAmtSugar(6);
        int results = coffeeMaker.makeCoffee(latte, 10); 

        //assert
        assertEquals(5, results); 
        assertEquals(7, coffeeMaker.checkInventory().getChocolate());  
        assertEquals(13, coffeeMaker.checkInventory().getCoffee()); 
        assertEquals(11, coffeeMaker.checkInventory().getMilk()); 
        assertEquals(9, coffeeMaker.checkInventory().getSugar()); 
    }

    @Test
    void testmakeCoffeeInvalid1(){
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setPrice(5);
        latte.setAmtChocolate(20);
        latte.setAmtCoffee(20);
        latte.setAmtMilk(20);
        latte.setAmtSugar(20);
        coffeeMaker.addRecipe(latte);

        //assert
        assertEquals(5, coffeeMaker.makeCoffee(latte, 5));
    }

    @Test
    void testmakeCoffeeInvalid2(){
        //Arrange
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Recipe latte = new Recipe();

        //act
        latte.setName("Latte");
        latte.setPrice(5);
        coffeeMaker.addRecipe(latte);

        //assert
        assertEquals(4, coffeeMaker.makeCoffee(latte, 4));
    }
}
