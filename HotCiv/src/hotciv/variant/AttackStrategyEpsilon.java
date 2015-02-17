package hotciv.variant;

import hotciv.framework.AttackStrategy;
import hotciv.framework.DieRollStrategy;
import hotciv.framework.Unit;

public class AttackStrategyEpsilon implements AttackStrategy {
	DieRollStrategy drs; 
	
	public AttackStrategyEpsilon(DieRollStrategy drs) {
		this.drs = drs; 
	}
	
	int attack, defense, attackRoll, defendRoll; 

	@Override
	public boolean attack(Unit attacker, Unit defender, int attackerAdjacentUnits, int attackerTerrainFactor,
			int defenderAdjacentUnits, int defenderTerrainFactor) {
		attackRoll = drs.rollDie(); 
		defendRoll = drs.rollDie(); 
		
		attack = ((attacker.getAttackingStrength() + attackerAdjacentUnits) * attackerTerrainFactor) * attackRoll; 
		defense = ((defender.getDefensiveStrength() + defenderAdjacentUnits) * defenderTerrainFactor) * defendRoll; 
		
		if(attack > defense) return true; 
		else return false; 
	}
}