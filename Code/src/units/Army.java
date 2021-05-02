package units;
import java.util.*;

public class Army {
	Status currentStatus;
	
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String currentLocation;
	private final int maxToHold =10;
	private  String target;
	
	
	 public  Army (String currentLocation)
	 {
		 units = new ArrayList<Unit> () ;
		 currentStatus = Status.IDLE;
		 this.currentLocation=currentLocation;
		 distancetoTarget = -1 ;
		 target ="";
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
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getMaxToHold() {
		return maxToHold;
	}
	 
	 
	 

}

