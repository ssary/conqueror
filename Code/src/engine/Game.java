package engine;
import java.io.IOException;
import java.util.*;


public class Game {
	private Player player ;
	private ArrayList<City> availableCities ;
	private ArrayList<Distance> distances ;
	final private int maxTurnCount = 30;
	private int currentTurnCount = 1;
	
	public Game(String playername , String playerCity) throws IOException{
		player = new Player(playername);
		
	}
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
	public void loadArmy(String cityName,String path) throws IOException{
		
	}
	
}
