package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

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
	game = new Game(player.getName() ,cityname);
	choosecity.clearall();
	
	mainwindow = new MainWindow();
	mainwindow.getname().setText("Player : "+ player.getName() + " " +cityname);
	player.setTreasury(5000);
	lnkMainWindow();
	new WorldMapView();
	
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
	
}
