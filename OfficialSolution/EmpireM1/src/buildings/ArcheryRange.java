package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Archer;
import units.Unit;

public class ArcheryRange extends MilitaryBuilding {

	public ArcheryRange() {
		super(1500, 800, 400);

	}
	public Unit recruit() throws BuildingInCoolDownException,MaxRecruitedException {
		
			if(this.isCoolDown())
				throw new BuildingInCoolDownException("Sorry building is in cooldown.");
			else if(this.getCurrentRecruit() == this.getMaxRecruit())
				throw new MaxRecruitedException ("You Reached the max recruitment per turn.") ;
			
			Unit u = null ;
			if (this.getLevel() == 1)
				u = (new Archer(1, 60, 0.4, 0.5, 0.6));

			else if (this.getLevel() == 2)
				u = (new Archer(2, 60, 0.4, 0.5, 0.6));
			else
				u = (new Archer(3, 70, 0.5, 0.6, 0.7));
		this.setCurrentRecruit(getCurrentRecruit() + 1); // make sure of that :<<
		return u ;
	}
	
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
	//try {
	super.upgrade(); // try catch ?
	this.setLevel(getLevel()+1);
	this.setCoolDown(true); // put it or in upgradeBuilding ?
	if(this.getLevel() == 2) {
		this.setUpgradeCost(700);
		this.setRecruitmentCost(450);
	}
	else if(this.getLevel() == 3)
		this.setRecruitmentCost(500);
	
	//}
	/*catch (BuildingInCoolDownException b) {
		System.out.println(b);
	}
	catch (MaxLevelException b){
		System.out.println(b);
	}*/
	
}
}
