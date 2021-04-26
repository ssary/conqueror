package units;

public class Unit {
	int level ;
	int maxSoldierCount ;
	int currentSoldierCount;
	double idleUpkeep;
	double marchingUpkeep;
	double siegeUpkeep;
	  
	
	
	public Unit(int level ,int maxSoldierCount ,int currentSoldierCount,
			double idleUpkeep,double marchingUpkeep,double siegeUpkeep ) 
	{
		 this.level=level ;
		 this.maxSoldierCount=maxSoldierCount ;
		 this.currentSoldierCount=currentSoldierCount;
		 this.idleUpkeep=idleUpkeep;
		 this.marchingUpkeep=marchingUpkeep;
		 this.siegeUpkeep=siegeUpkeep;
	}



	public int getLevel() {
		return level;
	}



	

	public int getMaxSoldierCount() {
		return maxSoldierCount;
	}



	


	public int getCurrentSoldierCount() {
		return currentSoldierCount;
	}



	public void setCurrentSoldierCount(int currentSoldierCount) {
		this.currentSoldierCount = currentSoldierCount;
	}



	public double getIdleUpkeep() {
		return idleUpkeep;
	}





	public double getMarchingUpkeep() {
		return marchingUpkeep;
	}



	



	public double getSiegeUpkeep() {
		return siegeUpkeep;
	}



	
	
	 
	 
	 
	 }


