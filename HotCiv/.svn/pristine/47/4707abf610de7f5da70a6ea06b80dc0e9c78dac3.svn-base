package hotciv.common;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.SetupStrategy;
import hotciv.framework.Tile;
import hotciv.standard.CityImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitArcher;
import hotciv.standard.UnitLegion;
import hotciv.standard.UnitSettler;

public class SetupStrategyAlpha implements SetupStrategy {
	Tile[][] gameBoard;
	
	@Override
	public Tile[][] setupGameboard() {
		gameBoard = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for(int i = 0; i < GameConstants.WORLDSIZE; i++) {
			for( int j = 0; j < GameConstants.WORLDSIZE; j++) {
				gameBoard[i][j] = new TileImpl (new Position(i,j), GameConstants.PLAINS);
			}
		}
		gameBoard[0][0] = new TileImpl(new Position(0,0),GameConstants.PLAINS);
		gameBoard[1][0] = new TileImpl(new Position(1,0),GameConstants.OCEANS);
		gameBoard[0][1] = new TileImpl(new Position(0,1),GameConstants.HILLS);
		gameBoard[2][2] = new TileImpl(new Position(2,2),GameConstants.MOUNTAINS);
		setupUnitsAndCities();
		return gameBoard;
	}

	@Override
	public void setupUnitsAndCities() {
		gameBoard[1][1].addCity(new CityImpl(Player.RED, 1, GameConstants.ARCHER, GameConstants.productionFocus));
		gameBoard[4][2].addCity(new CityImpl(Player.BLUE, 1, GameConstants.ARCHER, GameConstants.productionFocus));
		gameBoard[2][0].setUnit(new UnitArcher(Player.RED));
		gameBoard[3][2].setUnit(new UnitLegion(Player.BLUE));
		gameBoard[4][3].setUnit(new UnitSettler(Player.RED));
	}
}
