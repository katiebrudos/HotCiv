package hotciv.variant;

import hotciv.framework.*;
import hotciv.standard.CityImpl;

public class ActionStrategyGamma implements ActionStrategy {

	@Override
	public void performUnitActionAt(Tile[][] gameBoard, Position p) {
		int row = p.getRow();
		int column = p.getColumn();
		Unit unit = gameBoard[row][column].getUnit();
		if(unit.getTypeString().equals(GameConstants.SETTLER)) {
			Tile tile = gameBoard[row][column];
			tile.addCity(new CityImpl(unit.getOwner(),1,GameConstants.ARCHER,GameConstants.productionFocus));
			tile.setUnit(null);
		} else {
			unit.performAction();
		}
	}
}
