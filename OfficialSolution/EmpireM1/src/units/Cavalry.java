package units;

import exceptions.FriendlyFireException;

public class Cavalry extends Unit {

	public Cavalry(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	
	public void attack(Unit target) throws FriendlyFireException {
		//try {
		super.attack(target);
		int lvl = this.getLevel();
		int CurrA = this.getCurrentSoldierCount();
		if(lvl == 1) {
			if(target instanceof Archer) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.5) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 , target.getCurrentSoldierCount() - (int)(CurrA * 0.5)));
				
			}
			
			else if(target instanceof Infantry ) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.3) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.3)));}
			
			else if(target instanceof Cavalry){
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.2) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 , target.getCurrentSoldierCount() - (int)(CurrA * 0.2)) );}
			
		}
		
		else if(lvl == 2) {
			
			if(target instanceof Archer) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.6) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.6)));
			}
			
			else if(target instanceof Infantry ) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.4) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.4)));
				}
			else {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.2) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 , target.getCurrentSoldierCount() - (int)(CurrA * 0.2)));
				
			}
			
		}
		// LVL 3
		else {
			if(target instanceof Archer) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.7) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.7)));
			}
			else if(target instanceof Infantry) {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.5) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.5)));
			}
			else {
				if(target.getCurrentSoldierCount() - (int)(CurrA * 0.3) <=0 ) {
					target.getParentArmy().handleAttackedUnit(target);
				}
				
				target.setCurrentSoldierCount(Math.max(0 ,target.getCurrentSoldierCount() - (int)(CurrA * 0.3)));
			}
		}
	//}
		//catch(FriendlyFireException f) {
		//	System.out.println(f);}
	}
	// Occupy
}
