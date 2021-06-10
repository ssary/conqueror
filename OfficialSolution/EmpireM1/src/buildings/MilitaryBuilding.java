package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Unit;

public abstract class MilitaryBuilding extends Building {
	private int recruitmentCost;
	private int maxRecruit;
	private int currentRecruit;

	public MilitaryBuilding(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost);
		this.recruitmentCost = recruitmentCost;
		maxRecruit = 3;

	}

	
	/*public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		
		if(this instanceof ArcheryRange) {
		
			if(this.getLevel() == 1) {
				this.setRecruitmentCost(450);
			}
			
			else if(this.getLevel() == 2) {
				this.setUpgradeCost(700);
				this.setRecruitmentCost(500);
			}
		}
		
		else if(this instanceof Barracks) {
			if(this.getLevel() == 1) {
				this.setRecruitmentCost(550);
			}
			
			else if(this.getLevel() == 2) {
				this.setUpgradeCost(1500);
				this.setRecruitmentCost(600);
			}
		}
		
		else if(this instanceof Stable) {
			if(this.getLevel() == 1) {
				this.setRecruitmentCost(650);
			}
			
			else if(this.getLevel() == 2) {
				this.setUpgradeCost(2000);
				this.setRecruitmentCost(700);
			}
		}
		
	}*/
	
	public abstract Unit recruit() throws BuildingInCoolDownException,MaxRecruitedException ;
	
	public int getRecruitmentCost() {
		return recruitmentCost;
	}

	public void setRecruitmentCost(int recruitmentCost) {
		this.recruitmentCost = recruitmentCost;
	}

	public int getMaxRecruit() {
		return maxRecruit;
	}

	public int getCurrentRecruit() {
		return currentRecruit;
	}

	public void setCurrentRecruit(int currentRecruit) {
		this.currentRecruit = currentRecruit;
	}

}
