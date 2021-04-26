package engine;
import java.util.*;
public class Game {
	private Player player ;
	private ArrayList<City> availableCities ;
	private ArrayList<Distance> distances ;
	private int maxTurnCount ,currentTurnCount;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getCurrentTurnCount() {
		return currentTurnCount;
	}
	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}
	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}
	public ArrayList<Distance> getDistances() {
		return distances;
	}
	public int getMaxTurnCount() {
		return maxTurnCount;
	}
	
	
}
