package hotciv.standard;
import hotciv.framework.*;

public class TileImpl implements Tile{
	Position position;
	String type;
	Unit unit;
	City city;

	public TileImpl(Position p, String t) {
		position = p;
		type = t;
		unit = null;
		city = null;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public String getTypeString() {
		return type;
	}

	@Override
	public void changeTypeString(String newType) {
		this.type = newType;
	}

	@Override
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public void removeUnit() {
		this.unit = null;
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public void addCity(City city) {
		this.city = city;
	}

	@Override
	public City getCity() {
		return city;
	}

	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o.getClass() != TileImpl.class) { return false; }
		TileImpl other = (TileImpl) o;
		return position.equals(other.position) && type.equals(other.type);
	}
}
