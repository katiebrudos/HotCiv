package hotciv.standard.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.variant.WinnerStrategyZeta;

import org.junit.Before;
import org.junit.Test;

public class TestZetaCivUnit {
	WinnerStrategy winnerStrategy;
	
	@Before
	public void setUp() {
		winnerStrategy = new WinnerStrategyZeta();
	}
	
	@Test
	public void testWinnerFirst20Rounds() {
		ArrayList<Tile> cityTiles = new ArrayList<Tile>();
		assertNull(winnerStrategy.getWinner(0,cityTiles,null,0));
		Tile redCityTile = new TileImpl(new Position(0,0),"");
		redCityTile.addCity(new CityImpl(Player.RED, 1, "", ""));
		cityTiles.add(redCityTile);
		assertEquals(Player.RED, winnerStrategy.getWinner(0,cityTiles,null,0));
		Tile blueCityTile = new TileImpl(new Position(0,0),"");
		blueCityTile.addCity(new CityImpl(Player.BLUE, 1, "", ""));
		cityTiles.add(blueCityTile);
		assertNull(winnerStrategy.getWinner(0,cityTiles,null,0));
		redCityTile.getCity().changeOwner(Player.BLUE);;
		assertEquals(Player.BLUE, winnerStrategy.getWinner(0,cityTiles,null,0));
		assertEquals(Player.BLUE, winnerStrategy.getWinner(0,cityTiles,null,20));
		assertNull(winnerStrategy.getWinner(0,cityTiles,new HashMap<Player,Integer>(),21));
	}
	
	@Test
	public void testWinnerAfter20Rounds() {
		ArrayList<Tile> cityTiles = new ArrayList<Tile>();
		HashMap<Player,Integer> attackCounts = new HashMap<Player,Integer>();
		attackCounts.put(Player.RED, new Integer(2));
		attackCounts.put(Player.BLUE, new Integer(1));
		assertNull(winnerStrategy.getWinner(0,cityTiles,attackCounts,21));
		attackCounts.put(Player.BLUE, new Integer(3));
		assertEquals(Player.BLUE, winnerStrategy.getWinner(0,cityTiles,attackCounts,21));
		attackCounts.put(Player.BLUE, new Integer(7));
		assertEquals(Player.BLUE, winnerStrategy.getWinner(0,cityTiles,attackCounts,21));
	}
}
