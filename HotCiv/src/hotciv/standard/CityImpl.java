package hotciv.standard;
import hotciv.framework.*;

public class CityImpl implements City{
	Player owner;
	int size;
	int productionAmount;
	int foodAmount;
	String production;
	String workFocus;
	
	public CityImpl(Player owner, int size, String production, String workFocus) {
		this.owner = owner;
		this.production = production;
		this.workFocus = workFocus;
		productionAmount = 0;
		foodAmount = 0;
		this.size = size;
	}
	
	@Override
	public Player getOwner() {
		return owner;
	}
	
	@Override
	public void changeOwner(Player player) {
		owner = player;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String getProduction() {
		return production;
	}

	@Override
	public int getProductionAmount() {
		return productionAmount;
	}
	
	@Override
	public void setProduction(String production) {
		this.production= production; 
	}
	
	@Override
	public void addProduction(int amount) {
		productionAmount += amount;
	}
	
	@Override
	public Unit produce() {
		int cost = GameConstants.getCostForUnitType(production);
		if(productionAmount >= cost) {
			productionAmount -= cost; 
			return UnitImpl.produceUnit(production, owner);
		} else {
			return null;
		}
	}
	
	@Override
	public String getWorkforceFocus() {
		return workFocus;
	}
	
	@Override
	public void setWorkforceFocus(String workFocus) {
		this.workFocus = workFocus;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o.getClass() != CityImpl.class) { return false; }
		CityImpl other = (CityImpl) o;
		return owner.equals(other.owner) &&
				size == other.size &&
				production == other.production &&
				workFocus == other.workFocus;
	}

	@Override
	public void addFood(int amount) {
		foodAmount += amount;
	}

	@Override
	public void resetFood() {
		foodAmount = 0;
	}

	@Override
	public int getFood() {
		return foodAmount;
	}
}
