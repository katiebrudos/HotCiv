package hotciv.factory;

import hotciv.common.*;
import hotciv.framework.*;
import hotciv.variant.AttackStrategyEpsilon;
import hotciv.variant.RollSixSidedDieStrategy;
import hotciv.variant.WinnerStrategyEpsilon;

public class EpsilonFactory extends AlphaFactory {
	DieRollStrategy drs; 
	
	public EpsilonFactory() {
		this.drs = new RollSixSidedDieStrategy(); 
	}
	
	public EpsilonFactory(DieRollStrategy drs) {
		this.drs = drs; 
	}

	@Override
	public WinnerStrategy getWinnerStrategy() {
		return new WinnerStrategyEpsilon(); 
	}

	@Override
	public AttackStrategy getAttackStrategy() {
		return new AttackStrategyEpsilon(drs); 
	}
}
