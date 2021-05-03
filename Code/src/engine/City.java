package engine;
import java.util.* ;

import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import units.Army ;
public class City{
	private String name ;
	private ArrayList<EconomicBuilding> economicalBuildings;
	private ArrayList<MilitaryBuilding> militaryBuildings ;
	private Army defendingArmy;
	private int turnsUnderSiege ;
	private boolean underSiege ;
	
	public City(String name) {
		this.name = name ;
		underSiege = false;
		//defendingArmy = new Army(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTurnsUnderSiege() {
		return turnsUnderSiege;
	}

	public void setTurnsUnderSiege(int turnsUnderSiege) {
		this.turnsUnderSiege = turnsUnderSiege;
	}

	public boolean isUnderSiege() {
		return underSiege;
	}

	public void setUnderSiege(boolean underSiege) {
		this.underSiege = underSiege;
	}

	public ArrayList<EconomicBuilding> getEconomicalBuildings() {
		return economicalBuildings;
	}

	public ArrayList<MilitaryBuilding> getMilitaryBuildings() {
		return militaryBuildings;
	}

	public Army getDefendingArmy() {
		return defendingArmy;
	}
	public void setDefendingArmy(Army m) {
		this.defendingArmy = m;
	}
	
	
}
