package hotciv.common;

import java.util.ArrayList;
import java.util.HashMap;

import hotciv.framework.Player;
import hotciv.framework.Tile;
import hotciv.framework.WinnerStrategy;

public class WinnerStrategyAlpha implements WinnerStrategy {

	@Override	
	public Player getWinner(int age, ArrayList<Tile> cityTiles, HashMap<Player, Integer> winHashMap, int roundNumber) {
		if(age == -3000) {
			return Player.RED;
		} else {
			return null; 
		}
	}

	@Override
	public void countAttack(HashMap<Player, Integer> attackCounts, Player player) {
		// don't count
	}

}
