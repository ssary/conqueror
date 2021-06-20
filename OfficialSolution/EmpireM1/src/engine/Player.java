package engine;

import java.util.ArrayList;

import buildings.*;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.*;

public class Player {
	private String name;
	private ArrayList<City> controlledCities;
	private ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;

	public Player(String name) {
		this.name = name;
		this.controlledCities = new ArrayList<City>();
		this.controlledArmies = new ArrayList<Army>();
	}

	public void recruitUnit(String type,String cityName) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException{
		City c = new City (cityName);
		
		for(int i =0 ; i < this.controlledCities.size();i++) {
			if(this.controlledCities.get(i).getName().equals(cityName)) {
					c = this.controlledCities.get(i) ;
			}
		}
		
		for(int i=0 ;i < c.getMilitaryBuildings().size();i++) {
			
			if(type == "Archer" ) {
				if(c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
					
					if(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost() <0 ) {
						throw new NotEnoughGoldException("You don't have enough gold for recruitment.");
					}
					
					c.getDefendingArmy().getUnits().add(c.getMilitaryBuildings().get(i).recruit());// recruit from the corresponding building
					this.setTreasury(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost()); // decrease treasury by rec cost
					c.getDefendingArmy().getUnits().get(c.getDefendingArmy().getUnits().size() - 1).setParentArmy(c.getDefendingArmy());
					
				}
			}
			
			if(type == "Cavalry") {
				if(c.getMilitaryBuildings().get(i) instanceof Stable) {
					
					if(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost() <0 ) {
						throw new NotEnoughGoldException("You don't have enough gold for recruitment.");
					}
					
					c.getDefendingArmy().getUnits().add(c.getMilitaryBuildings().get(i).recruit()); 
					this.setTreasury(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost());
					c.getDefendingArmy().getUnits().get(c.getDefendingArmy().getUnits().size() - 1).setParentArmy(c.getDefendingArmy());
					
				}
			}
			else if(type == "Infantry") {
				if(c.getMilitaryBuildings().get(i) instanceof Barracks) {
					
					if(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost() <0 ) {
						throw new NotEnoughGoldException("You don't have enough gold for recruitment.");
					}
					
					c.getDefendingArmy().getUnits().add(c.getMilitaryBuildings().get(i).recruit()); 
					this.setTreasury(this.getTreasury() - c.getMilitaryBuildings().get(i).getRecruitmentCost());
					c.getDefendingArmy().getUnits().get(c.getDefendingArmy().getUnits().size() - 1).setParentArmy(c.getDefendingArmy());
					
				}
			}
			
		}
		
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	

	
	public void build(String type,String cityName) throws NotEnoughGoldException {
		City c = new City (cityName);
		boolean e3ml = true;
		for(int i =0 ; i < this.controlledCities.size();i++) {
			if(this.controlledCities.get(i).getName().equals(cityName)) {
					c = this.controlledCities.get(i) ;
			}
		}
		
		if(true) {
		if(type == "Market") {
			for (int i=0;i<c.getEconomicalBuildings().size();i++) {
				
				if(c.getEconomicalBuildings().get(i) instanceof Market) {e3ml = false;}
			}
			if (e3ml) {
			Market b = new Market();
			
			if(b.getCost() > this.getTreasury())
				throw new NotEnoughGoldException() ;
			
			c.getEconomicalBuildings().add(b);
			this.setTreasury(treasury - b.getCost());
			b.setCoolDown(true);
		}
		}
		
		if(type == "Farm") {
			for (int i=0;i<c.getEconomicalBuildings().size();i++) {
				
				if(c.getEconomicalBuildings().get(i) instanceof Farm) {e3ml = false;}
			}
			if (e3ml) {
			Farm b = new Farm();
			if(b.getCost() > this.getTreasury())
				throw new NotEnoughGoldException() ;
			
			//for(int i =0 ; i < c.getEconomicalBuildings().size();i++) {
				
		//		if(c.getEconomicalBuildings().get(i) instanceof Farm) {
				
		//		}
				
		//	}
			c.getEconomicalBuildings().add(b);
			this.setTreasury(treasury - b.getCost());
			b.setCoolDown(true);
		}
		}
		
		if(type == "ArcheryRange") {
			for (int i=0;i<c.getMilitaryBuildings().size();i++) {
			
				if(c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {e3ml = false;}
			}
			if (e3ml) {
			ArcheryRange b = new ArcheryRange();
			if(b.getCost() > this.getTreasury())
				throw new NotEnoughGoldException() ;
			
			c.getMilitaryBuildings().add(b);
			this.setTreasury(treasury - b.getCost());
			b.setCoolDown(true);
		}
		}
		
		if(type == "Barracks") {
			for (int i=0;i<c.getMilitaryBuildings().size();i++) {
			
				if(c.getMilitaryBuildings().get(i) instanceof Barracks) {e3ml = false;}
			}
			if (e3ml) {
			Barracks b = new Barracks();
			if(b.getCost() > this.getTreasury())
				throw new NotEnoughGoldException() ;
			
			c.getMilitaryBuildings().add(b);
			this.setTreasury(treasury - b.getCost());
			b.setCoolDown(true);
		}
		}
		
		if(type == "Stable") {
			for (int i=0;i<c.getMilitaryBuildings().size();i++) {
			
				if(c.getMilitaryBuildings().get(i) instanceof Stable) {e3ml = false;}
			}
			if (e3ml) {
			Stable b = new Stable();
			if(b.getCost() > this.getTreasury())
				throw new NotEnoughGoldException() ;
			
			c.getMilitaryBuildings().add(b);
			this.setTreasury(treasury - b.getCost());
			b.setCoolDown(true);
		}
		}
		}
	}
	
	public void upgradeBuilding(Building b) throws NotEnoughGoldException,BuildingInCoolDownException, MaxLevelException{
		if (b.isCoolDown())
		throw new 	BuildingInCoolDownException();
		else {
			
		if(b.getLevel()==3) 
			throw new  MaxLevelException();
		else {
			
		if(b.getUpgradeCost() > treasury) {
			throw new NotEnoughGoldException();
		}
		treasury -= b.getUpgradeCost(); 
		b.upgrade();
		}
	}}
	public void initiateArmy(City city,Unit unit) {
		Army a = new Army(city.getName());
		a.getUnits().add(unit);
		city.getDefendingArmy().getUnits().remove(unit);
		unit.setParentArmy(a);
		controlledArmies.add(a);
	}
	
	public void laySiege(Army army,City city) throws TargetNotReachedException,FriendlyCityException{
		if(!city.isUnderSiege()) {
		for(int i =0 ; i < controlledCities.size();i++) {
			if(controlledCities.get(i).getName().equals(city.getName())) {
				throw new FriendlyCityException();
			}
		}
		
		if(!army.getCurrentLocation().equals(city.getName())) {
			throw new TargetNotReachedException();
		}
		
		army.setCurrentStatus(Status.BESIEGING);
		city.setUnderSiege(true);
		city.setTurnsUnderSiege(0);
		}
	}
	
	
	public double getTreasury() {
		return treasury;
	}

	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	public String getName() {
		return name;
	}

	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}

	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}
}
