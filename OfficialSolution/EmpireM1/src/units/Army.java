package units;

import java.util.ArrayList;

import exceptions.MaxCapacityException;

/**
 * @author mohammad.hussein
 *
 */
public class Army{
	private Status currentStatus;
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String target;
	private String currentLocation;
	@SuppressWarnings("unused")
	private final int maxToHold=10;

	public Army(String currentLocation) {
		this.currentLocation=currentLocation;
		currentStatus=Status.IDLE;
		distancetoTarget=-1;
		target="";
		units=new ArrayList<Unit>();
		
	}
	// The Parent army of the relocated unit < this < army > >  should be changed to the corresponding army
	public void relocateUnit(Unit unit) throws MaxCapacityException {
		
		if(this.units.size() == this.maxToHold)
			throw new MaxCapacityException ("you can't add more units") ;
		else {
			this.units.add(unit);
			
		//this.units = unit.getParentArmy().getUnits();
		//	this= unit.getParentArmy();
			//this.setUnits(unit.getParentArmy().getUnits());
			
			//for(int i =0 ; i <unit.getParentArmy().getUnits().size() ; i ++  ) {
			//	this.getUnits().set(i, unit.getParentArmy().getUnits().get(i));
			//}
			
			unit.getParentArmy().getUnits().remove(unit);
			unit.setParentArmy(this);
			//this.units.add(unit);
		/*for(int i =0 ; i <this.units.size();i++){
			Unit u = this.units.get(i);
			this.set
			//u.setParentArmy(unit.getParentArmy());
			//unit.setParentArmy(u.getParentArmy());
			//if(u.equals(unit)) {
			//	unit.getParentArmy().getUnits().remove(i);
			//}*/
		
	}
	}
	
	public double foodNeeded() {
		double food =0;
		for(int i =0 ; i < this.units.size();i++) {
			Unit u = this.units.get(i);
			if(currentStatus.equals(Status.IDLE)) {
			food += u.getCurrentSoldierCount() * u.getIdleUpkeep();
			}
			else if(currentStatus.equals(Status.MARCHING)) {
				food += u.getCurrentSoldierCount() * u.getMarchingUpkeep();
			}
			else
				food += u.getCurrentSoldierCount() * u.getSiegeUpkeep();
		}
		return food ;
	}
	
	public void handleAttackedUnit(Unit u) {
		
		for(int i= 0 ; i < this.units.size() ; i ++ ) {
			if(this.units.get(i).equals(u) && this.units.get(i).getCurrentSoldierCount()<= 0) {
				this.units.remove(i);
			}
		}
	}
	
	public Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}

	public int getDistancetoTarget() {
		return distancetoTarget;
	}

	public void setDistancetoTarget(int distancetoTarget) {
		this.distancetoTarget = distancetoTarget;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getMaxToHold() {
		return maxToHold;
	}
	
}
