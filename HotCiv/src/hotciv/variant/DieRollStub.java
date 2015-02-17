package hotciv.variant;

import hotciv.framework.DieRollStrategy;

public class DieRollStub implements DieRollStrategy {
	int dieNum; 
	
	public DieRollStub(int dieNum) {
		this.dieNum = dieNum; 
	}

	@Override
	public int rollDie() {
		return dieNum;
	}

}
