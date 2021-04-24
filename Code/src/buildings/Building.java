package buildings;

abstract public class Building {
	
	
	private int cost , level , upgradeCost;
	private boolean coolDown ;
	
	public Building() {
		
	}
	public Building (int c , int uc) {
		level =1;
		coolDown = true;
		cost = c;
		upgradeCost = uc ;
	}
	
	public int getCost() {
		return cost;}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public boolean isCoolDown() {
		return coolDown;
	}

	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}
	
}
