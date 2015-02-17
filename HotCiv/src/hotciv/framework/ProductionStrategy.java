package hotciv.framework;

import java.util.ArrayList;

public interface ProductionStrategy {
	public int getProductionIncrease(int populationSize, ArrayList<Tile> surroundingTiles);
	public int getFoodIncrease(int populationSize, ArrayList<Tile> surroundingTiles);
}
