package units;

import exceptions.FriendlyFireException;

public class Infantry extends Unit {

	public Infantry(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	
	public void attack(Unit target) throws FriendlyFireException {
		//try {
		super.attack(target);
		int lvl = this.getLevel();
		int CurrA = this.getCurrentSoldierCount();
		if(lvl == 1) {
			if(target instanceof Archer) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.3)));

			}
			else if(target instanceof Infantry || target instanceof Cavalry) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.1)));

			}
		}
		
		else if(lvl == 2) {
			if(target instanceof Archer) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.4)));

			}
			else if(target instanceof Infantry || target instanceof Cavalry) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.2)));

			}
		}
		else {
			if(target instanceof Archer) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.5)));

			}
			else if(target instanceof Infantry) {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.3)));

			}
			else {
				target.setCurrentSoldierCount((int)( target.getCurrentSoldierCount() - (CurrA * 0.25)));

			}
		}
		if(target.getCurrentSoldierCount() <=0 ) {
			target.setCurrentSoldierCount(0);
			target.getParentArmy().handleAttackedUnit(target);
		}
		//}
		//catch(FriendlyFireException f) {
			//System.out.println(f);}
	}
	// Occupy 
}
