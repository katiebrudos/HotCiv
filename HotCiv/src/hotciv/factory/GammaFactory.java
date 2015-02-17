package hotciv.factory;

import hotciv.common.*;
import hotciv.framework.*;
import hotciv.variant.ActionStrategyGamma;

public class GammaFactory extends AlphaFactory {
	@Override
	public ActionStrategy getActionStrategy() {
		return new ActionStrategyGamma();
	}
}
