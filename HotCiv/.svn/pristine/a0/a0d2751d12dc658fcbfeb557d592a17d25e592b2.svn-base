package hotciv.standard.integration;

import static org.junit.Assert.*;
import hotciv.factory.ZetaFactory;
import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitLegion;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCivIntegration {
	Game game;

	@Before
	public void setUp() {
		game = new GameImpl(new ZetaFactory());
	}
	
	@Test
	public void testWinnerFirst20Rounds() {
		assertNull(game.getWinner());
		game.setCityAt(new Position(0,0), new CityImpl(Player.RED, 1, GameConstants.ARCHER, GameConstants.foodFocus));
		assertEquals(Player.RED, game.getWinner());
		game.setCityAt(new Position(1,1), new CityImpl(Player.BLUE, 1, GameConstants.ARCHER, GameConstants.foodFocus));
		assertNull(game.getWinner());
		game.setCityAt(new Position(0,0), new CityImpl(Player.BLUE, 1, GameConstants.ARCHER, GameConstants.foodFocus));
		assertEquals(Player.BLUE, game.getWinner());
		// advance round to 20
		for(int i = 1; i < 20; i++) {
			game.endOfRound();
		}
		assertEquals(Player.BLUE, game.getWinner());
		game.endOfRound(); // round is 21
		assertNull(game.getWinner());
	}
	
	@Test
	public void testWinnerAfter20Rounds() {
		// advance round to 21
		for(int i = 1; i < 21; i++) {
			game.endOfRound();
		}
		assertNull(game.getWinner());
		// get 3 attack wins for Red
		game.setUnitAt(new Position(0,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(3,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(6,0), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,1), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(3,1), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(6,1), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(0,0), new Position(0,1));
		game.moveUnit(new Position(3,0), new Position(3,1));
		game.moveUnit(new Position(6,0), new Position(6,1));
		assertEquals(Player.RED, game.getWinner());
		game.setUnitAt(new Position(3,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(6,5), new UnitLegion(Player.RED));
		game.setUnitAt(new Position(0,6), new UnitLegion(Player.BLUE));
		game.setUnitAt(new Position(3,6), new UnitLegion(Player.BLUE));
		game.moveUnit(new Position(3,5), new Position(3,6));
		game.moveUnit(new Position(6,5), new Position(6,6));
		assertEquals(Player.RED, game.getWinner());
	}

}
