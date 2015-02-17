package hotciv.variant;

import hotciv.framework.Player;
import hotciv.framework.Tile;
import hotciv.framework.WinnerStrategy;

import java.util.*;

public class WinnerStrategyBeta implements WinnerStrategy {
	/**
	 * returns true if all of the cities are owned by the same player, false otherwise
	 * @param age
	 * @param cityTiles
	 * @return
	 */
	public Player getWinner(int age, ArrayList<Tile> cityTiles, HashMap<Player, Integer> winHashMap, int roundNumber) {

		Player firstOwner = null;
		if(cityTiles.size() != 0) {
			firstOwner = cityTiles.get(0).getCity().getOwner();
		}
		
		for(Tile tile : cityTiles) {
			if(!firstOwner.equals(tile.getCity().getOwner())){  return null; }
			else{}
		}
		return firstOwner;
	}

	@Override
	public void countAttack(HashMap<Player, Integer> attackCounts, Player player) {
		// don't count
	}


}
