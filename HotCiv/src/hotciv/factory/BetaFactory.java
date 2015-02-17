package hotciv.factory;

import hotciv.framework.AgeStrategy;
import hotciv.framework.WinnerStrategy;
import hotciv.variant.AgeStrategyBeta;
import hotciv.variant.WinnerStrategyBeta;

public class BetaFactory extends AlphaFactory {
	@Override
	public AgeStrategy getAgeStrategy() {
		return new AgeStrategyBeta();
	}

	@Override
	public WinnerStrategy getWinnerStrategy() {
		return new WinnerStrategyBeta();
	}
}
