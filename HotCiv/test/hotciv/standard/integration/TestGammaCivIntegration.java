package hotciv.standard.integration;


import static org.junit.Assert.*;
import hotciv.factory.GammaFactory;
import hotciv.framework.*;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitArcher;
import hotciv.standard.UnitLegion;
import hotciv.standard.UnitSettler;

import org.junit.Before;
import org.junit.Test;

public class TestGammaCivIntegration {
	Game game;

	@Before
	public void setUp() {
		game = new GameImpl(new GammaFactory()); 
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
	public void testArcherAction() {
		Position p = new Position(0,0);
		UnitArcher archer = new UnitArcher(Player.RED);
		game.setUnitAt(p, archer);
		assertEquals(3, archer.getDefensiveStrength());
		assertEquals(2, archer.getAttackingStrength());
		assertEquals(1, archer.getMoveCount());
		game.performUnitActionAt(p);
		assertEquals(6, archer.getDefensiveStrength());
		assertEquals(2, archer.getAttackingStrength());
		assertEquals(0, archer.getMoveCount());
		game.performUnitActionAt(p);
		assertEquals(3, archer.getDefensiveStrength());
		assertEquals(2, archer.getAttackingStrength());
		assertEquals(1, archer.getMoveCount());
		
		//now test that an archer cannot reset its move count by fortifying then defortifying after moving
		Position p2 = new Position(0,1);
		game.moveUnit(p, p2);
		assertEquals(0, archer.getMoveCount());
		game.performUnitActionAt(p2);
		game.performUnitActionAt(p2);
		assertEquals(0, archer.getMoveCount());
		
	}
}
