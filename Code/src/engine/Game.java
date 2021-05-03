package engine;
import java.io.IOException;
import java.util.*;
import engine.ReadingCSVFile;
import units.*;


public class Game {
	private Player player ;
	private ArrayList<City> availableCities ;
	private ArrayList<Distance> distances ;
	final private int maxTurnCount = 30;
	private int currentTurnCount = 1;
	
	
	public Game(String playername , String playerCity) throws IOException{
		player = new Player(playername);
		availableCities = new ArrayList<City>();
		distances = new ArrayList<Distance>();
		loadCitiesAndDistances();
		for(int i =0 ;i<availableCities.size();i++) {
			City tmp = availableCities.get(i);
			if(!tmp.getName().equals(playerCity)) {
				char first = (char) (tmp.getName().charAt(0) + ' ');
				String filename = first +  tmp.getName().substring(1) + "_army.csv";
				loadArmy(tmp.getName() ,"C:\\Users\\saryn\\Desktop\\GIU2\\Second\\CS2\\project\\Code\\src\\csv files\\" + filename);
			}
		}
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
		
			ArrayList <String []> soldiers = ReadingCSVFile.readFile(path);
			ArrayList<Unit> units= new ArrayList<Unit>();
			for(int i =0 ;i<soldiers.size();i++) {
				Unit soldier;
				String type = soldiers.get(i)[0];
				String lvl = soldiers.get(i)[1];
				if(type.equals("Archer") ) {
					
					if(lvl.equals("1") || lvl.equals("2"))
						soldier = new Archer(Integer.parseInt(lvl) , 60 , 0.4,0.5,0.6);
					else 
						soldier = new Archer(Integer.parseInt(lvl) , 70 , 0.5,0.6,0.7);
				}
				else if(type.equals("Infantry")) {
					if(lvl.equals("1") || lvl.equals("2"))
						soldier = new Infantry(Integer.parseInt(lvl) , 50 , 0.5,0.6,0.7);
					else
						soldier = new Infantry(Integer.parseInt(lvl) , 60 , 0.6,0.7,0.8);
				}
			
			else {
				if(lvl.equals("1") )
					soldier = new Cavalry(Integer.parseInt(lvl) , 40 , 0.6 ,0.7 ,0.75);
				else if(lvl.equals("2"))
					soldier = new Cavalry(Integer.parseInt(lvl) , 40 , 0.6 ,0.6 ,0.75);
				else
					soldier = new Cavalry(Integer.parseInt(lvl) , 60 , 0.7 ,0.8 ,0.9);
			}
				units.add(soldier);
			}
			
			
			Army army = new Army(cityName);
			army.setUnits(units);
			for(int i =0 ;i<availableCities.size();i++) {
				if(cityName.equals(availableCities.get(i).getName())) {
					availableCities.get(i).setDefendingArmy(army);
					break;
				}
			}
			//city.setDefendingArmy(//pass the variable);F14G :>
	}
	
	private void loadCitiesAndDistances() throws IOException{
		ArrayList <String []> dist = ReadingCSVFile.readFile("distances.csv");
		for(int i=0;i<dist.size();i++) {
			City o = new City((dist.get(i))[0]);
			City t = new City(dist.get(i)[1]);
			boolean first = true , second =true;
			for(City city : this.availableCities) {
				if(o.getName().equals(city.getName()))
					first = false;
				if(t.getName().equals(city.getName()))
					second = false;
			}
			if(first)
				availableCities.add(o);
			if(second)
				availableCities.add(t);
			
			
			
			int d = Integer.parseInt(dist.get(i)[2]);
			Distance s = new Distance(dist.get(i)[0] ,dist.get(i)[1], d);
			distances.add(s);
			
		}
		
	}
	
}
