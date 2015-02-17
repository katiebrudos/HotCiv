/** Game is the central interface allowing a client to access and
 * modify the state of a HotCiv game.  

   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
package hotciv.framework;

import hotciv.view.CivDrawing;

public interface Game {
  // === Accessor methods ===================================
  
	public Tile getTileAt( Position p );

	public Unit getUnitAt( Position p );
	
	public void setUnitAt( Position p, Unit unit);
	
	public void removeUnitAt(Position p);

	public City getCityAt( Position p );
	
	public void setCityAt( Position p, City city);

	public Player getPlayerInTurn();
		
	public boolean moveUnit( Position from, Position to );
	
	public void changeWorkForceFocusInCityAt( Position p, String balance );
	public void changeProductionInCityAt( Position p, String unitType );
	
	public void endOfTurn();
	public Player getWinner();
	public void performUnitActionAt( Position p );
	
	public void setAge(int age); 
	public int getAge();

	public void endOfRound();

	public void addObserver(GameObserver civDrawing);
	
	/**
	  * set the focus on a specific tile. This will
	  * result in an event being broadcast to all
	  * observers that focus has been changed to
	  * this tile.
	  * @param position the position of the tile that
	  * has focus
	  */
	public void setTileFocus(Position position);

	Position getCurrentCityFocusPosition();
}
