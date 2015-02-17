package hotciv.variant;

import hotciv.framework.ActionStrategy;
import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;
import hotciv.standard.CityImpl;

public class ActionStrategySemi implements ActionStrategy {

	@Override
	public void performUnitActionAt(Tile[][] gameBoard, Position p) {
		int row = p.getRow();
		int column = p.getColumn();
		Unit unit = gameBoard[row][column].getUnit();
		if(unit.getTypeString().equals(GameConstants.ARCHER)) {
			// do nothing
		} else if(unit.getTypeString().equals(GameConstants.SETTLER)) {
			Tile tile = gameBoard[row][column];
			tile.addCity(new CityImpl(unit.getOwner(),1,GameConstants.ARCHER,GameConstants.productionFocus));
			tile.setUnit(null);
		} else if(unit.getTypeString().equals(GameConstants.LEGION)) {
			// do nothing
		}
	}

}
