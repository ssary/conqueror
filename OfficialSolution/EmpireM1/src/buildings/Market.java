package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Market extends EconomicBuilding {

	public Market() {
		super(1500, 700);
	}
	
	public int harvest () {
		switch(this.getLevel()) {
		case 1 :
			return 1000 ;
		
		case 2 :
			return 1500;
			
		case 3 : 
			return 2000 ; 
			
		default : return 1 ;
		}
	}
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		//try {
			super.upgrade();
			this.setCoolDown(true);
			this.setLevel(getLevel()+1);
			if(this.getLevel() == 2) {
				this.setUpgradeCost(1000); 
			}
			
			//}
			/*
			catch (BuildingInCoolDownException b) {
				System.out.println(b);
			}
			catch (MaxLevelException b){
				System.out.println(b);
			}*/
	}
}
