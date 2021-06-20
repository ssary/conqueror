package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import buildings.Farm;
import buildings.Market;
import exceptions.FriendlyFireException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class Game {
	private Player player;
	private ArrayList<City> availableCities;
	private ArrayList<Distance> distances;
	private final int maxTurnCount = 30;
	private int currentTurnCount;

	public Game(String playerName, String playerCity) throws IOException {

		player = new Player(playerName);
		availableCities = new ArrayList<City>();
		distances = new ArrayList<Distance>();
		currentTurnCount = 1;
		loadCitiesAndDistances();
		for (City c : availableCities) {
			if (c.getName().equals(playerCity))

				player.getControlledCities().add(c);

			else
				loadArmy(c.getName(), c.getName().toLowerCase() + "_army.csv");

		}
	}

	private void loadCitiesAndDistances() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("distances.csv"));
		String currentLine = br.readLine();
		ArrayList<String> names = new ArrayList<String>();

		while (currentLine != null) {

			String[] content = currentLine.split(",");
			if (!names.contains(content[0])) {
				availableCities.add(new City(content[0]));
				names.add(content[0]);
			} else if (!names.contains(content[1])) {
				availableCities.add(new City(content[1]));
				names.add(content[1]);
			}
			distances.add(new Distance(content[0], content[1], Integer.parseInt(content[2])));
			currentLine = br.readLine();

		}
		br.close();
	}

	public void loadArmy(String cityName, String path) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(path));
		String currentLine = br.readLine();
		Army resultArmy = new Army(cityName);
		while (currentLine != null) {
			String[] content = currentLine.split(",");
			String unitType = content[0].toLowerCase();
			int unitLevel = Integer.parseInt(content[1]);
			Unit u = null;
			
			if (unitType.equals("archer")) {

				if (unitLevel == 1) {
					u = (new Archer(1, 60, 0.4, 0.5, 0.6));
					
				}
				else if (unitLevel == 2)
					u = (new Archer(2, 60, 0.4, 0.5, 0.6));
				else
					u = (new Archer(3, 70, 0.5, 0.6, 0.7));
			} else if (unitType.equals("infantry")) {
				if (unitLevel == 1)
					u = (new Infantry(1, 50, 0.5, 0.6, 0.7));

				else if (unitLevel == 2)
					u = (new Infantry(2, 50, 0.5, 0.6, 0.7));
				else
					u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			} else if (unitType.equals("cavalry")) {
				if (unitLevel == 1)
					u = (new Cavalry(1, 40, 0.6, 0.7, 0.75));

				else if (unitLevel == 2)
					u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
				else
					u = (new Cavalry(3, 60, 0.7, 0.8, 0.9));
			}
			u.setParentArmy(resultArmy);
			resultArmy.getUnits().add(u);
			currentLine = br.readLine();
		}
		br.close();
		for (City c : availableCities) {
			if (c.getName().toLowerCase().equals(cityName.toLowerCase()))
				c.setDefendingArmy(resultArmy);
		}
	}

	
	public void targetCity(Army army, String targetName) {
		int d = 0 ;
		army.setTarget(targetName);
		army.setCurrentStatus(Status.MARCHING);
		for(int i =0 ;i < distances.size();i++) {
			if(distances.get(i).getFrom().equals(army.getCurrentLocation()) && (distances.get(i).getTo().equals(targetName))) {
				d = distances.get(i).getDistance();
			}
			else if(distances.get(i).getTo().equals(army.getCurrentLocation()) && (distances.get(i).getFrom().equals(targetName)))
				d= distances.get(i).getDistance();
		}
		army.setDistancetoTarget(d);
		
	//--------------------------------------------------------------------------------------------------------------------------------------------	
		
	}
	public void endTurn() {
		setCurrentTurnCount(currentTurnCount + 1);
		for(int i =0 ; i < player.getControlledCities().size() ;i ++ ) {
			City c = player.getControlledCities().get(i);
			for(int j =0 ; j < c.getEconomicalBuildings().size(); j++) {
				c.getEconomicalBuildings().get(j).setCoolDown(false);
				
			int x =	c.getEconomicalBuildings().get(j).harvest();
			 if (c.getEconomicalBuildings().get(j)instanceof Farm  )
			 {
				this.getPlayer().setFood(this.getPlayer().getFood()+x);
			 }
			 if (c.getEconomicalBuildings().get(j)instanceof Market)
			 {
			this.getPlayer().setTreasury(this.getPlayer().getTreasury()+x);
			 }
			}
			
			for(int j =0 ; j < c.getMilitaryBuildings().size(); j++) {
				c.getMilitaryBuildings().get(j).setCoolDown(false);
				c.getMilitaryBuildings().get(j).setCurrentRecruit(0);
				
			}
		
			
	
		}for( int q=0; 	q< availableCities.size();q++)
		 {
			 boolean u = availableCities.get(q).isUnderSiege();
			 int turns = availableCities.get(q).getTurnsUnderSiege() ;
			if(u)
			{
				availableCities.get(q).setTurnsUnderSiege(turns+1);
				for(int j =0 ; j < availableCities.get(q).getDefendingArmy().getUnits().size(); j ++ ) {
					int c = availableCities.get(q).getDefendingArmy().getUnits().get(j).getCurrentSoldierCount();
					availableCities.get(q).getDefendingArmy().getUnits().get(j).setCurrentSoldierCount((int)(c - c*0.1) );
				}
				if(turns==3)
				{
					availableCities.get(q).setUnderSiege(false);
				}
				
				
			}
		 }
		for (int i=0;i<player.getControlledArmies().size();i++)
		{
		Army a = player.getControlledArmies().get(i);
		this.getPlayer().setFood(this.getPlayer().getFood()-a.foodNeeded());
		 
		if (this.getPlayer().getFood()<=0)// equals 
		{
			this.getPlayer().setFood(0);
			
			for(int j =0 ; j < a.getUnits().size(); j ++ ) {
				int sold = a.getUnits().get(j).getCurrentSoldierCount() ;
				a.getUnits().get(j).setCurrentSoldierCount( (int)(sold - (sold*0.1)));
			}
		
		}
		if (a.getTarget()=="");
		else {
		a.setDistancetoTarget(a.getDistancetoTarget()-1);
		if (a.getDistancetoTarget()==0)
		{
		a.setCurrentLocation(a.getTarget());
		a.setCurrentStatus(Status.IDLE);
		a.setDistancetoTarget(-1);
		a.setTarget("");
	
		}
		}
		}
	}
		//-----------------------------------------------------------------------------------------------------------------------------
		
	public void occupy(Army a,String cityName) {
		City c = new City(cityName);
		for(int j =0 ; j < availableCities.size();j++) {
		if(availableCities.get(j).getName().equals(cityName)) {
		this.getPlayer().getControlledCities().add(availableCities.get(j));
		c= availableCities.get(j);
		}
		}
		c.setDefendingArmy(a);
		c.setUnderSiege(false);
		c.setTurnsUnderSiege(-1);
		/*for(int i =0 ; i < c.getDefendingArmy().getUnits().size();i++) {
			a.getUnits().add(c.getDefendingArmy().getUnits().get(i));
		}*/
		
	}
		
	///-------------------------------------------------------------
	
	public void autoResolve(Army attacker, Army defender) throws FriendlyFireException{
		City c = new City(attacker.getCurrentLocation());
		for(int j =0 ; j < availableCities.size();j++) {
		if(availableCities.get(j).getName().equals(attacker.getCurrentLocation())) {
		this.getPlayer().getControlledCities().add(availableCities.get(j));
		c= availableCities.get(j);
		}
		}
		
		if(player.getControlledArmies().contains(defender) && player.getControlledArmies().contains(attacker) || (attacker.equals(defender))) { // if controlled armies contains defender , attacker or mabrouk
			throw new FriendlyFireException( "You are attacking your friend.") ;
			}
		boolean turn = false; // 0 -> attack , 1 -> defender // not changed
		while(attacker.getUnits().size() != 0 && defender.getUnits().size() != 0 ) {
			
			int atr = (int)(Math.random() * attacker.getUnits().size()) ;
			int dr = (int)(Math.random() * defender.getUnits().size() );
			
			if(!turn)
				attacker.getUnits().get(atr).attack(defender.getUnits().get(dr));
			else
				defender.getUnits().get(dr).attack(attacker.getUnits().get(atr));
			turn = !turn;
			
		}
		
	if(attacker.getUnits().size() != 0) {
		occupy(attacker, defender.getCurrentLocation());
	}
	endTurn();
	
	}
	
	
	public boolean isGameOver() {
		if(currentTurnCount > maxTurnCount || this.player.getControlledCities().size() == availableCities.size()) {
			return true;
		}
		
			return false;
	}
	
	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}

	public ArrayList<Distance> getDistances() {
		return distances;
	}

	public int getCurrentTurnCount() {
		return currentTurnCount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMaxTurnCount() {
		return maxTurnCount;
	}

	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}

}
