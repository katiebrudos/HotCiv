package hotciv.standard.unit;

import static org.junit.Assert.*;
import hotciv.framework.*;
import hotciv.variant.SetupStrategyDelta;

import org.junit.Before;
import org.junit.Test;

public class TestDeltaCivUnit {
	SetupStrategy setupStrategy;
	
	@Before
	public void setUp() {
		setupStrategy = new SetupStrategyDelta("deltaInput.txt");
	}
	
	@Test 
	public void testMountains() {
		assertEquals(GameConstants.MOUNTAINS, setupStrategy.setupGameboard()[0][5].getTypeString());
		assertEquals(GameConstants.MOUNTAINS, setupStrategy.setupGameboard()[3][3].getTypeString());
		assertEquals(GameConstants.MOUNTAINS, setupStrategy.setupGameboard()[7][13].getTypeString());
		assertEquals(GameConstants.MOUNTAINS, setupStrategy.setupGameboard()[11][5].getTypeString());
	}
	
	@Test
	public void testOceans() {
		assertEquals(GameConstants.OCEANS, setupStrategy.setupGameboard()[0][0].getTypeString());
		assertEquals(GameConstants.OCEANS, setupStrategy.setupGameboard()[0][11].getTypeString());
		assertEquals(GameConstants.OCEANS, setupStrategy.setupGameboard()[6][0].getTypeString());
		assertEquals(GameConstants.OCEANS, setupStrategy.setupGameboard()[14][13].getTypeString());
	}
	
	@Test 
	public void testForests() {
		assertEquals(GameConstants.FOREST, setupStrategy.setupGameboard()[1][9].getTypeString());
		assertEquals(GameConstants.FOREST, setupStrategy.setupGameboard()[5][2].getTypeString());
		assertEquals(GameConstants.FOREST, setupStrategy.setupGameboard()[9][11].getTypeString());
		assertEquals(GameConstants.FOREST, setupStrategy.setupGameboard()[12][9].getTypeString());
	}   
	
	@Test 
	public void testPlains() {
		assertEquals(GameConstants.PLAINS, setupStrategy.setupGameboard()[0][3].getTypeString());
		assertEquals(GameConstants.PLAINS, setupStrategy.setupGameboard()[3][6].getTypeString());
		assertEquals(GameConstants.PLAINS, setupStrategy.setupGameboard()[8][7].getTypeString());
		assertEquals(GameConstants.PLAINS, setupStrategy.setupGameboard()[13][12].getTypeString());
	}
	
	@Test 
	public void testHills() {
		assertEquals(GameConstants.HILLS, setupStrategy.setupGameboard()[1][3].getTypeString());
		assertEquals(GameConstants.HILLS, setupStrategy.setupGameboard()[4][9].getTypeString());
		assertEquals(GameConstants.HILLS, setupStrategy.setupGameboard()[7][10].getTypeString());
		assertEquals(GameConstants.HILLS, setupStrategy.setupGameboard()[14][6].getTypeString());
	}
	
	@Test
	public void testSetup() {
		assertEquals(Player.RED, setupStrategy.setupGameboard()[8][12].getCity().getOwner());
		assertEquals(Player.BLUE, setupStrategy.setupGameboard()[4][5].getCity().getOwner());
		Unit unit = setupStrategy.setupGameboard()[3][8].getUnit();
		assertEquals(Player.RED, unit.getOwner());
		assertEquals(GameConstants.ARCHER, unit.getTypeString());
		unit = setupStrategy.setupGameboard()[4][4].getUnit();
		assertEquals(Player.BLUE, unit.getOwner());
		assertEquals(GameConstants.LEGION, unit.getTypeString());
		unit = setupStrategy.setupGameboard()[5][5].getUnit();
		assertEquals(Player.BLUE, unit.getOwner());
		assertEquals(GameConstants.SETTLER, unit.getTypeString());
	}
}
