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
	private ActionListener enterlistener;
	private ActionListener chooselistener;
	private ActionListener viewmaplistener ;
	private ActionListener viewcitylistener ;
	private ActionListener archerblistener;
	private ActionListener archerulistener;
	private ActionListener marketulistener;
	private ActionListener stableulistener;
	private ActionListener stablerlistener;
	private ActionListener stableblistener;
	private ActionListener barulistener;
	private ActionListener barrlistener;
	private ActionListener barblistener;
	
	
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
    
    */
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
        maincityview.add(maincityview.getMarketpicture());
        maincityview.getMarl().setVisible(false);
        maincityview.getMarketlvl().setText("LVL1");
        maincityview.getMarketlvl().setBounds(400 , 20 , maincityview.getMarketlvl().getPreferredSize().width,maincityview.getMarketlvl().getPreferredSize().height);
        maincityview.add(maincityview.getMarketlvl());
        money.setText(""+player.getTreasury());
        maincityview.add(money);
    	

        maincityview.getMarketb().setVisible(false);


        maincityview.repaint();
        showMessageDialog(null, "you build a market");

        }
        catch(NotEnoughGoldException e) {
        	showMessageDialog(null, e.getMessage());

        }
	}
	
	public void lnkmarketu(String city ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		if(maincityview.getCityName().equals(city)) {
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(city)) {
				for(EconomicBuilding b : c.getEconomicalBuildings()) {
					if(b instanceof Market) {
					try {
					b.setCoolDown(false);
					player.upgradeBuilding(b);
					maincityview.getMarketlvl().setText("LVL " + b.getLevel());
					maincityview.getMarketlvl().setSize(maincityview.getMarketlvl().getPreferredSize().width ,maincityview.getMarketlvl().getPreferredSize().height  );
					maincityview.add(maincityview.getMarketlvl());
					maincityview.getMarket().setText("Upgrade " + b.getUpgradeCost());
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
		
		
	public void lnkarcherb(String city) throws NotEnoughGoldException {
		try {
		if(maincityview.getCityName().equals(city)) {
		player.build("archeryrange", city);
		showMessageDialog(null, "You built a archeryrange !");
		maincityview.add(maincityview.getArcher());
		maincityview.add(maincityview.getArcherpicture());
		maincityview.add(maincityview.getArcherr());
		maincityview.getArl().setVisible(false);
		

		money.setText(""+player.getTreasury());
		maincityview.getArcherlvl().setText("LVL 1");
		maincityview.getArcherlvl().setSize(maincityview.getArcherlvl().getPreferredSize().width ,maincityview.getArcherlvl().getPreferredSize().height );
		maincityview.getArcherlvl().setBounds(400 , 400 , maincityview.getArcherlvl().getSize().width,maincityview.getArcherlvl().getSize().height);
		maincityview.add(maincityview.getArcherlvl());
		maincityview.add(money);


		maincityview.getArcherb().setVisible(false);


		maincityview.repaint();
		}
		}
		catch(NotEnoughGoldException e) {
			showMessageDialog(null,e.getMessage());
			
		}

		}
	
	public void lnkarcheru(String city ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
		if(maincityview.getCityName().equals(city)) {
		for(City c : player.getControlledCities()) {
			if(c.getName().equals(city)) {
				for(MilitaryBuilding b : c.getMilitaryBuildings()) {
					if(b instanceof ArcheryRange) {
					try {
					b.setCoolDown(false);
					player.upgradeBuilding(b);
				System.out.println("upgrade archer");
					maincityview.getArcherlvl().setText("LVL " + b.getLevel());
					maincityview.add(maincityview.getArcherlvl());
					maincityview.getArcher().setText("Upgrade " + b.getUpgradeCost());
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
	//=============================================== barracks build and upgrade ================================================================================

//          ====  barracks build method ====

public void lnkbarb(String city) throws NotEnoughGoldException {
try {
if(maincityview.getCityName().equals(city)) {
player.build("Barracks", city);
showMessageDialog(null, "You built a barracks !");
maincityview.add(maincityview.getBar());
maincityview.add(maincityview.getBarr());
maincityview.add(maincityview.getBarpicture());
maincityview.getBarl().setVisible(false);
maincityview.add(money);

money.setText(""+player.getTreasury());
maincityview.getBarlvl().setText("LVL 1");
maincityview.getBarlvl().setSize(maincityview.getBarlvl().getPreferredSize().width ,maincityview.getBarlvl().getPreferredSize().height );
maincityview.getBarlvl().setBounds(150 , 350 , maincityview.getBarlvl().getSize().width,maincityview.getBarlvl().getSize().height);
maincityview.add(maincityview.getBarlvl());
maincityview.add(money);

maincityview.getBarb().setVisible(false);
maincityview.getBar().setText("upgrade  1000");


maincityview.repaint();
}
}
catch(NotEnoughGoldException e) {
System.out.println(e.getMessage());

}

}
                      // --- barracks upgrade method --
public void lnkbaru(String city ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
if(maincityview.getCityName().equals(city)) {
for(City c : player.getControlledCities()) {
if(c.getName().equals(city)) {
for(MilitaryBuilding b : c.getMilitaryBuildings()) {
	if(b instanceof Barracks) {
	try {
	b.setCoolDown(false);
	player.upgradeBuilding(b);
	money.setText(""+player.getTreasury());
	maincityview.add(money);
   System.out.println("upgrade bar");
	maincityview.getBarlvl().setText("LVL " + b.getLevel());
	maincityview.add(maincityview.getBarlvl());
	maincityview.getBar().setText("Upgrade " + b.getUpgradeCost());
	
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
	}}}
}

}




//========================================================= end of barracks build and upgrade ==============================================================================

	public void lnkarcherr(String city) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		
		player.recruitUnit("archer", city);
		money.setText("Money : " + player.getTreasury());
		maincityview.add(money);
		maincityview.repaint();
		showMessageDialog(null, "You rectuited an archer !");
	}
	
	public void lnkenter() throws IOException {
		
		if(startingwindow.getNameText().equals("")) {
			showMessageDialog(null, "enter a valid name < non empty >");
		}
		else {
		player = new Player(startingwindow.getNameText());
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

		System.out.println("ok");
		}
	}
	
	public void pickedcity(String s) throws IOException {
		
		cityname = s;
		City maincity = new City(cityname);
		player.getControlledCities().add(maincity);
		game = new Game(player.getName() ,cityname);
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
		
		player.setTreasury(5000);
		
		lnkMainWindow();
		player.getControlledArmies().add(new Army(cityname) );
		/*try {
		player.build("ArcheryRange", cityname);
		player.getControlledCities().get(0).getMilitaryBuildings().get(0).setCoolDown(false);}
		catch(NotEnoughGoldException e) {
			showMessageDialog(null, e.getMessage());
		}*/
		viewmaplistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewmap();
			}
		};
		mainwindow.getMap().addActionListener(viewmaplistener);
	}
	
	public void viewmap() {
		mapview = new WorldMapView(player.getControlledArmies()) ;
		mapview.setAvailablecities(game.getAvailableCities());
		viewcitylistener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList <String > ava = new ArrayList <String >();
				for(City c : player.getControlledCities()) {
					ava.add(c.getName());
				}
				if(e.getSource() == mapview.getRome() && ava.contains("Rome"))
					viewcity("rome");
				else if(e.getSource() == mapview.getCairo() && ava.contains("Cairo"))
					viewcity("cairo");
				else if(e.getSource() == mapview.getSparta() && ava.contains("Sparta"))
					viewcity("sparta");
			}
			
		};
		mapview.getCairo().addActionListener(viewcitylistener);
		mapview.getRome().addActionListener(viewcitylistener);
		mapview.getSparta().addActionListener(viewcitylistener);
	}
	
	
	public void viewcity(String cityn) {
		maincityview = new MyFrame(cityname);
		maincityview.add(name);
		
		//				 Archer build
		archerblistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lnkarcherb(maincityview.getCityName());
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
					showMessageDialog(null,e1.getMessage());}
			}
		};
		maincityview.Getfarmb().addActionListener(farmblistener);
		//=========================================
		 //  upgrade  listener 
		barulistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try {
		lnkbaru(maincityview.getCityName());
		}catch (BuildingInCoolDownException e1) {

		e1.getMessage();
		} catch (MaxLevelException e1) {

		e1.getMessage();
		} catch (NotEnoughGoldException e1) {

		e1.getMessage();
		}
		}
		};
		maincityview.getBar().addActionListener(barulistener);

//			barracks Build Listener
		barblistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try {
		lnkbarb(maincityview.getCityName());
		} catch (NotEnoughGoldException e1) {
		e1.getMessage();
		}
		}
		};
		maincityview.getBarb().addActionListener(barblistener);

		
		//=============================================
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
	    
	    //				market upgrade 
	    marketulistener = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			lnkmarketu(maincityview.getCityName());
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
	    			lnkarcheru(maincityview.getCityName());
	    		}catch (BuildingInCoolDownException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		} catch (MaxLevelException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		} catch (NotEnoughGoldException e1) {
	    			
	    			showMessageDialog(null,e1.getMessage());
	    		}
	    		}
	    	};
	    	maincityview.getArcher().addActionListener(archerulistener);
	    
	    
	
	
	
	
	
	
	//----------------------------------------------Stable build and upgrade  ---------------------------------------------------------------------------------------------

	stableulistener = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	try {
		lnkstableu(maincityview.getCityName());
	}catch (BuildingInCoolDownException e1) {
		
		e1.getMessage();
	} catch (MaxLevelException e1) {
		
		e1.getMessage();
	} catch (NotEnoughGoldException e1) {
		
		e1.getMessage();
	}
	}
	};
	maincityview.getStable().addActionListener(stableulistener);

//			stable Build Listener
	stableblistener = new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	try {
		lnkstableb(maincityview.getCityName());
	} catch (NotEnoughGoldException e1) {
		e1.getMessage();
	}
	}
	};
	maincityview.getStableb().addActionListener(stableblistener);

	}


	public void lnkstableb(String city) throws NotEnoughGoldException {
	try {
	if(maincityview.getCityName().equals(city)) {
	player.build("Stable", city);
	maincityview.add(money);
	money.setText(""+player.getTreasury());
	maincityview.add(money);
	showMessageDialog(null, "You built a Stable !");
	maincityview.add(maincityview.getStable());
	maincityview.add(maincityview.getStabler());
	maincityview.add(maincityview.getStablepicture());
	maincityview.getStal().setVisible(false);
	maincityview.getStableb().setVisible(false);

	money.setText(""+player.getTreasury());
	maincityview.getStablelvl().setText("LVL 1");
	maincityview.getStablelvl().setSize(maincityview.getStablelvl().getPreferredSize().width ,maincityview.getStablelvl().getPreferredSize().height );
	maincityview.getStablelvl().setBounds(550 , 350 , maincityview.getStablelvl().getSize().width,maincityview.getStablelvl().getSize().height);
	maincityview.add(maincityview.getStablelvl());
	maincityview.add(money);


	maincityview.getStableb().setVisible(false);


	maincityview.repaint();
	showMessageDialog(null, " You build a stable ");
	}
	}
	catch(NotEnoughGoldException e) {
	System.out.println(e.getMessage());

	}

	}

	public void lnkstableu(String city ) throws BuildingInCoolDownException, MaxLevelException, NotEnoughGoldException {
	if(maincityview.getCityName().equals(city)) {
	for(City c : player.getControlledCities()) {
	if(c.getName().equals(city)) {
		for(MilitaryBuilding b : c.getMilitaryBuildings()) {
			if(b instanceof Stable) {
			try {
			b.setCoolDown(false);
			player.upgradeBuilding(b);
			money.setText(""+player.getTreasury());
			maincityview.add(money);
		System.out.println("upgrade stable");
			maincityview.getStablelvl().setText("LVL " + b.getLevel());
			maincityview.add(maincityview.getStablelvl());
			maincityview.getStable().setText("Upgrade " + b.getUpgradeCost());
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
	




	//-----------------------------------------------------------end of stable ---------------
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
