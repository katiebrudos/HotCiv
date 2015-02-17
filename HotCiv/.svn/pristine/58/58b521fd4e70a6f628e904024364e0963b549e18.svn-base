package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;

public class UnitArcher extends UnitImpl {
	boolean fortified;
	boolean hasMoved;

	public UnitArcher(Player owner) {
		super(GameConstants.ARCHER, owner, 1, 3, 2);
		fortified = false;
		hasMoved = false;
	}
	
	@Override
	public void performAction() {
		if(fortified) {
			defortify();
		} else {
			fortify();
		}
	}
	
	private void fortify() {
		unitGeneric.moveCount = 0;
		unitGeneric.defense = unitGeneric.defense * 2;
		fortified = true;
	}
	
	private void defortify() {
		if(!hasMoved) {
			unitGeneric.moveCount = 1;
		}
		unitGeneric.defense = unitGeneric.defense / 2;
		fortified = false;
	}
	
	public void hasMoved() {
		super.hasMoved();
		hasMoved = true;
	}
	
	public void resetMoveCount() {
		super.resetMoveCount();
		hasMoved = false;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o.getClass() != UnitArcher.class) { return false; }
		return super.equals(o);
	}
}
