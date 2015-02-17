package hotciv.standard.integration;

import hotciv.framework.GameConstants;
import hotciv.framework.*; 
import hotciv.standard.*;

public class SetupStrategyEtaStub implements SetupStrategy {
	Tile[][] gameBoard;

	@Override
	public Tile[][] setupGameboard() {
		gameBoard = new Tile[GameConstants.WORLDSIZE][GameConstants.WORLDSIZE];
		for(int i = 0; i < GameConstants.WORLDSIZE; i++) {
			for( int j = 0; j < GameConstants.WORLDSIZE; j++) {
				gameBoard[i][j] = new TileImpl (new Position(i,j), GameConstants.PLAINS);
			}
		}
		gameBoard[1][1] = new TileImpl(new Position(1,1),GameConstants.OCEANS);
		gameBoard[1][2] = new TileImpl(new Position(1,2),GameConstants.OCEANS);
		gameBoard[1][3] = new TileImpl(new Position(1,3),GameConstants.MOUNTAINS);
		gameBoard[2][1] = new TileImpl(new Position(2,1),GameConstants.MOUNTAINS);
		gameBoard[2][2] = new TileImpl(new Position(2,2),GameConstants.PLAINS);
		gameBoard[2][3] = new TileImpl(new Position(2,3),GameConstants.PLAINS);
		gameBoard[3][1] = new TileImpl(new Position(3,1),GameConstants.FOREST);
		gameBoard[3][2] = new TileImpl(new Position(3,2),GameConstants.HILLS);
		gameBoard[3][3] = new TileImpl(new Position(3,3),GameConstants.HILLS);

		setupUnitsAndCities();
		return gameBoard;
	}

	@Override
	public void setupUnitsAndCities() {
		//do nothing 
	}

}
