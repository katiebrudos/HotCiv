package hotciv.framework;

public interface ActionStrategy {
	public void performUnitActionAt(Tile[][] gameboard, Position p);
}
