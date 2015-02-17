package hotciv.standard.integration;

import static org.junit.Assert.*;
import hotciv.factory.SemiFactory;
import hotciv.framework.City;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Unit;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitArcher;
import hotciv.standard.UnitLegion;
import hotciv.standard.UnitSettler;
import hotciv.variant.DieRollStub;

import org.junit.Before;
import org.junit.Test;

public class TestSemiCivIntegration {
	Game game;
	City city; 
	Position p = new Position(2,2);

	@Before
	public void setUp() {
		game = new GameImpl(new SemiFactory(new DieRollStub(1))); 
	}
	
	@Test
	public void testLegionActionDoesNothing() {
		Position p = new Position(1,1);
		Unit legion = new UnitLegion(Player.RED);
		game.setUnitAt(p, legion);
		assertEquals(2, legion.getDefensiveStrength());
		assertEquals(4, legion.getAttackingStrength());
		assertEquals(1, legion.getMoveCount());
		game.performUnitActionAt(p);
		assertEquals(legion, game.getUnitAt(p));
		assertEquals(2, legion.getDefensiveStrength());
		assertEquals(4, legion.getAttackingStrength());
		assertEquals(1, legion.getMoveCount());
	}
	
	@Test
	public void testSettlerAction() {
		Position p = new Position(0,0);
		game.setCityAt(p, null);
		game.setUnitAt(p, new UnitSettler(Player.RED));
		assertNull(game.getCityAt(p));
		game.performUnitActionAt(p);
		assertEquals(new CityImpl(Player.RED, 1, GameConstants.ARCHER, GameConstants.productionFocus),game.getCityAt(p));
		assertNull(game.getUnitAt(p));
	}
	
	@Test
	public void testArcherActionDoesNothing() {
		Position p = new Position(0,0);
		UnitArcher archer = new UnitArcher(Player.RED);
		game.setUnitAt(p, archer);
		assertEquals(3, archer.getDefensiveStrength());
		assertEquals(2, archer.getAttackingStrength());
		assertEquals(1, archer.getMoveCount());
		game.performUnitActionAt(p);
		assertEquals(3, archer.getDefensiveStrength());
		assertEquals(2, archer.getAttackingStrength());
		assertEquals(1, archer.getMoveCount());
	}
	
	@Test
	public void testAgeGrowth4000BCto100BC() {
		game.setAge(-4000);
		assertEquals(-4000,game.getAge());
		game.endOfRound();
		assertEquals(-3900,game.getAge());
		game.setAge(-200);
		assertEquals(-200,game.getAge());
		game.endOfRound();
		assertEquals(-100,game.getAge());
	}
	
	@Test
	public void testAgeGrowth100BCto50AD() {	
		game.setAge(-100);
		assertEquals(-100,game.getAge());
		game.endOfRound();
		assertEquals(-1,game.getAge());
		game.endOfRound();
		assertEquals(1,game.getAge());
		game.endOfRound();
		assertEquals(50,game.getAge());
	}
	
	@Test
	public void testAgeGrowth50ADto1750AD() {
		game.setAge(50);
		assertEquals(50,game.getAge());
		game.endOfRound();
		assertEquals(100,game.getAge());
		game.setAge(1700);
		assertEquals(1700,game.getAge());
		game.endOfRound();
		assertEquals(1750,game.getAge());
	}
	
	@Test
	public void testAgeGrowth1750ADto1900AD() {
		game.setAge(1750);
		assertEquals(1750,game.getAge());
		game.endOfRound();
		assertEquals(1775,game.getAge());
		game.setAge(1875);
		assertEquals(1875,game.getAge());
		game.endOfRound();
		assertEquals(1900,game.getAge());
	}
		
	@Test
	public void testAgeGrowth1900ADto1970AD() {
		game.setAge(1900);
		assertEquals(1900,game.getAge());
		game.endOfRound();
		assertEquals(1905,game.getAge());
		game.setAge(1965);
		assertEquals(1965,game.getAge());
		game.endOfRound();
		assertEquals(1970,game.getAge());
	}
	
	@Test
	public void testAgeGrowth1970ADtoInfinityAndBeyond() {
		game.setAge(1970);
		assertEquals(1970,game.getAge());
		game.endOfRound();
		assertEquals(1971,game.getAge());
		game.setAge(2012);
		assertEquals(2012,game.getAge());
		game.endOfRound();
		assertEquals("Looks like the Mayans were right, 2012 is the end!",2013,game.getAge());
	}
	
	@Test 
	public void testMountains() {
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(0,5)).getTypeString());
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(3,3)).getTypeString());
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(7,13)).getTypeString());
		assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(11,5)).getTypeString());
	}
	
	@Test
	public void testOceans() {
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(0,0)).getTypeString());
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(0,11)).getTypeString());
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(6,0)).getTypeString());
		assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(14,13)).getTypeString());
	}
	
	@Test 
	public void testForests() {
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(1,9)).getTypeString());
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(5,2)).getTypeString());
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(9,11)).getTypeString());
		assertEquals(GameConstants.FOREST, game.getTileAt(new Position(12,9)).getTypeString());
	}   
	
	@Test 
	public void testPlains() {
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(0,3)).getTypeString());
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(3,6)).getTypeString());
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(8,7)).getTypeString());
		assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(13,12)).getTypeString());
	}
	
	@Test 
	public void testHills() {
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1,3)).getTypeString());
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(4,9)).getTypeString());
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(7,10)).getTypeString());
		assertEquals(GameConstants.HILLS, game.getTileAt(new Position(14,6)).getTypeString());
	}
	
	@Test
	public void testSetup() {
		assertEquals(Player.RED, game.getCityAt(new Position(8,12)).getOwner());
		assertEquals(Player.BLUE, game.getCityAt(new Position(4,5)).getOwner());
		Unit unit = game.getUnitAt(new Position(3,8));
		assertEquals(Player.RED, unit.getOwner());
		assertEquals(GameConstants.ARCHER, unit.getTypeString());
		unit = game.getUnitAt(new Position(4,4));
		assertEquals(Player.BLUE, unit.getOwner());
		assertEquals(GameConstants.LEGION, unit.getTypeString());
		unit = game.getUnitAt(new Position(5,5));
		assertEquals(Player.BLUE, unit.getOwner());
		assertEquals(GameConstants.SETTLER, unit.getTypeString());
	}
	
	@Test
	public void testWinner() {
		game.setUnitAt(new Position(0,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,3), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,6), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(1,0), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(1,3), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(1,6), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(0,0), new Position(1,0));
		game.moveUnit(new Position(0,3), new Position(1,3));
		game.moveUnit(new Position(0,6), new Position(1,6));
		assertNull(game.getWinner());
		game.setUnitAt(new Position(3,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(6,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(3,6), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(5,5), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(3,5), new Position(3,6));
		game.moveUnit(new Position(6,5), new Position(5,5));
		assertEquals(Player.RED, game.getWinner());
	}
	
	@Test
	public void testWinnerIsNull(){
		assertNull(game.getWinner());
	}
	
	@Test
	public void testArcherOnPlainsAttackSettlerOnHills() {
		game.setUnitAt(new Position(3,0), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(3,1), new UnitSettler(Player.BLUE));	
		
		game.moveUnit(new Position(3,0), new Position(3,1));
		assertNull(game.getUnitAt(new Position(3,0))); 
		assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(3,1)).getTypeString()); 
	}
	
	@Test
	public void testArcherOnHillsAttackSettlerOnPlains() {
		game.setUnitAt(new Position(1,3), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(0,3), new UnitSettler(Player.BLUE));	
		
		game.moveUnit(new Position(1,3), new Position(0,3));
		assertNull(game.getUnitAt(new Position(1,3))); 
		assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(0,3)).getTypeString()); 
	}	
	
	@Test
	public void testLegionOnHillsAttackArcherOnPlains() {
		game.setUnitAt(new Position(1,3), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,3), new UnitArcher(Player.BLUE));
		
		game.moveUnit(new Position(1,3), new Position(0,3)); 
		assertNull(game.getUnitAt(new Position(0,1))); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(0,3)).getTypeString()); 

	}
	
	@Test
	public void testArcherOnHillsAttackSettlerOnPlainsWithOneAdjacentUnit() {
		game.setUnitAt(new Position(1,3), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(0,3), new UnitSettler(Player.BLUE));	
		game.setUnitAt(new Position(0,4) , new UnitLegion(Player.BLUE));
		
		game.moveUnit(new Position(1,3), new Position(0,3));
		assertNull(game.getUnitAt(new Position(1,3))); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(0,4)).getTypeString()); 
		assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(0,3)).getTypeString()); 
	}	
	
	public void testLegionOnHillsAttackSettlerOnPlainsWithOneAdjacentUnit() {
		game.setUnitAt(new Position(3,1), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(3,0), new UnitSettler(Player.BLUE));	
		game.setUnitAt(new Position(4,0) , new UnitArcher(Player.BLUE));
		
		game.moveUnit(new Position(3,1), new Position(3,0));
		assertNull(game.getUnitAt(new Position(3,1))); 
		assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(4,0)).getTypeString()); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(3,0)).getTypeString()); 
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
	public void testThreeProductionAddedWithTwoPopulationOneHills() {
		setUpProductionFocus(2);
		game.endOfRound();
		assertEquals(3, city.getProductionAmount()); 
	}
	
	@Test
	public void testFourProductionAddedWithThreePopulationOneHillOneMountain() {
		setUpProductionFocus(3); 
		game.endOfRound();
		assertEquals(4, city.getProductionAmount());
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
	public void testSevenFoodAddedWithThreePopulationThreeOceans() {
		setUpFoodFocus(3);
		game.endOfRound();
		assertEquals(7, city.getFood()); 
	}
}
