package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Cavalry;
import units.Unit;

public class Stable extends MilitaryBuilding {

	public Stable() {
		super(2500, 1500, 600);

	}
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
	//try { 
	super.upgrade(); // try catch ? if no errors continue
	this.setLevel(getLevel()+1);
	this.setCoolDown(true); // put it or in upgradeBuilding ?
	if(this.getLevel() == 2) {
		this.setUpgradeCost(2000);
		this.setRecruitmentCost(650);
	}
	else if(this.getLevel() == 3)
		this.setRecruitmentCost(700);
	
	//}
	/*catch (BuildingInCoolDownException b) {
		System.out.println(b);
	}
	catch (MaxLevelException b){
		System.out.println(b);
	}
	*/
}
	
	public Unit recruit() throws BuildingInCoolDownException,MaxRecruitedException {
		
		if(this.isCoolDown()) 
			throw new BuildingInCoolDownException("Sorry building is in cooldown.");
		else if(this.getCurrentRecruit() == this.getMaxRecruit())
			throw new MaxRecruitedException ("You Reached the max recruitment per turn.") ;
		
		Unit u = null ;
		if (this.getLevel() == 1)
			u = (new Cavalry(1, 40, 0.6, 0.7, 0.75));

		else if (this.getLevel() == 2)
			u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
		else
			u = (new Cavalry(3, 60, 0.7, 0.8, 0.9));

	this.setCurrentRecruit(getCurrentRecruit() + 1); // make sure of that :<<
	return u ;		
}
}
