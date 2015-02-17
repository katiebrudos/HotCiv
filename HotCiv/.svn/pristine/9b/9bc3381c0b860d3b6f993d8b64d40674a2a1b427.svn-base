package hotciv.variant;

import java.util.ArrayList;
import java.util.HashMap;
import hotciv.framework.Player;
import hotciv.framework.Tile;
import hotciv.framework.WinnerStrategy;

public class WinnerStrategyZeta implements WinnerStrategy {
	WinnerStrategy currentWinnerStrategy;
	
	public WinnerStrategyZeta() {
		currentWinnerStrategy = new WinnerStrategyBeta();
	}
	
	@Override
	public Player getWinner(int age, ArrayList<Tile> cityTiles, HashMap<Player, Integer> winHashMap, int roundNumber) {
		if(roundNumber == 21) {
			currentWinnerStrategy = new WinnerStrategyEpsilon();
		}
		return currentWinnerStrategy.getWinner(age, cityTiles, winHashMap, roundNumber);
	}

	@Override
	public void countAttack(HashMap<Player, Integer> attackCounts, Player player) {
		currentWinnerStrategy.countAttack(attackCounts, player);
	}
}
