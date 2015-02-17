package hotciv.stub;

import hotciv.framework.*;

/** Implementation of Tile for the stub.
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
*/


public class StubTile implements Tile {
  private Position position;
  private String type;
  public StubTile(Position p, String type) {
    position = p; this.type = type;
  }
  public Position getPosition() { return position; }
  public String getTypeString() { return type; }
@Override
public void setUnit(Unit unitAt) {
	// TODO Auto-generated method stub
	
}
@Override
public Unit getUnit() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void removeUnit() {
	// TODO Auto-generated method stub
	
}
@Override
public City getCity() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void addCity(City city) {
	// TODO Auto-generated method stub
	
}
@Override
public void changeTypeString(String newType) {
	// TODO Auto-generated method stub
	
}
}