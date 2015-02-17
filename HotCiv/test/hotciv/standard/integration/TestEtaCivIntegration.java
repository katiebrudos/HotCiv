package hotciv.standard.integration;

import static org.junit.Assert.*;
import hotciv.factory.EtaFactory;
import hotciv.framework.*;
import hotciv.standard.*;
import hotciv.variant.*;

import org.junit.Before;
import org.junit.Test;

public class TestEtaCivIntegration {
	Game game; 
	City city; 
	Position p = new Position(2,2);
	
	@Before
	public void setUp() throws Exception {
		game = new GameImpl(new EtaFactory(new SetupStrategyEtaStub()));
	}
	
	private void setUpProductionFocus(int population) {
		city = new CityImpl(Player.RED, population, GameConstants.LEGION, GameConstants.productionFocus); 
		game.setCityAt(p, city);
	}
	
	private void setUpFoodFocus(int population) {
		city = new CityImpl(Player.RED, population, GameConstants.LEGION, GameConstants.foodFocus); 
		game.setCityAt(p, city);
	}
	
	@Test
	public void testOneProductionAddedWithOnePopulation() {
		setUpProductionFocus(1);
		game.endOfRound();
		assertEquals(1, city.getProductionAmount()); 
	}
	
	@Test
	public void testFourProductionAddedWithTwoPopulation() {
		setUpProductionFocus(2);
		game.endOfRound();
		assertEquals(4, city.getProductionAmount()); 
	}
	
	@Test
	public void testSixProductionAddedWithThreePopulation() {
		setUpProductionFocus(3); 
		game.endOfRound();
		assertEquals(6, city.getProductionAmount()); 
	}
	
	@Test
	public void testPopulationIncreaseTo2(){
		setUpFoodFocus(1);
		city.addFood(8);
		assertEquals(city.getFood(), 8);
		game.endOfRound();
		assertEquals(2, city.getSize());
		assertEquals(0, city.getFood());
		
	}
	@Test
	public void testPopulationIncreaseTo4(){
		setUpFoodFocus(3);
		city.addFood(19);
		assertEquals(city.getFood(), 19);
		game.endOfRound();
		assertEquals(4, city.getSize());
		assertEquals(0, city.getFood());
	}
	
	@Test
	public void testOneFoodAddedWithOnePopulation() {
		setUpFoodFocus(1);
		game.endOfRound();
		assertEquals(1, city.getFood()); 
	}
	
	@Test
	public void testFourFoodAddedWithTwoPopulation() {
		setUpFoodFocus(2);
		game.endOfRound();
		assertEquals(4, city.getFood()); 
	}
	
	@Test
	public void testFiveFoodAddedWithThreePopulation() {
		setUpFoodFocus(3);
		game.endOfRound();
		assertEquals(5, city.getFood()); 
	}
}
