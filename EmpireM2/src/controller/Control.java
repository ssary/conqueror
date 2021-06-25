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
	private ActionListener stablerlistener;
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
	
	//startingwindow.dispatchEvent(new WindowEvent(startingwindow, WindowEvent.WINDOW_CLOSING));
	
	//				Choose City
	/*while(!choosecity.getPressed()) {
		System.out.print("");
	}*/


	
	/*
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
	player.getControlledArmies().add(new Army(cityname) );*/
	//player.getControlledArmies().add(new Army(cityname) );
	
	
	//mapview = new WorldMapView(player.getControlledArmies()) ;
	//mapview.setAvailablecities(game.getAvailableCities());
	//maincityview = new MyFrame(cityname);
	//maincityview.add(name);
	
	
	/*
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
				lnkfarmb(maincityview.getCityName());
			} catch (NotEnoughGoldException e1) {
				showMessageDialog(null,e1.getMessage());
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
                showMessageDialog(null,e1.getMessage());
            }
        }
    };
    maincityview.getMarketb().addActionListener(marketblistener);
    
    */
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
        //maincityview.add(maincityview.getMarketpicture());
        maincityview.getMarl().setVisible(false);
        maincityview.getMarketlvl().setText("LVL1");
        maincityview.getMarketlvl().setBounds(350 , 20 , maincityview.getMarketlvl().getPreferredSize().width,maincityview.getMarketlvl().getPreferredSize().height);
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
		//maincityview.add(maincityview.getArcherpicture());
		maincityview.add(maincityview.getArcherr());
		maincityview.getMarl().setVisible(false);

		money.setText(""+player.getTreasury());
		maincityview.getArcherlvl().setText("LVL 1");
		maincityview.getArcherlvl().setSize(maincityview.getArcherlvl().getPreferredSize().width ,maincityview.getArcherlvl().getPreferredSize().height );
		maincityview.getArcherlvl().setBounds(550 , 450 , maincityview.getArcherlvl().getSize().width,maincityview.getArcherlvl().getSize().height);
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
		refreshmain();
		showMessageDialog(null, "You rectuited an archer !");
	}
	
	
	public void lnkstableb(MyFrame maincityview) throws NotEnoughGoldException {
		
	    	player.build("Stable", maincityview.getCityName());
	    	maincityview.add(money);
	    	money.setText(""+player.getTreasury());
			maincityview.add(money);
	    	showMessageDialog(null, "You built a Stable !");
	    	maincityview.add(maincityview.getStable());
	    	//maincityview.add(maincityview.getArcherpicture());
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
		//maincityview.add(maincityview.getArcherpicture());
		maincityview.getBarl().setVisible(false);
		maincityview.add(money);

		money.setText(""+player.getTreasury());
		maincityview.getBarlvl().setText("LVL 1");
		maincityview.getBarlvl().setSize(maincityview.getBarlvl().getPreferredSize().width ,maincityview.getBarlvl().getPreferredSize().height );
		maincityview.getBarlvl().setBounds(550 , 350 , maincityview.getBarlvl().getSize().width,maincityview.getBarlvl().getSize().height);
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
				    System.out.println("upgrade bar");
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
	            showMessageDialog(null, "You rectuited an Infantry !");
	        }
	//----------------------------------------------------------------------------------
	
	
	// ====================stable  listener method ========================
	public void lnkstabler(MyFrame maincityview) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
					
					player.recruitUnit("Cavalry", maincityview.getCityName());
					maincityview.repaint();
		    		refreshmain();
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
		lnkopenmainwindow();
		
	}
	public void lnkopenmainwindow()  {
		
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
		player.getControlledArmies().add(new Army(cityname) );
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
				lnkendturn();
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
	}
	
	
	public void viewcity(MyFrame maincityview) {
		//maincityview = new MyFrame(cityname);
		//maincityview.add(name);
		
		
		//if(cityn.equals(maincityview.getCityName().toLowerCase())) {
		//	maincityview.setVisible(true);
		//}
		
		
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
	public void lnkback() {
		mapview.setVisible(false);
	}
	
	public void lnkbackcity(MyFrame maincityview) {
		maincityview.setVisible(false);
	}
	
	public void lnkendturn() {
		game.endTurn();
		refreshmain();
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
