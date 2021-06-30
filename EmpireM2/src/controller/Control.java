package controller;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import buildings.EconomicBuilding;
import buildings.*;
import engine.*;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;
import view.*;


public class Control implements ActionListener{
	private int d =0 ;
	
	private Game game ;
	private City maincity ;
	private Player player ;
	private JLabel food ;
	private JLabel money;
	private JLabel turncount;
	private JLabel name ;
	private StartingWindow startingwindow;
	private MainWindow mainwindow;
	private ChooseCityWindow choosecity;
	private WorldMapView mapview ;
	private BattleView battleview ;
	private String cityname ;
	private MyFrame cairoview ;
	private MyFrame romeview ;
	private MyFrame spartaview;
	private ActionListener farmblistener;
	private ActionListener farmulistener;
	private ActionListener marketblistener ;
	private ActionListener archerrlistener;
	private ActionListener enterlistener;
	private ActionListener chooselistener;
	private ActionListener viewmaplistener ;
	private ActionListener viewcitylistener ;
	private ActionListener archerblistener;
	private ActionListener archerulistener;
	private ActionListener marketulistener;
	private ActionListener backlistener ;
	private ActionListener endlistener ;
	private ActionListener stableblistener;
	private ActionListener stableulistener;
	private ActionListener barblistener ;
	private ActionListener barulistener;
	private ActionListener barrlistener;
	private ActionListener stablerlistener , chooseunit , chooseunitdef , initiateListener,relocatelistener,targetcitylistener;
	public int idxarmy ,idxdefarmy;
	ArrayList<Army> idlearmies = new ArrayList<Army>();
	ArrayList<Army> marchingarmies = new ArrayList<Army>();
	ArrayList<Army> bearmies = new ArrayList<Army>();
	public Control() throws IOException {
		
	// 					Starting window
	startingwindow = new StartingWindow();
	enterlistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				lnkenter();
			} catch (IOException e1) {
				
				showMessageDialog(null, e1.getMessage());
			}}};
	startingwindow.getButton().addActionListener(enterlistener);
	
	
    }

	
	public void lnkfarmb(MyFrame maincityview) throws NotEnoughGoldException {
		
		
		player.build("Farm", maincityview.getCityName());
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
		
		refreshmain();
		maincityview.repaint();
		
		
		
		
	}
	
	public void lnkfarmu(MyFrame maincityview ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(maincityview.getCityName())) {
				for(EconomicBuilding b : c.getEconomicalBuildings()) {
					if(b instanceof Farm) {
					
					player.upgradeBuilding(b);
					
					maincityview.getFarmlvl().setText("LVL " + b.getLevel());
					maincityview.add(maincityview.getFarmlvl());
					maincityview.getFarm().setText("Upgrade " + b.getUpgradeCost());
					money.setText(""+player.getTreasury());
					maincityview.add(money);
					refreshmain();
					maincityview.repaint();
					
					
					}
					
			}
		}
		}
	}
	
	public void lnkmarketb(MyFrame maincityview) throws NotEnoughGoldException {
        
        player.build("Market", cityname);
        maincityview.add(maincityview.getMarket());
        maincityview.add(maincityview.getMarketpicture());
        maincityview.getMarl().setVisible(false);
        maincityview.getMarketlvl().setText("LVL1");
        maincityview.getMarketlvl().setBounds(400 , 20 , maincityview.getMarketlvl().getPreferredSize().width,maincityview.getMarketlvl().getPreferredSize().height);
        maincityview.add(maincityview.getMarketlvl());
        money.setText(""+player.getTreasury());
        maincityview.add(money);

        refreshmain();
        maincityview.getMarketb().setVisible(false);


        maincityview.repaint();

        
        
	}
	
	public void lnkmarketu(MyFrame maincityview ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(maincityview.getCityName())) {
				for(EconomicBuilding b : c.getEconomicalBuildings()) {
					if(b instanceof Market) {
					
					
					player.upgradeBuilding(b);
					maincityview.getMarketlvl().setText("LVL " + b.getLevel());
					maincityview.getMarketlvl().setSize(maincityview.getMarketlvl().getPreferredSize().width ,maincityview.getMarketlvl().getPreferredSize().height  );
					maincityview.add(maincityview.getMarketlvl());
					maincityview.getMarket().setText("Upgrade " + b.getUpgradeCost());
					money.setText(""+player.getTreasury());
					maincityview.add(money);refreshmain();
					maincityview.repaint();
					
					}
					}
			}
		}
		
	}
		
		
	public void lnkarcherb(MyFrame maincityview) throws NotEnoughGoldException {
		
		
		player.build("archeryrange", maincityview.getCityName());

		showMessageDialog(null, "You built a archeryrange !");
		maincityview.add(maincityview.getArcher());
		maincityview.add(maincityview.getArcherpicture());
		maincityview.add(maincityview.getArcherr());
		maincityview.getMarl().setVisible(false);
		
		money.setText(""+player.getTreasury());
		maincityview.getArcherlvl().setText("LVL 1");
		maincityview.getArcherlvl().setSize(maincityview.getArcherlvl().getPreferredSize().width ,maincityview.getArcherlvl().getPreferredSize().height );
		maincityview.getArcherlvl().setBounds(400 , 400 , maincityview.getArcherlvl().getSize().width,maincityview.getArcherlvl().getSize().height);
		maincityview.add(maincityview.getArcherlvl());
		maincityview.add(money);


		maincityview.getArcherb().setVisible(false);

		refreshmain();
		maincityview.repaint();
		

		}
	
	public void lnkarcheru(MyFrame maincityview ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(maincityview.getCityName())) {
				for(MilitaryBuilding b : c.getMilitaryBuildings()) {
					if(b instanceof ArcheryRange) {
					player.upgradeBuilding(b);
					
					maincityview.getArcherlvl().setText("LVL " + b.getLevel());
					maincityview.add(maincityview.getArcherlvl());
					maincityview.getArcher().setText("Upgrade " + b.getUpgradeCost());
					money.setText(""+player.getTreasury());
					maincityview.getArcherr().setText("recruit " + b.getRecruitmentCost());
					maincityview.add(money);
					maincityview.repaint();
					refreshmain();
					
					
					}
					}
			
		}
		}
		}
	public void lnkarcherr(MyFrame maincityview) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		
		player.recruitUnit("archer", maincityview.getCityName());
		money.setText("Money : " + player.getTreasury());
		maincityview.add(money);
		maincityview.repaint();
		//maincityview.add(maincityview.getInitiatearmy());
		//maincityview.add(maincityview.getRelocateunit());
		
		maincityview.getInitiatearmy().setVisible(true);
		
		
		refreshmain();
		refreshdefending(maincityview);
		refreshmapview();
		showMessageDialog(null, "You rectuited an archer !");
		
	}
	public void lnkinitiate(MyFrame maincityview) {
		String [] response = {"Archer Unit" , "Cavalry Unit" , "Infantry Unit"};
		int choice = JOptionPane.showOptionDialog(null,
				"Choose Unit to initiate army with ", "meows", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, response, 0);
		City city = new City(maincityview.getCityName());
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(maincityview.getCityName())) {
				city = c;
			}
		}
		
		
		if(choice == 0) {
			
			System.out.println("kam unit : " + city.getDefendingArmy().getUnits().size());
			for(int i =0 ; i < city.getDefendingArmy().getUnits().size();i++) {
	
				if(city.getDefendingArmy().getUnits().get(i) instanceof Archer) {
					player.initiateArmy(city, city.getDefendingArmy().getUnits().get(i));
					refreshdefending(maincityview);
					showMessageDialog(null, "initiated an army with archer unit :D");
				}
			}
			
		}
		else if(choice ==1 ) {
			for(Unit a : city.getDefendingArmy().getUnits()) {
				if(a instanceof Cavalry && a.getCurrentSoldierCount() !=0) {
					player.initiateArmy(city, a);
				}
			}
		}
		else if(choice == 2) {
			for(Unit a : city.getDefendingArmy().getUnits()) {
				if(a instanceof Infantry) {
					player.initiateArmy(city, a);
				}
			}
		}
		refreshmapview();
	}
	
	public void lnkstableb(MyFrame maincityview) throws NotEnoughGoldException {
		
	    	player.build("Stable", maincityview.getCityName());
	    	maincityview.add(money);
	    	money.setText(""+player.getTreasury());
			maincityview.add(money);
	    	showMessageDialog(null, "You built a Stable !");
	    	maincityview.add(maincityview.getStable());
	    	maincityview.add(maincityview.getStablepicture());
	    	maincityview.getStal().setVisible(false);
	    	maincityview.getStableb().setVisible(false);

	    	money.setText(""+player.getTreasury());
	    	maincityview.getStablelvl().setText("LVL 1");
	    	maincityview.getStablelvl().setSize(maincityview.getStablelvl().getPreferredSize().width ,maincityview.getStablelvl().getPreferredSize().height );
	    	maincityview.getStablelvl().setBounds(550 , 350 , maincityview.getStablelvl().getSize().width,maincityview.getStablelvl().getSize().height);
	    	maincityview.add(maincityview.getStablelvl());
	    	maincityview.add(money);
	    	maincityview.getStable().setText("Upgrade 1500");
	    	maincityview.getStabler().setText("recruit 600");
	    	maincityview.add(maincityview.getStabler());
	    	maincityview.add(maincityview.getStable());
	    	maincityview.getStableb().setVisible(false);

	    	refreshmain();
	    	maincityview.repaint();
	    	
	}
	
	
	public void lnkstableu(MyFrame maincityview ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
	
	for(City c : player.getControlledCities()) {
	if(c.getName().equals(maincityview.getCityName())) {
		for(MilitaryBuilding b : c.getMilitaryBuildings()) {
			if(b instanceof Stable) {
			
			b.setCoolDown(false);
			player.upgradeBuilding(b);
			money.setText(""+player.getTreasury());
			maincityview.add(money);
		
			maincityview.getStablelvl().setText("LVL " + b.getLevel());
			maincityview.add(maincityview.getStablelvl());
			maincityview.getStable().setText("Upgrade " + b.getUpgradeCost());
			money.setText(""+player.getTreasury());
			maincityview.add(money);
	    	maincityview.getStabler().setText("recruit " + b.getRecruitmentCost());
			
			maincityview.repaint();
			refreshmain();
			}
			}
	}
	}
	}
						//  barracks build method 
	
	public void lnkbarb(MyFrame maincityview) throws NotEnoughGoldException {

		player.build("Barracks", maincityview.getCityName());
		showMessageDialog(null, "You built a barracks !");
		maincityview.add(maincityview.getBar());
		maincityview.add(maincityview.getBarpicture());
		maincityview.getBarl().setVisible(false);
		maincityview.add(money);

		money.setText(""+player.getTreasury());
		maincityview.getBarlvl().setText("LVL 1");
		maincityview.getBarlvl().setSize(maincityview.getBarlvl().getPreferredSize().width ,maincityview.getBarlvl().getPreferredSize().height );
		maincityview.getBarlvl().setBounds(150 , 350 , maincityview.getBarlvl().getSize().width,maincityview.getBarlvl().getSize().height);
		maincityview.add(maincityview.getBarlvl());
		maincityview.add(money);
		maincityview.getBar().setText("Upgrade 1000");
		maincityview.add(maincityview.getBar());
		maincityview.getBarr().setText("Recruit 500");
		maincityview.add(maincityview.getBarr());
		maincityview.getBarb().setVisible(false);


		maincityview.repaint();
		
		refreshmain();

		}
   				//				 --- barracks upgrade method --
	
	public void lnkbaru(MyFrame maincityview ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(maincityview.getCityName())) {
				for(MilitaryBuilding b : c.getMilitaryBuildings()) {
					if(b instanceof Barracks) {
					
					b.setCoolDown(false);
					player.upgradeBuilding(b);
					money.setText(""+player.getTreasury());
					maincityview.add(money);
				    //System.out.println("upgrade bar");
					maincityview.getBarlvl().setText("LVL " + b.getLevel());
					maincityview.add(maincityview.getBarlvl());
					maincityview.getBar().setText("Upgrade " + b.getUpgradeCost());
					maincityview.getBarr().setText("recruit " + b.getRecruitmentCost());
					
					maincityview.repaint();
					refreshmain();
					}
				}}}
			
		}
	// ========================================================= end of barracks build and upgrade ==============================================================================

	
	//-------------------------------------barracks recrit method   -------------------------------------------

	public void lnkbarr(MyFrame maincityview) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {

	            player.recruitUnit("Infantry", maincityview.getCityName());
	    		maincityview.repaint();
	    		refreshmain();
	    		refreshdefending(maincityview);
	            showMessageDialog(null, "You rectuited an Infantry !");
	            
	        }
	//----------------------------------------------------------------------------------
	
	
	// ====================stable  listener method ========================
	public void lnkstabler(MyFrame maincityview) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
					
					player.recruitUnit("Cavalry", maincityview.getCityName());
					maincityview.repaint();
		    		refreshmain();
		    		refreshdefending(maincityview);
					showMessageDialog(null, "You rectuited an stable !");}
	
	
	
	public void lnkenter() throws IOException {
		
		if(startingwindow.getNameText().equals("")) {
			showMessageDialog(null, "enter a valid name < non empty >");
		}
		else {
		//player = new Player(startingwindow.getNameText());
		food = new JLabel();
		money = new JLabel();
		turncount = new JLabel();
		name = new JLabel();
		choosecity= new ChooseCityWindow();
		startingwindow.dispose();
		
		
		
		chooselistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lnkchoose();
				if(e.getSource() == choosecity.getRome()) {
					try {
						pickedcity("Rome");
					} catch (IOException e1) {
						
						showMessageDialog(null,e1.getMessage());
					}
				}
				if(e.getSource() == choosecity.getCairo()) {
					try {
						pickedcity("Cairo");
					} catch (IOException e1) {
						
						showMessageDialog(null,e1.getMessage());
					}
				}
				if(e.getSource() == choosecity.getSparta()) {
					try {
						pickedcity("Sparta");
					} catch (IOException e1) {
						
						showMessageDialog(null,e1.getMessage());
					}
				}
			}
		};
		
		choosecity.getRome().addActionListener(chooselistener);
		choosecity.getCairo().addActionListener(chooselistener);
		choosecity.getSparta().addActionListener(chooselistener);

		
		}
	}
	
	public void pickedcity(String s) throws IOException {
		
		cityname = s;
		maincity = new City(cityname);
		//player.getControlledCities().add(maincity);
		game = new Game(startingwindow.getNameText() ,cityname);
		player = game.getPlayer();
		
		
		cairoview = new MyFrame("Cairo");
		cairoview.setVisible(false);
		cairoview.add(name);
		
		romeview = new MyFrame("Rome");
		romeview.setVisible(false);
		
		spartaview = new MyFrame("Sparta");
		spartaview.setVisible(false);
		
		choosecity.dispose();
		if(s.equals("Rome"))
			lnkopenmainwindow(romeview);
		else if(s.equals("Cairo"))
			lnkopenmainwindow(cairoview);
		else if(s.equals("Sparta"))
			lnkopenmainwindow(spartaview);
	}
	public void lnkopenmainwindow(MyFrame maincityview)  {
		
		mainwindow = new MainWindow();
		name.setText("Player : "+ player.getName() + " " +cityname);
		name.setSize(name.getPreferredSize().width , name.getPreferredSize().height);
		name.setBounds(1000 , 300 , name.getSize().width , name.getSize().height);
		food.setText(player.getFood() + "");
		money.setText("Money : " + player.getTreasury()+"  ");
		money.setSize(name.getPreferredSize().width , name.getPreferredSize().height);
		money.setBounds(1000 , 400 , name.getSize().width , name.getSize().height);
		turncount.setText("Turns : "+ game.getCurrentTurnCount()+"/50  ");
		
		//player.setTreasury(5000);
		viewcity(cairoview);
		viewcity(romeview);
		viewcity(spartaview);
		lnkMainWindow();
		//player.getControlledArmies().add(new Army(cityname) );
		/*try {
		player.build("ArcheryRange", cityname);
		player.getControlledCities().get(0).getMilitaryBuildings().get(0).setCoolDown(false);}
		catch(NotEnoughGoldException e) {
			showMessageDialog(null, e.getMessage());
		}*/
		refreshmain();
		viewmaplistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewmap();
			}
		};
		mainwindow.getMap().addActionListener(viewmaplistener);
		
		endlistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					lnkendturn(maincityview);
				} catch (TargetNotReachedException | FriendlyCityException | FriendlyFireException e1) {
					
					showMessageDialog(null, e1.getMessage());
				}
			}
		};
		mainwindow.getEndturn().addActionListener(endlistener);
	}
	
	//						VIEW MAP
	public void viewmap() {
		mapview = new WorldMapView(player.getControlledArmies()) ;
		mapview.setAvailablecities(game.getAvailableCities());
		viewcitylistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList <String > ava = new ArrayList <String >();
				for(City c : player.getControlledCities()) {
					ava.add(c.getName());
				}
				if(e.getSource() == mapview.getRome() && ava.contains("Rome")) {
					romeview.setVisible(true);
					lnkback();}
				if(e.getSource() == mapview.getCairo() && ava.contains("Cairo")) {
					cairoview.setVisible(true);
					lnkback();
			}
				if(e.getSource() == mapview.getSparta() && ava.contains("Sparta")) {
					spartaview.setVisible(true);
					lnkback();}
				else if(e.getSource() == mapview.getBack()) {
					lnkback();
				}
				
			}
			
		};
		mapview.getCairo().addActionListener(viewcitylistener);
		mapview.getRome().addActionListener(viewcitylistener);
		mapview.getSparta().addActionListener(viewcitylistener);
		mapview.getBack().addActionListener(viewcitylistener);
		
		relocatelistener = new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mapview.getRelocatei()) {
					try {
						lnkrelocatei();
					} catch (MaxCapacityException e1) {
						
						showMessageDialog(null, e1.getMessage());
					}
				}
				else if(e.getSource() == mapview.getRelocateb()) {
					try {
						lnkrelocateb();
					} catch (MaxCapacityException e1) {
						
						showMessageDialog(null, e1.getMessage());
					}
				}
				else if(e.getSource() == mapview.getRelocatem()) {
					try {
						lnkrelocatem();
					} catch (MaxCapacityException e1) {
						
						showMessageDialog(null, e1.getMessage());
					}
				}
			}
			
		};
		mapview.getRelocatei().addActionListener(relocatelistener);
		
		targetcitylistener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lnkcitytarget();
				
			}
			
		};
		mapview.getTargetcity().addActionListener(targetcitylistener);
	}
	
	
	public void viewcity(MyFrame maincityview) {
		//maincityview = new MyFrame(cityname);
		//maincityview.add(name);
		
		
		//if(cityn.equals(maincityview.getCityName().toLowerCase())) {
		//	maincityview.setVisible(true);
		//}
		
		maincityview.add(maincityview.getDefending());
		maincityview.add(maincityview.getArmy());
		
		//				Back
		backlistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lnkbackcity(maincityview);
			}
		};
		maincityview.getBack().addActionListener(backlistener);
		//				 Archer build
		archerblistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lnkarcherb(maincityview);
					//refreshmain();
				} catch (NotEnoughGoldException e1) {
					showMessageDialog(null,e1.getMessage());
				}
			}
			};
			maincityview.getArcherb().addActionListener(archerblistener);
			
		//			Archer Recruit
		archerrlistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lnkarcherr(maincityview);
					//refreshmain();
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
					lnkfarmu(maincityview);
					//refreshmain();
				}catch (BuildingInCoolDownException e1) {
					
					showMessageDialog(null,e1.getMessage());
				} catch (MaxLevelException e1) {
					
					showMessageDialog(null,e1.getMessage());
				} catch (NotEnoughGoldException e1) {
					
					showMessageDialog(null,e1.getMessage());
				}
				}
		};
		maincityview.getFarm().addActionListener(farmulistener);
		
		//				Farm Build Listener
		farmblistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lnkfarmb(maincityview);refreshmain();
				} catch (NotEnoughGoldException e1) {
					showMessageDialog(null,e1.getMessage());}
			}
		};
		maincityview.Getfarmb().addActionListener(farmblistener);
		
		//			Market build Listener
		marketblistener = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                lnkmarketb(maincityview);refreshmain();
	            } catch (NotEnoughGoldException e1) {
	            	showMessageDialog(null,e1.getMessage());
	            }
	        }
	    };
	    maincityview.getMarketb().addActionListener(marketblistener);
	    
	    //				market upgrade 
	    marketulistener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			lnkmarketu(maincityview);
	    		}catch (BuildingInCoolDownException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		} catch (MaxLevelException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		} catch (NotEnoughGoldException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		}
	    		}
	    };
	    maincityview.getMarket().addActionListener(marketulistener);	
	    
	    //						 archer upgrade
	    
	    archerulistener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    			try {
						lnkarcheru(maincityview);
					} catch (BuildingInCoolDownException e1) {
		    			
		    			showMessageDialog(null,e1.getMessage());
		    		} catch (MaxLevelException e1) {
		    			
		    			showMessageDialog(null,e1.getMessage());
		    		} catch (NotEnoughGoldException e1) {
		    			
		    			showMessageDialog(null,e1.getMessage());
		    		}
	    			
	    		}
	    	};
	    	maincityview.getArcher().addActionListener(archerulistener);
	    
	    	// 		Stable Build 
	    	stableblistener = new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    	try {
		    		lnkstableb(maincityview);
		    	} catch (NotEnoughGoldException e1) {
		    		showMessageDialog(null,e1.getMessage());
		    	}
		    	}
		    	};
		    	maincityview.getStableb().addActionListener(stableblistener);

		    	stableulistener = new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    	try {
			    		lnkstableu(maincityview);
			    	}catch (BuildingInCoolDownException e1) {
			    		
			    		showMessageDialog(null,e1.getMessage());
			    	} catch (MaxLevelException e1) {
			    		
			    		showMessageDialog(null,e1.getMessage());
			    	} catch (NotEnoughGoldException e1) {
			    		
			    		showMessageDialog(null,e1.getMessage());
			    	}
			    	}
			    	};
			    	
			    	maincityview.getStable().addActionListener(stableulistener);
			    	
			    	barulistener = new ActionListener() {
			    		public void actionPerformed(ActionEvent e) {
			    			try {
			    				lnkbaru(maincityview);
			    			}catch (BuildingInCoolDownException e1) {
			    				
			    				showMessageDialog(null,e1.getMessage());
			    			} catch (MaxLevelException e1) {
			    				
			    				showMessageDialog(null,e1.getMessage());
			    			} catch (NotEnoughGoldException e1) {
			    				
			    				showMessageDialog(null,e1.getMessage());
			    			}
			    			}
			    		};
			    		maincityview.getBar().addActionListener(barulistener);

//			    					barracks Build Listener
			    		barblistener = new ActionListener() {
			    		public void actionPerformed(ActionEvent e) {
			    			try {
			    				lnkbarb(maincityview);
			    			} catch (NotEnoughGoldException e1) {
			    				showMessageDialog(null,e1.getMessage());
			    			}
			    		}
			    		};
			    		maincityview.getBarb().addActionListener(barblistener);
			    		
//			          bar recruit Button Listener
			    		barrlistener = new ActionListener() {
			    		public void actionPerformed(ActionEvent e) {
			    		try {
			    		lnkbarr(maincityview);
			    		}catch (BuildingInCoolDownException e1) {

			    		showMessageDialog(null, e1.getMessage());
			    		} catch (NotEnoughGoldException e1) {

			    		showMessageDialog(null, e1.getMessage());
			    		} catch (MaxRecruitedException e1) {
			    		showMessageDialog(null,e1.getMessage());
			    		}
			    		}
			    	};
			    		maincityview.getBarr().addActionListener(barrlistener);
			    		
			    		// ==================== stable listner recruit ================================

			    		stablerlistener = new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				try {
			    					lnkstabler(maincityview);	
			    				}catch (BuildingInCoolDownException e1) {
			    					
			    					showMessageDialog(null, e1.getMessage());
			    				} catch (NotEnoughGoldException e1) {
			    					
			    					showMessageDialog(null, e1.getMessage());
			    				} catch (MaxRecruitedException e1) {
			    					showMessageDialog(null,e1.getMessage());
			    				}
			    				}
			    		};
			    		maincityview.getStabler().addActionListener(stablerlistener);
			    		
			    		
			    		initiateListener = new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				if(e.getSource() ==maincityview.getInitiatearmy())
			    				lnkinitiate(maincityview);
			    			}
			    			
			    		};
			    		
			    		maincityview.getInitiatearmy().addActionListener(initiateListener);
	
			    		
			    		/*
			    		relocatelistener = new ActionListener() {

							
							public void actionPerformed(ActionEvent e) {
								if(e.getSource() == mapview.getRelocatei()) {
									try {
										lnkrelocatei();
									} catch (MaxCapacityException e1) {
										
										showMessageDialog(null, e1.getMessage());
									}
								}
							}
			    			
			    		};
			    		mapview.getRelocatei().addActionListener(relocatelistener);
			    		*/
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
	public void refreshmain() {
		mainwindow.getMoney().setText("Money " + player.getTreasury());
		mainwindow.getFood().setText("Food " + player.getFood());
		mainwindow.getTurncount().setText("Turns : "+ game.getCurrentTurnCount()+"/50  ");
		mainwindow.repaint();
		
	}
	public void lnkcitytarget() {
		String [] response = {"Idle" , "besiege" , "marching"};
		String [] cityres = {"Cairo","Rome","Sparta"};
		int choice = JOptionPane.showOptionDialog(null,
				"which type of army", "meows", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, response, 0);
		int idxarmy =0;
		if(choice == 0) {
			idxarmy = Integer.parseInt(JOptionPane.showInputDialog("index of the army to send"));
			
			Army toarmy = idlearmies.get(idxarmy);
			
			int c2 = JOptionPane.showOptionDialog(null,
					"which city to target", "meows", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, cityres, 0);
			if(c2==0)
				game.targetCity(toarmy, "Cairo");
			else if(c2 == 1)
				game.targetCity(toarmy, "Rome");
			else if(c2 == 2)
				game.targetCity(toarmy, "Sparta");
		}
		
		else if(choice ==1) {
idxarmy = Integer.parseInt(JOptionPane.showInputDialog("index of the army to send"));
			
			Army toarmy = bearmies.get(idxarmy);
			
			int c2 = JOptionPane.showOptionDialog(null,
					"which city to target", "meows", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, cityres, 0);
			if(c2==0)
				game.targetCity(toarmy, "Cairo");
			else if(c2 == 1)
				game.targetCity(toarmy, "Rome");
			else if(c2 == 2)
				game.targetCity(toarmy, "Sparta");
		}
		
		else if(choice ==2) {
idxarmy = Integer.parseInt(JOptionPane.showInputDialog("index of the army to send"));
			
			Army toarmy = marchingarmies.get(idxarmy);
			
			int c2 = JOptionPane.showOptionDialog(null,
					"which city to target", "meows", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, cityres, 0);
			if(c2==0)
				game.targetCity(toarmy, "Cairo");
			else if(c2 == 1)
				game.targetCity(toarmy, "Rome");
			else if(c2 == 2)
				game.targetCity(toarmy, "Sparta");
		}
	}
	
	
	public void lnkrelocatei() throws MaxCapacityException {
		JTextField t = new JTextField();
		t.setSize(100 , 20);
		String [] response = {"Idle" , "besiege" , "marching"};

		int idxfrom = Integer.parseInt(JOptionPane.showInputDialog("index of army to relocate from"));
		int idxunitfrom = Integer.parseInt(JOptionPane.showInputDialog("index of unit to relocate from"));
		int choice = JOptionPane.showOptionDialog(null,
				"which type of army to ", "meows", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, response, 0);
		int idxto =0 ;
		if(choice == 0) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = idlearmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from idle to idle");
		}
		
		else if(choice == 1) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = bearmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from idle to besiege");
		}
		else if(choice ==2) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = marchingarmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from idle to marching");
		}
		
		refreshmapview();
	}
	
	public void lnkrelocateb() throws MaxCapacityException {
		JTextField t = new JTextField();
		t.setSize(100 , 20);
		String [] response = {"Idle" , "besiege" , "marching"};

		int idxfrom = Integer.parseInt(JOptionPane.showInputDialog("index of army to relocate from"));
		int idxunitfrom = Integer.parseInt(JOptionPane.showInputDialog("index of unit to relocate from"));
		int choice = JOptionPane.showOptionDialog(null,
				"which type of army to ", "meows", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, response, 0);
		int idxto =0 ;
		if(choice == 0) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = idlearmies.get(idxto);
			
			Unit fromunit = bearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from siege to idle");
		}
		
		else if(choice == 1) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = bearmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from siege to besiege");
		}
		else if(choice ==2) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = marchingarmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from siege to marching");
		}
		
		refreshmapview();
	}
	
	public void lnkrelocatem() throws MaxCapacityException {
		JTextField t = new JTextField();
		t.setSize(100 , 20);
		String [] response = {"Idle" , "besiege" , "marching"};

		int idxfrom = Integer.parseInt(JOptionPane.showInputDialog("index of army to relocate from"));
		int idxunitfrom = Integer.parseInt(JOptionPane.showInputDialog("index of unit to relocate from"));
		int choice = JOptionPane.showOptionDialog(null,
				"which type of army to ", "meows", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, response, 0);
		int idxto =0 ;
		if(choice == 0) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = idlearmies.get(idxto);
			
			Unit fromunit = marchingarmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from marching to idle");
		}
		
		else if(choice == 1) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = bearmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from marching to besiege");
		}
		else if(choice ==2) {
			idxto = Integer.parseInt(JOptionPane.showInputDialog("index of the army to relocate to"));
			
			Army toarmy = marchingarmies.get(idxto);
			
			Unit fromunit = idlearmies.get(idxfrom).getUnits().get(idxunitfrom);
			toarmy.relocateUnit(fromunit);
			showMessageDialog(null, "you relocated unit from marching to marching");
		}
		
		refreshmapview();
	}
	public void lnkback() {
		mapview.setVisible(false);
	}
	
	public void lnkbackcity(MyFrame maincityview) {
		maincityview.setVisible(false);
	}
	
	public void lnkendturn(MyFrame maincityview) throws TargetNotReachedException, FriendlyCityException, FriendlyFireException {
		
		
		game.endTurn();
		if(game.getCurrentTurnCount() == 51) {
			if(player.getControlledCities().size() == 3) {
				showMessageDialog(null,"You won wooo" );
			}
			else
				showMessageDialog(null,"LOST" );
			mainwindow.dispose();
		}
		if(player.getControlledCities().size() == 3) {
			showMessageDialog(null,"You won wooo" );
			maincityview.dispose();
		}
		String []response = {"Attack defending army" , "Lay Siege the city" }; 
		for(Army a : player.getControlledArmies()) {
			for(City city : game.getAvailableCities()) {
				if(a.getCurrentLocation().equals(city.getName()) && !player.getControlledCities().contains(city)) {
					battleview = new BattleView();
					ActionListener b = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							battleview.setVisible(false);
							
						}
						
					};
					battleview.getBack().addActionListener(b);
					battleview.add(battleview.getBack());
					
					String mess =  "Your army reached " + a.getTarget() + "what now ?"; 
					int choice = JOptionPane.showOptionDialog(null, mess, "secret", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, response, 0);
					//System.out.println(choice);
					if(choice == 0 ) {
						autoOrAttack(a , city.getDefendingArmy(),true);
					}
					else if(choice == 1) {
						player.laySiege(a, city);
					}
				}
			}
		}
		
		refreshmain();
		refreshdefending(maincityview);
		
	}
	
	public void autoOrAttack(Army attacker , Army defender , boolean t) throws FriendlyFireException{
		
		boolean turns =t ;
		String [] response  ={"Attack manually" , "Random choose of 2 units" } ;
		int choice = JOptionPane.showOptionDialog(null, "Attacking defending army", "secret", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, response, 0);
		if(choice == 0) {
			//while (attacker.getUnits().size() != 0 && defender.getUnits().size() != 0) {
			ArrayList<String> myarmy = new ArrayList <String>();
			ArrayList<Unit> myarmyunits = new ArrayList<Unit>();
			ArrayList<String> defarmy = new ArrayList <String>();
			for(Unit u : attacker.getUnits()) {
				String[] s =u.getClass().toString().split("\\."); 
				String add = "";
				add += "Unit " + s[1] +" | ";
				add += "Level" + u.getLevel() + " | ";
				add += "Current soldier count : " + u.getCurrentSoldierCount() + " | "
						+ "";
				myarmy.add(add);
			}
			
			for(Unit u : defender.getUnits()) {
				String[] s =u.getClass().toString().split("\\."); 
				String add = "";
				add += "Unit " + s[1] +" | ";
				add += "Level" + u.getLevel() + " | ";
				add += "Current soldier count : " + u.getCurrentSoldierCount() + " | "
						+ "";
				defarmy.add(add);
			}
			
			System.out.println("aa");
			String[] myarmyarray = myarmy.toArray(new String[0]);
			String[] defarmyarray = defarmy.toArray(new String[0]);
			
			JComboBox<String> myarmyCombo = new JComboBox<String>(myarmyarray);
			JComboBox<String> defarmyCombo = new JComboBox<String>(defarmyarray);
			
			idxarmy = idxdefarmy = -1;
			
			chooseunit = new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == myarmyCombo) {
						idxarmy = myarmyCombo.getSelectedIndex();
						
					}
					if(e.getSource() == defarmyCombo) {
						idxdefarmy = defarmyCombo.getSelectedIndex();
						
					}
				}
			};
			
			myarmyCombo.addActionListener(chooseunit);
			//idxarmy = myarmyCombo.getSelectedIndex();
			//defarmyCombo.addActionListener(this);
			battleview.add(myarmyCombo);
			// defending mbydrbsh :< || el lost units mbtzhrsh || ellog ele btwarek men bydrb men
			int bef = 0 ;
			int aft = 0 ;
			if(idxarmy != -1 && idxdefarmy != -1) {
				System.out.println("idx ");
				if(turns) {
					bef = defender.getUnits().get(idxarmy).getCurrentSoldierCount();
				attacker.getUnits().get(idxarmy).attack(defender.getUnits().get(idxdefarmy));
				aft = defender.getUnits().get(idxarmy).getCurrentSoldierCount() ;
				showMessageDialog(null,"Gamed ya " +player.getName()+ " defending army lost " + (bef-aft) + " units  " +aft );
				}
				else {
					bef = attacker.getUnits().get(idxarmy).getCurrentSoldierCount();
					defender.getUnits().get(idxarmy).attack(attacker.getUnits().get(idxdefarmy));
					aft = attacker.getUnits().get(idxarmy).getCurrentSoldierCount() ;
					showMessageDialog(null, " you lost " + (bef-aft) + " units" + "  " + aft);
				}
				
			}
			
			
			
			if(defender.getUnits().size() == 0) {
				showMessageDialog(null,"You won the battle woho !");
				game.occupy(attacker, cityname);
				
			}
			else
				showMessageDialog(null,"You lost the battle :(");
			
			autoOrAttack(attacker,defender,turns);
		}
		else {
			game.autoResolve(attacker, defender,turns);
			for(City c : game.getAvailableCities()) {
				if(c.getName().equals(attacker.getCurrentLocation())) {
					if( player.getControlledCities().contains(c))
						showMessageDialog(null,"You won the battle ! ");
					else
						showMessageDialog(null,"You lost the battle ! ");
				}
			}
		}
	}
	public void refreshdefending(MyFrame maincityview) {
		String city = maincityview.getCityName();
		//ArrayList<String> units = new ArrayList<String>();
		String defunits = "" , armyunits = ""; 
        maincityview.getDefending().setEditable(false);
        String add = "";
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(city)) {

				
				for(Unit u : c.getDefendingArmy().getUnits()) {
					System.out.println("dsads");
					String[] s =u.getClass().toString().split("\\."); 
						
						add += "Unit " + s[1] +" | ";
						add += "Level" + u.getLevel() + " | ";
						add += "Current soldier count : " + u.getCurrentSoldierCount() + " | "
								+ "\n";
						
						
					
				}
				defunits += add;
				
			}
		}
		int i =1 ;
		add = "";
		for(Army a : player.getControlledArmies()) {
			if(a.getCurrentLocation().equals(city)) {
				add += "army " + i;
				
				for(Unit u : a.getUnits()) {
					String[] s =u.getClass().toString().split("\\."); 
						
						add += "Unit " + s[1] +" | ";
						add += "Level" + u.getLevel() + " | ";
						add += "Current soldier count : " + u.getCurrentSoldierCount() + " | \n";
						
						
				}
				
				
			}
		}
		
		armyunits += add;
		
		maincityview.getDefendingtext().setText(defunits);
		maincityview.getCityarmy().setText(armyunits);
		
		//maincityview.getdefscroll().setViewportView(maincityview.getDefendingtext());
		/*
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		ta.setLineWrap(true);
		ta.setBorder(null);
		
		ta.setText(add);
		//ta.setFont(new Font(ta.getFont().getName(),Font.BOLD,25));
		ta.setSize(ta.getPreferredSize().width * 10 , ta.getPreferredSize().height);
		ta.setBounds(800,100,ta.getSize().width,ta.getSize().height);
		
		maincityview.add(ta);
		
		JList<String> list = new JList<>(units); 
		JList<String> listarmy = new JList<>(unitsarmy); 
		list.setBounds(800,100, list.getPreferredSize().width + 2,list.getPreferredSize().height );
		
		listarmy.setBounds(list.getX() +list.getPreferredSize().width + 20 ,100, listarmy.getPreferredSize().width + 20,listarmy.getPreferredSize().height);

		maincityview.setDeflist(list);
		maincityview.setArmylist(listarmy);
		maincityview.remove(maincityview.getDeflist());
		maincityview.remove(maincityview.getArmylist());
		maincityview.getDeflist().setVisible(false);
		*/
		//maincityview.add(list);
		//maincityview.add(listarmy);
		
		maincityview.repaint();
	}
	
	
	public void refreshmapview() {
		
		String ad = "my Idle Armies:\n";
		String besiege ="my Besiege Armies:\n";
		String marching ="my Marching Armies:\n";
		ArrayList<Army> army = player.getControlledArmies();
		int i =0 ;
		
		for(Army a : army) {
			if(a.getCurrentStatus()==Status.IDLE) {
			
			ad+= "Army" + i + "\n";
			int m = 1;
			for(Unit u : a.getUnits()) {
				ad += "Unit " + m +"\n";
				ad += "Level" + u.getLevel() + "\n";
				ad += "Current soldier count : " + u.getCurrentSoldierCount() + "\n";
			m ++ ;}
			i ++ ;
			idlearmies.add(a);
			}
			i =0 ;
			if(a.getCurrentStatus()==Status.BESIEGING) {
				besiege+= "Army" + i + "\n";
				besiege += "Besieged City : " + a.getCurrentLocation() + "\n";
				
				int turnsunder =0 ;				
				for(City c : game.getAvailableCities()) {
					if(c.getName().equals(a.getCurrentLocation()))
						turnsunder = c.getTurnsUnderSiege();
				}
				besiege += "Turns under Siege : " + turnsunder + "\n";
				
				int m = 1;
				for(Unit u : a.getUnits()) {
					besiege += "Unit " + m +"\n";
					besiege += "Level" + u.getLevel() + "\n";
					besiege += "Current soldier count : " + u.getCurrentSoldierCount() + "\n";
				m ++ ;}
				i ++ ;
				bearmies.add(a);
			}
			i=0;
			if(a.getCurrentStatus()==Status.MARCHING) {
				marching+= "Army" + i + "\n";
				marching += "Target : " + a.getTarget() +"\n";
				marching += "Turns left : " + a.getDistancetoTarget() + "\n" ;
				
				int m = 1;
				for(Unit u : a.getUnits()) {
					marching += "Unit " + m +"\n";
					marching += "Level" + u.getLevel() + "\n";
					marching += "Current soldier count : " + u.getCurrentSoldierCount() + "\n";
				m ++ ;}
				i ++ ;
				marchingarmies.add(a);
			}
		}
		mapview.getJ().setText(ad);
		mapview.getJ().setFont(new Font(mapview.getJ().getFont().getName(),Font.BOLD,25));
		//mapview.getJ().setSize(mapview.getJ().getPreferredSize().width , mapview.getJ().getPreferredSize().height);
		//mapview.getJ().setBounds(0,0,mapview.getJ().getSize().width,mapview.getJ().getSize().height);
		
		mapview.getMar().setText(marching);
		mapview.getMar().setFont(new Font(mapview.getMar().getFont().getName(),Font.BOLD,20));
		mapview.getMar().setSize(mapview.getMar().getPreferredSize().width , mapview.getMar().getPreferredSize().height);
		mapview.getMar().setBounds(150,0,mapview.getMar().getSize().width,mapview.getMar().getSize().height);
		
		
		mapview.getBe().setText(besiege);
		mapview.getBe().setFont(new Font(mapview.getBe().getFont().getName(),Font.BOLD,20));
		mapview.getBe().setSize(mapview.getBe().getPreferredSize().width , mapview.getBe().getPreferredSize().height);
		mapview.getBe().setBounds(300,0,mapview.getBe().getSize().width,mapview.getBe().getSize().height);
		mapview.repaint();
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}