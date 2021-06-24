package controller;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buildings.EconomicBuilding;
import buildings.*;
import engine.*;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import units.Army;
import view.*;


public class Control {
	private Game game ;
	private Player player ;
	private JLabel food ;
	private JLabel money;
	private JLabel turncount;
	private JLabel name ;
	private StartingWindow startingwindow;
	private MainWindow mainwindow;
	private ChooseCityWindow choosecity;
	private WorldMapView mapview ;
	private String cityname ;
	private MyFrame maincityview ;
	private ActionListener farmblistener;
	private ActionListener farmulistener;
	private ActionListener marketblistener ;
	private ActionListener archerrlistener;
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
	food = new JLabel();
	money = new JLabel();
	turncount = new JLabel();
	name = new JLabel();
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
	name.setText("Player : "+ player.getName() + " " +cityname);
	name.setSize(name.getPreferredSize().width , name.getPreferredSize().height);
	name.setBounds(1000 , 300 , name.getSize().width , name.getSize().height);
	food.setText(player.getFood() + "");
	money.setText("Money : " + player.getTreasury()+"  ");
	money.setSize(name.getPreferredSize().width , name.getPreferredSize().height);
	money.setBounds(1000 , 400 , name.getSize().width , name.getSize().height);
	turncount.setText("Turns : "+ game.getCurrentTurnCount()+"/50  ");
		
	
	player.setTreasury(5000);
	lnkMainWindow();
	player.getControlledArmies().add(new Army(cityname) );
	//player.getControlledArmies().add(new Army(cityname) );
	mapview = new WorldMapView(player.getControlledArmies()) ;
	mapview.setAvailablecities(game.getAvailableCities());
	maincityview = new MyFrame(cityname);
	maincityview.add(name);
	
	// 					Archer recruit Button Listener
	archerrlistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				lnkarcherr(maincityview.getCityName());
			}catch (BuildingInCoolDownException e1) {
				
				showMessageDialog(null, e1.getMessage());
			} catch (NotEnoughGoldException e1) {
				
				showMessageDialog(null, e1.getMessage());
			} catch (MaxRecruitedException e1) {
				showMessageDialog(null,e1.getMessage());
			}
			}
	};
	maincityview.getArcherr().addActionListener(archerrlistener);
	
	//						Farm upgrade Listener
	farmulistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				lnkfarmu(maincityview.getCityName());
			}catch (BuildingInCoolDownException e1) {
				
				e1.getMessage();
			} catch (MaxLevelException e1) {
				
				e1.getMessage();
			} catch (NotEnoughGoldException e1) {
				
				e1.getMessage();
			}
			}
	};
	maincityview.getFarm().addActionListener(farmulistener);
	
	//				Farm Build Listener
	farmblistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				lnkfarmb(maincityview.getCityName());
			} catch (NotEnoughGoldException e1) {
				e1.getMessage();
			}
		}
	};
	maincityview.Getfarmb().addActionListener(farmblistener);
	
	//			Market build Listener
	marketblistener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                lnkmarketb();
            } catch (NotEnoughGoldException e1) {
                e1.getMessage();
            }
        }
    };
    maincityview.getMarketb().addActionListener(marketblistener);
    
    
    }

	
	public void lnkfarmb(String city) throws NotEnoughGoldException {
		try {
		if(maincityview.getCityName().equals(city)) {
		player.build("Farm", city);
		showMessageDialog(null, "You built a farm !");
		maincityview.add(maincityview.getFarm());
		maincityview.add(maincityview.getFarmpicture());
		maincityview.getFarml().setVisible(false);
		
		money.setText(""+player.getTreasury());
		maincityview.getFarmlvl().setText("LVL 1");
		maincityview.getFarmlvl().setSize(maincityview.getFarmlvl().getPreferredSize().width ,maincityview.getFarmlvl().getPreferredSize().height );
		maincityview.getFarmlvl().setBounds(150 , 20 , maincityview.getFarmlvl().getSize().width,maincityview.getFarmlvl().getSize().height);
		maincityview.add(maincityview.getFarmlvl());
		maincityview.add(money);
		
		
		maincityview.getFarmb().setVisible(false);
		
		
		maincityview.repaint();
		}
		}
		catch(NotEnoughGoldException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void lnkfarmu(String city ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		if(maincityview.getCityName().equals(city)) {
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(city)) {
				for(EconomicBuilding b : c.getEconomicalBuildings()) {
					if(b instanceof Farm) {
					try {
					b.setCoolDown(false);
					player.upgradeBuilding(b);
					System.out.println("aaaa");
					maincityview.getFarmlvl().setText("LVL " + b.getLevel());
					maincityview.add(maincityview.getFarmlvl());
					maincityview.getFarm().setText("Upgrade " + b.getUpgradeCost());
					money.setText(""+player.getTreasury());
					maincityview.add(money);
					maincityview.repaint();
					}
					catch(NotEnoughGoldException e){
						
						showMessageDialog(null, "Not enough gold ");
					}
					catch(BuildingInCoolDownException e) {
						showMessageDialog(null, "build in cooldown");
					}
					catch(MaxLevelException e) {
						showMessageDialog(null, "This building is already lvl 3");
					}
					}
					}
			}
		}
		}
	}
	
	public void lnkmarketb() throws NotEnoughGoldException {
        try {
        
        player.build("Market", cityname);
        maincityview.add(maincityview.getMarket());
        //maincityview.add(maincityview.getMarketpicture());
        maincityview.getMarl().setVisible(false);
        money.setText(""+player.getTreasury());
        maincityview.add(money);


        maincityview.getMarketb().setVisible(false);


        maincityview.repaint();

        }
        catch(NotEnoughGoldException e) {
        	showMessageDialog(null, e.getMessage());

        }
	}
	
	public void lnkarcherr(String city) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		
		player.recruitUnit("archer", city);
		showMessageDialog(null, "You rectuited an archer !");
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
