package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Infantry;
import units.Unit;

public class Barracks extends MilitaryBuilding {

	public Barracks() {
		super(2000, 1000, 500);
	}

	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
	//try { 
	super.upgrade(); // try catch ? 
	
	this.setCoolDown(true); // put it or in upgradeBuilding ?
	this.setLevel(getLevel()+1);
	if(this.getLevel() == 2) {
		this.setUpgradeCost(1500);
		this.setRecruitmentCost(550);
	}
	else if(this.getLevel() == 3)
		this.setRecruitmentCost(600);
	
	//}
	/*
	catch (BuildingInCoolDownException b) {
		System.out.println(b);
	}
	catch (MaxLevelException b){
		System.out.println(b);
	}*/
	
}
	
	public Unit recruit() throws BuildingInCoolDownException,MaxRecruitedException {
		
		if(this.isCoolDown()) 
			throw new BuildingInCoolDownException("Sorry building is in cooldown.");
		else if(this.getCurrentRecruit() == this.getMaxRecruit())
			throw new MaxRecruitedException ("You Reached the max recruitment.") ;
		
		Unit u = null ;
		if (this.getLevel() == 1)
			u = (new Infantry(1, 50, 0.5, 0.6, 0.7));

		else if (this.getLevel() == 2)
			u = (new Infantry(2, 50, 0.5, 0.6, 0.7));
		else
			u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
		
		
	this.setCurrentRecruit(getCurrentRecruit() + 1); // make sure of that :<<
	return u ;		
}
}
