package hotciv.standard.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hotciv.framework.*;
import hotciv.standard.*; 
import hotciv.variant.*;

import org.junit.Before;
import org.junit.Test;

public class TestEtaCivUnit {

	GrowthStrategy gs;
	Tile tile;
	City city;
	ProductionStrategyEta ps; 
	Game game; 
	
	ArrayList<Tile> surroundingTiles; 
	
	@Before
	public void setUp() throws Exception {
		surroundingTiles = new ArrayList<Tile>(); 
		gs = new GrowthStrategyEta();
		city = new CityImpl(Player.RED, 1, "", "");
		city.setSize(1);
		tile = new TileImpl(new Position(2,2), GameConstants.PLAINS);
		tile.addCity(city);		
		
		ps = new ProductionStrategyEta(); 
		
		surroundingTiles.add(new TileImpl(new Position(1,1), GameConstants.OCEANS)); 
		surroundingTiles.add(new TileImpl(new Position(1,2), GameConstants.OCEANS)); 
		surroundingTiles.add(new TileImpl(new Position(1,3), GameConstants.FOREST)); 
		surroundingTiles.add(new TileImpl(new Position(2,1), GameConstants.FOREST)); 
		// city is here // surroundingTiles.add(new TileImpl(new Position(2,2), GameConstants.PLAINS)); 
		surroundingTiles.add(new TileImpl(new Position(2,3), GameConstants.PLAINS)); 
		surroundingTiles.add(new TileImpl(new Position(3,1), GameConstants.MOUNTAINS)); 
		surroundingTiles.add(new TileImpl(new Position(3,2), GameConstants.HILLS)); 
		surroundingTiles.add(new TileImpl(new Position(3,3), GameConstants.HILLS)); 
	}
	
	@Test
	public void increaseOfOneProductionWithOnePopulation() {
		assertEquals(1, ps.getProductionIncrease(1, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfFourProductionWithTwoPopulation() {
		assertEquals(4, ps.getProductionIncrease(2, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfSevenProductionWithThreePopulation() {
		assertEquals(7, ps.getProductionIncrease(3, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfNineProductionWithFourPopulation() {
		assertEquals(9, ps.getProductionIncrease(4, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfTwelveProductionWithNinePopulation() {
		assertEquals(12, ps.getProductionIncrease(9, surroundingTiles));
	}

	@Test
	public void increaseOfOneFoodWithOnePopulation() {
		assertEquals(1, ps.getFoodIncrease(1, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfFourFoodWithTwoPopulation() {
		assertEquals(4, ps.getFoodIncrease(2, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfFiveFoodWithThreePopulation() {
		assertEquals(5, ps.getFoodIncrease(3, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfSixFoodWithFourPopulation() {
		assertEquals(6, ps.getFoodIncrease(4, surroundingTiles)); 
	}
	
	@Test
	public void increaseOfSixFoodWithNinePopulation() {
		assertEquals(6, ps.getFoodIncrease(9, surroundingTiles)); 
	}

	@Test
	public void testNotEnoughFoodToIncreasePop() {
		tile.getCity().addFood(2);
		gs.grow(tile.getCity());
		assertEquals(1, tile.getCity().getSize());
	}
	
	@Test
	public void testPopulationIncreaseTo2(){
		tile.getCity().addFood(8);
		tile.getCity().setSize(1);
		assertEquals(tile.getCity().getFood(), 8);
		gs.grow(tile.getCity());
		assertEquals(2, tile.getCity().getSize());
		assertEquals(0, tile.getCity().getFood());
		
	}
	@Test
	public void testPopulationIncreaseTo4(){
		tile.getCity().addFood(17);
		tile.getCity().setSize(4);
		assertEquals(tile.getCity().getFood(), 17);
		gs.grow(tile.getCity());
		assertEquals(5, tile.getCity().getSize());
		assertEquals(0, tile.getCity().getFood());
	}
	
	@Test
	public void testProductionGrowth1() {
		ArrayList<Tile> surroundingTiles = new ArrayList<Tile>();
		surroundingTiles.add(new TileImpl(new Position(0,0),GameConstants.PLAINS));
		surroundingTiles.add(new TileImpl(new Position(0,0),GameConstants.FOREST));
		surroundingTiles.add(new TileImpl(new Position(0,0),GameConstants.OCEANS));
		surroundingTiles.add(new TileImpl(new Position(0,0),GameConstants.MOUNTAINS));
		assertEquals(5, ps.getProductionIncrease(3, surroundingTiles));
	}
	
}
