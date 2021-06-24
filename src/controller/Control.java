package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import buildings.EconomicBuilding;
import buildings.*;
import engine.*;
import exceptions.NotEnoughGoldException;
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
	private ActionListener farmblistener;
	
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
	Cityview = new MyFrame();
	farmblistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				lnkfarmb();
			} catch (NotEnoughGoldException e1) {
				e1.getMessage();
			}
		}
	};
	Cityview.Getfarmb().addActionListener(farmblistener);
	}

	public void lnkfarmb() throws NotEnoughGoldException {
		try {
		player.build("Farm", cityname);
		Cityview.add(Cityview.getFarm());
		Cityview.add(Cityview.getFarmpicture());
		Cityview.getFarml().setVisible(false);
		
		JLabel tre = new JLabel();
		tre.setText(""+player.getTreasury());
		
		tre.setSize(tre.getPreferredSize().width ,tre.getPreferredSize().height);
		
		tre.setBounds(1000 , 100 , tre.getSize().width,tre.getSize().height);
		Cityview.add(tre);
		
		
		Cityview.getFarmb().setVisible(false);
		
		
		Cityview.repaint();
		
		}
		catch(NotEnoughGoldException e) {
			System.out.println(e.getMessage());
			
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
