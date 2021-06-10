package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Farm extends EconomicBuilding {

	public Farm() {
		super(1000, 500);

	}
	
	public int harvest () {
		switch(this.getLevel()) {
		case 1 :
			return 500 ;

		case 2 :
			return 700;
			
		case 3 : 
			return 1000 ; 
			
		default : return 0 ;
		}
	}
	
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		//try {
		//super.upgrade();
		if(this.isCoolDown())
			throw new BuildingInCoolDownException("Sorry building is in cooldown");
			
		else if(this.getLevel() == 3)
			throw new MaxLevelException("Max level is 3 , you are already level 3");
		
		this.setCoolDown(true);
		this.setLevel(getLevel()+1);
		if(this.getLevel() == 2) {
			this.setUpgradeCost(700); 
		}
		
		//}
		/*catch (BuildingInCoolDownException b) {
			System.out.println(b);
		}
		catch (MaxLevelException b){
			System.out.println(b);
		}
		*/
		
		//this.setLevel(this.getLevel() + 1 );
	}
}
