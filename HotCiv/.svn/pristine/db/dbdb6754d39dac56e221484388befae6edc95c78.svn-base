package hotciv.standard.integration;

import static org.junit.Assert.*;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitArcher;
import hotciv.standard.UnitLegion;
import hotciv.standard.UnitSettler;
import hotciv.variant.*;
import hotciv.factory.EpsilonFactory;
import hotciv.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestEpsilonIntegration {
	Game game;
	
	@Before
	public void setUp(){
		game = new GameImpl(new EpsilonFactory(new DieRollStub(1)));
		
	}
	
	@Test
	public void testWinner() {
		game.setUnitAt(new Position(0,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(3,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(6,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,1), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(3,1), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(6,1), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(0,0), new Position(0,1));
		game.moveUnit(new Position(3,0), new Position(3,1));
		game.moveUnit(new Position(6,0), new Position(6,1));
		assertNull(game.getWinner());
		game.setUnitAt(new Position(3,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(6,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,6), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(3,6), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(3,5), new Position(3,6));
		game.moveUnit(new Position(6,5), new Position(6,6));
		assertEquals(Player.RED, game.getWinner());
	}
	
	@Test
	public void testWinnerIsNull(){
		assertNull(game.getWinner());
	}
	
	@Test
	public void testArcherOnPlainsAttackSettlerOnHills() {
		game.setUnitAt(new Position(0,0), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(0,1), new UnitSettler(Player.BLUE));	
		
		game.moveUnit(new Position(0,0), new Position(0,1));
		assertNull(game.getUnitAt(new Position(0,0))); 
		assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(0,1)).getTypeString()); 
	}
	
	@Test
	public void testArcherOnHillsAttackSettlerOnPlains() {
		game.setUnitAt(new Position(0,1), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(0,0), new UnitSettler(Player.BLUE));	
		
		game.moveUnit(new Position(0,1), new Position(0,0));
		assertNull(game.getUnitAt(new Position(0,1))); 
		assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(0,0)).getTypeString()); 
	}	
	
	@Test
	public void testLegionOnHillsAttackArcherOnPlains() {
		game.setUnitAt(new Position(0,1), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,0), new UnitArcher(Player.BLUE));
		
		game.moveUnit(new Position(0,1), new Position(0,0)); 
		assertNull(game.getUnitAt(new Position(0,1))); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(0,0)).getTypeString()); 

	}
	
	@Test
	public void testArcherOnHillsAttackSettlerOnPlainsWithOneAdjacentUnit() {
		game.setUnitAt(new Position(0,1), new UnitArcher(Player.RED));
		game.setUnitAt(new Position(0,0), new UnitSettler(Player.BLUE));	
		game.setUnitAt(new Position(1,1) , new UnitLegion(Player.BLUE));
		
		game.moveUnit(new Position(0,1), new Position(0,0));
		assertNull(game.getUnitAt(new Position(0,1))); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(1,1)).getTypeString()); 
		assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(0,0)).getTypeString()); 
	}	
	
	public void testLegionOnHillsAttackSettlerOnPlainsWithOneAdjacentUnit() {
		game.setUnitAt(new Position(0,1), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,0), new UnitSettler(Player.BLUE));	
		game.setUnitAt(new Position(1,1) , new UnitArcher(Player.BLUE));
		
		game.moveUnit(new Position(0,1), new Position(0,0));
		assertNull(game.getUnitAt(new Position(0,1))); 
		assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(1,1)).getTypeString()); 
		assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(0,0)).getTypeString()); 
	}	
}
