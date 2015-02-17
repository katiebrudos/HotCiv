package hotciv.factory;

import hotciv.framework.ActionStrategy;
import hotciv.framework.AgeStrategy;
import hotciv.framework.AttackStrategy;
import hotciv.framework.DieRollStrategy;
import hotciv.framework.GrowthStrategy;
import hotciv.framework.ProductionStrategy;
import hotciv.framework.SetupStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.variant.ActionStrategySemi;
import hotciv.variant.AgeStrategyBeta;
import hotciv.variant.AttackStrategyEpsilon;
import hotciv.variant.GrowthStrategyEta;
import hotciv.variant.ProductionStrategyEta;
import hotciv.variant.RollSixSidedDieStrategy;
import hotciv.variant.SetupStrategyDelta;
import hotciv.variant.WinnerStrategyEpsilon;

public class SemiFactory extends AlphaFactory {
	DieRollStrategy drs;
	
	public SemiFactory() {
		this.drs = new RollSixSidedDieStrategy(); 
	}
	
	public SemiFactory(DieRollStrategy drs) {
		this.drs = drs; 
	}

	@Override
	public ActionStrategy getActionStrategy() {
		return new ActionStrategySemi();
	}

	@Override
	public AgeStrategy getAgeStrategy() {
		return new AgeStrategyBeta();
	}

	@Override
	public SetupStrategy getSetupStrategy() {
		return new SetupStrategyDelta("deltaInput.txt");
	}

	@Override
	public WinnerStrategy getWinnerStrategy() {
		return new WinnerStrategyEpsilon();
	}

	@Override
	public AttackStrategy getAttackStrategy() {
		return new AttackStrategyEpsilon(drs);
	}

	@Override
	public GrowthStrategy getGrowthStrategy() {
		return new GrowthStrategyEta();
	}

	@Override
	public ProductionStrategy getProductionStrategy() {
		return new ProductionStrategyEta();
	}
}
