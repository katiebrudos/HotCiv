package hotciv.variant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

import hotciv.framework.GameConstants;
import hotciv.framework.ProductionStrategy;
import hotciv.framework.Tile;

public class ProductionStrategyEta implements ProductionStrategy {
	private HashMap<String,Integer> tileProdAmounts;
	private HashMap<String,Integer> tileFoodAmounts;
	
	public ProductionStrategyEta() {
		tileProdAmounts = new HashMap<String,Integer>();
		tileProdAmounts.put(GameConstants.MOUNTAINS, 1);
		tileProdAmounts.put(GameConstants.OCEANS, 0);
		tileProdAmounts.put(GameConstants.PLAINS, 0);
		tileProdAmounts.put(GameConstants.HILLS, 2);
		tileProdAmounts.put(GameConstants.FOREST, 3);
		
		tileFoodAmounts = new HashMap<String,Integer>();
		tileFoodAmounts.put(GameConstants.MOUNTAINS, 0);
		tileFoodAmounts.put(GameConstants.OCEANS, 1);
		tileFoodAmounts.put(GameConstants.PLAINS, 3);
		tileFoodAmounts.put(GameConstants.HILLS, 0);
		tileFoodAmounts.put(GameConstants.FOREST, 0);
	}
	
	@Override
	public int getProductionIncrease(int populationSize, ArrayList<Tile> surroundingTiles) {
		int productionCount = 1;
		Collections.sort(surroundingTiles, new MyProductionComparator(GameConstants.productionFocus));
		for(int i = 1; i < Math.min(populationSize,surroundingTiles.size()); i++) {
			//System.out.println(productionCount);
			productionCount += tileProdAmounts.get(surroundingTiles.get(i-1).getTypeString());
		}
		//System.out.println(productionCount);
		return productionCount;
	}
	
	@Override
	public int getFoodIncrease(int populationSize, ArrayList<Tile> surroundingTiles) {
		int foodCount = 1;
		Collections.sort(surroundingTiles, new MyProductionComparator(GameConstants.foodFocus));
			for(int i = 1; i < Math.min(populationSize,surroundingTiles.size()); i++) {
				foodCount += tileFoodAmounts.get(surroundingTiles.get(i-1).getTypeString());
			}
		return foodCount;
	}

	private class MyProductionComparator implements Comparator<Tile> {
		String productionFocus;
		
		public MyProductionComparator(String productionFocus) {
			this.productionFocus = productionFocus;
		}
		
		@Override
	    public int compare(Tile t1, Tile t2) {
	        if(productionFocus == GameConstants.productionFocus) {
	        	return tileProdAmounts.get(t2.getTypeString()) - tileProdAmounts.get(t1.getTypeString());
	        } else if(productionFocus == GameConstants.foodFocus) {
	        	return tileFoodAmounts.get(t2.getTypeString()) - tileFoodAmounts.get(t1.getTypeString());
	        } else {
	        	return 0;
	        }
	    }
	}
}
