package hotciv.factory;

import hotciv.framework.*; 
import hotciv.variant.GrowthStrategyEta;
import hotciv.variant.ProductionStrategyEta;
import hotciv.common.*; 

public class EtaFactory extends AlphaFactory {
	SetupStrategy setupStrategy; 
	
	public EtaFactory() {
		setupStrategy = new SetupStrategyAlpha();
	}
	
	public EtaFactory(SetupStrategy setupStrategy) {
		this.setupStrategy = setupStrategy; 
	}

	@Override
	public SetupStrategy getSetupStrategy() {
		return setupStrategy; 
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
