package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import buildings.EconomicBuilding;
import buildings.*;
import engine.*;
import units.Army;
import view.*;


public class Control {
	private Game game ;
	private Player player ;
	private StartingWindow startingwindow;
	private MainWindow mainwindow;
	private ChooseCityWindow choosecity;
	private WorldMapView mapview ;
	private String cityname ;
	private MyFrame Cityview ;
	
	
	public Control() throws IOException {
	startingwindow = new StartingWindow();
	if(!startingwindow.isNextwindow()) {
		JLabel again = new JLabel("enter valid non-empty name ");
		startingwindow.add(again);
	}
	while(!startingwindow.isNextwindow() ) {
		System.out.print("");
	}
	
	player = new Player(startingwindow.getNameText());
	
	startingwindow.dispose();
	//startingwindow.dispatchEvent(new WindowEvent(startingwindow, WindowEvent.WINDOW_CLOSING));
	choosecity= new ChooseCityWindow();
	while(!choosecity.getPressed()) {
		System.out.print("");
	}
	cityname = choosecity.getChosen();
	City maincity = new City(cityname);
	player.getControlledCities().add(maincity);
	game = new Game(player.getName() ,cityname);
	choosecity.getContentPane().remove(0);
	choosecity.repaint();
	
	
	mainwindow = new MainWindow();
	mainwindow.getname().setText("Player : "+ player.getName() + " " +cityname);
	player.setTreasury(5000);
	lnkMainWindow();
	player.getControlledArmies().add(new Army(cityname) );
	player.getControlledArmies().add(new Army(cityname) );
	mapview = new WorldMapView(player.getControlledArmies()) ;
	mapview.setAvailablecities(game.getAvailableCities());
	
	
	
	if(cityname.equals("Cairo")) {
		Cityview = new MyFrame();
	}
	
	
	}

	public Game getGame() {
		return game;
	}

	public Player getP() {
		return player;
	}

	public void setP(Player p) {
		player = p;
	}
	
	private void lnkMainWindow() {
		
		mainwindow.getFood().setText("Food : " + player.getFood()+"  ");
		mainwindow.getMoney().setText("Money : " + player.getTreasury()+"  ");
		mainwindow.getTurncount().setText("Turns : "+ game.getCurrentTurnCount()+"/50  ");
	}
	
	public ArrayList<Army> getIdleArmy() {
		return player.getControlledArmies();
	}

	public Player getPlayer() {
		return player;
	}

	public StartingWindow getStartingwindow() {
		return startingwindow;
	}

	public MainWindow getMainwindow() {
		return mainwindow;
	}

	public ChooseCityWindow getChoosecity() {
		return choosecity;
	}

	public WorldMapView getMapview() {
		return mapview;
	}

	public String getCityname() {
		return cityname;
	}
	
}
