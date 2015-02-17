package hotciv.standard.unit;

import static org.junit.Assert.*;

import java.util.HashMap;

import hotciv.framework.AttackStrategy;
import hotciv.framework.Player;
import hotciv.framework.WinnerStrategy;
import hotciv.standard.UnitArcher;
import hotciv.standard.UnitLegion;
import hotciv.standard.UnitSettler;
import hotciv.variant.AttackStrategyEpsilon;
import hotciv.variant.DieRollStub;
import hotciv.variant.WinnerStrategyEpsilon;

import org.junit.Before;
import org.junit.Test;

public class TestEpsilonCivUnit {
	WinnerStrategy winnerStrategy;
	AttackStrategy attackStrategy;
	HashMap<Player, Integer> hm = new HashMap<Player, Integer>();

	@Before
	public void setUp() {
		winnerStrategy = new WinnerStrategyEpsilon();
		attackStrategy = new AttackStrategyEpsilon(new DieRollStub(1));
	}


	@Test
	public void testWinnerIsNull(){
		assertEquals(winnerStrategy.getWinner(0, null, hm, 0), null );
	}

	@Test
	public void testWinnerIsRed(){
		hm.put(Player.RED, 3);
		assertEquals(winnerStrategy.getWinner(0, null, hm, 0), Player.RED );
	}

	@Test
	public void testWinnerIsBlue(){	
		hm.put(Player.BLUE, 3);
		assertEquals(winnerStrategy.getWinner(0, null, hm, 0), Player.BLUE );
	}

	@Test
	public void testSoloArcherAttackSettlerWithNoModifiers() {
		assertFalse(attackStrategy.attack(new UnitArcher(Player.RED), new UnitSettler(Player.BLUE), 0, 1, 0, 1));
	}

	@Test
	public void testSoloLegionAttackSettlerWithNoModifiers() {
		assertTrue(attackStrategy.attack(new UnitLegion(Player.RED), new UnitSettler(Player.BLUE), 0, 1, 0, 1));
	}

	@Test
	public void testSoloArcherAttackLegionWithNoModifiers() {
		assertFalse(attackStrategy.attack(new UnitArcher(Player.RED), new UnitLegion(Player.BLUE), 0, 1, 0, 1));
	}

	@Test
	public void testSoloSettlerAttackLegionWithNoModifiers() {
		assertFalse(attackStrategy.attack(new UnitSettler(Player.RED), new UnitLegion(Player.BLUE), 0, 1, 0, 1));
	}

	@Test
	public void testSoloLegionAttackArcherWithNoModifiers() {
		assertTrue(attackStrategy.attack(new UnitLegion(Player.RED), new UnitArcher(Player.BLUE), 0, 1, 0, 1));
	}

	@Test
	public void testSoloSettlerAttackArcherWithNoModifiers() {
		assertFalse(attackStrategy.attack(new UnitSettler(Player.RED), new UnitArcher(Player.BLUE), 0, 1, 0, 1));		
	}

	@Test
	public void testSoloArcherOnForestAttackSettlerOnPlain() {
		assertTrue(attackStrategy.attack(new UnitArcher(Player.RED), new UnitSettler(Player.BLUE), 0, 2, 0, 1));
	}

	@Test
	public void testSoloArcherOnForestAttackSettlerOnPlainWithThreeAdjacentUnits() {
		assertFalse(attackStrategy.attack(new UnitArcher(Player.RED), new UnitSettler(Player.BLUE), 0, 2, 3, 1));
	}

	@Test
	public void testLegionOnPlainWithTwoAdjacentUnitsAttackSettlerOnPlainWithThreeAdjacentUnits() {
		assertFalse(attackStrategy.attack(new UnitLegion(Player.RED), new UnitSettler(Player.BLUE), 2, 1, 3, 1));
	}

	@Test
	public void testSettlerOnPlainWithThreeAdjacentUnitsAttackLegionOnPlainWithTwoAdjacentUnits() {
		assertFalse(attackStrategy.attack(new UnitSettler(Player.RED), new UnitLegion(Player.BLUE), 3, 1, 2, 1));
	}

	@Test
	public void testLegionOnPlainWithTwoAdjacentUnitsAttackArcherOnHillWithOneAdjacentUnit() {
		assertFalse(attackStrategy.attack(new UnitLegion(Player.RED), new UnitArcher(Player.BLUE), 2, 1, 1, 2));
	}

	@Test
	public void testLegionOnCityWithNoAdjacentUnitsAttackLegionOnPlainWithTwoAdjacentUnits() {
		assertTrue(attackStrategy.attack(new UnitLegion(Player.RED), new UnitArcher(Player.BLUE), 0, 3, 2, 1));
	}
}
