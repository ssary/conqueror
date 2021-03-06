package view;
import engine.Game;
import engine.Player;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import exceptions.FriendlyFireException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	JButton farm, market , bar,archer, stable ,barr,stabler,archerr,farmb,marketb,barb,stableb,archerb,back;
	JLabel farml,marl,barl,arl,stal, farmlvl , archerlvl ,marketlvl , stablelvl , barlvl;
	String cityName;
	JPanel defpanel , cityarmypanel;
	JList deflist;
	JList armylist;
	ImageIcon  marketp,archerp,barracksp,stablep;
	JButton initiatearmy;
	JButton relocateunit ;
	
	JLabel marketpicture,stablepicture,barpicture,archerpicture ;
	public JList getArmylist() {
		return armylist;
	}


	public void setArmylist(JList armylist) {
		this.armylist = armylist;
	}


	JScrollPane scrollPane;
	//int farmLevel,marketLevel,barLevel,archerLevel,stableLevel;
	boolean buildfarm = false;
	int buildcostfarm,buildcostmarket ;
	ImageIcon myPicture;
	JLabel farmpicture ;
	JTextArea defending ,army , defendingtext , cityarmy ;
	JTextArea area = new JTextArea();
	JScrollPane defscroll , cityarmyscroll;
	
	public MyFrame(String cityName){
		  this.setResizable(false);
		  this.setSize(1400,1000);
		  this.setVisible(true);
		  this.setLayout(null);
		initiatearmy = new JButton();
		relocateunit = new JButton();
		
		
		initiatearmy.setText("Initiate Army");
		initiatearmy.setSize(initiatearmy.getPreferredSize().width , initiatearmy.getPreferredSize().height);
		relocateunit.setText("Relocate Unit");
		relocateunit.setSize(relocateunit.getPreferredSize().width , relocateunit.getPreferredSize().height);
		//targetcity.setText("Target city");
		//targetcity.setSize(targetcity.getPreferredSize().width , targetcity.getPreferredSize().height);
		initiatearmy.setBounds(200,0,initiatearmy.getSize().width,initiatearmy.getSize().height);  
		
		
		  marketpicture= new JLabel();
		  archerpicture= new JLabel();
		  barpicture= new JLabel();
		  stablepicture= new JLabel();
		  
		 marketpicture.setBounds(250,0,150,150);
		 marketpicture.setIcon(marketp);
		  
		  
		 archerpicture.setBounds(250,300,150,150);
		  archerpicture.setIcon(archerp);
		  
		  
		 stablepicture.setBounds(500,350,150,150);
		 stablepicture.setIcon(stablep);
		 this.cityName = cityName;
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		defending = new JTextArea();
		defending.setEditable(false);
		defending.setLineWrap(true);
		defending.setBorder(null);
		defending.setText("Defending Army \n");
		defending.setSize(defending.getPreferredSize().width , defending.getPreferredSize().height);
		defending.setBounds(750 , 20,
				defending.getSize().width, defending.getSize().height);
		
		army = new JTextArea();
		army.setEditable(false);
		army.setLineWrap(true);
		army.setBorder(null);
		army.setText("Army in the city \n");
		army.setSize(army.getPreferredSize().width , army.getPreferredSize().height);
		army.setBounds(1100 , 20,
		army.getSize().width, army.getSize().height);
		deflist = new JList();
		
		cityarmy = new JTextArea();
		cityarmy.setEditable(false);
		cityarmypanel = new JPanel();
		cityarmypanel.setLayout(new GridLayout(2,4));
		cityarmypanel.setSize(300, 600);
		cityarmypanel.setBounds(1050,100 ,300 , 600);
		
		cityarmyscroll = new JScrollPane(cityarmy , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		cityarmyscroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
		cityarmyscroll.setBounds(1050,100 , 300 , 600);
		cityarmyscroll.setViewportView(cityarmy);
		
		cityarmypanel.add(cityarmyscroll);
		add(cityarmypanel);

		
		//----------------------------------------------------------
		defendingtext = new JTextArea();
		defendingtext.setEditable(false);
		defpanel = new JPanel();
		defpanel.setLayout(new GridLayout(2,4));
		defpanel.setSize(300, 700);
		defpanel.setBounds(750,100 ,300 , 600);
		
		defscroll = new JScrollPane(defendingtext , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		defscroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
		defscroll.setBounds(750,100 , 300 , 600);
		defscroll.setViewportView(defendingtext);
		
		defpanel.add(defscroll);
		add(defpanel); 
		
		//-------------------------------------------------------------------------------------------
		  farml= new JLabel();
		  myPicture = new ImageIcon("farm.png");
		  farmpicture = new JLabel();
		  farmpicture.setBounds(0,0,150,150);
		  farmpicture.setIcon(myPicture);
		  
		  // farml.setHorizontalTextPosition(JLabel.CENTER);
		  // farml.setVerticalTextPosition(JLabel.TOP);
		  farml.setText(" farm" );
		 farml.setFont(new Font("MV Boli",Font.PLAIN,30));
		  
		  farml.setVisible(true);
		  this.add(farml);
		  farml.setBounds(0,0,150,150);
		  //-------------------------------------------------------------------------------------
		  farm  = new JButton();
		  farm.setBounds(0,150,200,50);  
		  //this.add(farm);
		 //farm.addActionListener(this);
		 farm.setText("upgrade 500");
		 farm.setFocusable(false );
		 
		 
		 farmb  = new JButton();
		  farmb.setBounds(0,225,150,50);  
		  this.add(farmb);
		 //farmb.addActionListener(this);
		 farmb.setText("build 1000");
		 farmb.setFocusable(false );
		
		 farmlvl = new JLabel();
		 
		 
		 
		 
		 
		 
		  marl= new JLabel();
		  marl.setText("market" );
		   marl.setHorizontalTextPosition(JLabel.CENTER);
		   marl.setVerticalTextPosition(JLabel.TOP);
		   marl.setFont(new Font("MV Boli",Font.PLAIN,30));
		   marl.setVisible(true);
		  this.add(marl);
		  marl.setBounds(350,100,350,350);
		   market  = new JButton();
		  market.setBounds(350,250,150,50);  
		  //this.add(market);
		 //market.addActionListener(this);
		 market.setText("upgrade 700");
		 market.setFocusable(false ); 
		 
		 
		 

		 marketb  = new JButton();
		  marketb.setBounds(350,325,200,50);  
		  this.add(marketb);
		// marketb.addActionListener(this);
		 marketb.setText("build 1500");
		 marketb.setFocusable(false );
		marketlvl = new JLabel();
		 
		 
		 
		 
		 
		 
		 
		  barl= new JLabel();
		  barl.setText("barracks" );
		   barl.setHorizontalTextPosition(JLabel.CENTER);
		   barl.setVerticalTextPosition(JLabel.TOP);
		   barl.setFont(new Font("MV Boli",Font.PLAIN,30));
		   barl.setVisible(true);
		  this.add(barl);
		  barl.setBounds(0,250,350,350);
		  
		 bar = new JButton();
		  bar.setBounds(0,450,150,50);  
		  //this.add(bar);
		 //bar.addActionListener(this);
		 bar.setText("upgrade");
		 bar.setFocusable(false );
		 
		 barb = new JButton();
		  barb.setBounds(0,575,150,50);  
		  this.add(barb);
		 //barb.addActionListener(this);
		 barb.setText("build 2000");
		 barb.setFocusable(false );
		 
		 
		 barr = new JButton();
		  barr.setBounds(0,520,150,50);  
		  //this.add(barr);
		 //barr.addActionListener(this);
		 barr.setText("recruit");
		 barr.setFocusable(false );
		 barlvl = new JLabel();
		 
		 arl= new JLabel();
		  arl.setText("archer " );
		   arl.setHorizontalTextPosition(JLabel.CENTER);
		   arl.setVerticalTextPosition(JLabel.TOP);
		   arl.setFont(new Font("MV Boli",Font.PLAIN,30));
		   arl.setVisible(true);
		  this.add(arl);
		  arl.setBounds(350,250,350,350);
		 
		 
		 
		 archer  = new JButton();
		  archer .setBounds(350,450,150,50);  
		 //this.add(archer );
		 //archer .addActionListener(this);
		 archer .setText("upgrade 800");
		 //archer .setFocusable(false ); 
		 
		 archerr  = new JButton();
		  archerr .setBounds(350,520,150,50);  
		  //this.add(archerr );
		 //archerr .addActionListener(this);
		 archerr .setText("recruit 500");
		 //archerr .setFocusable(false );
		 
		 
		 archerb  = new JButton();
		  archerb .setBounds(350,600,150,50);  
		  this.add(archerb );
		 //archerb .addActionListener(this);
		 archerb .setText("build 1500");
		 archerb .setFocusable(false );
		 archerlvl = new JLabel();
		 
		 stal= new JLabel();
		  stal.setText("stable " );
		   stal.setHorizontalTextPosition(JLabel.CENTER);
		   stal.setVerticalTextPosition(JLabel.TOP);
		   stal.setFont(new Font("MV Boli",Font.PLAIN,30));
		   stal.setVisible(true);
		  this.add(stal);
		  stal.setBounds(650,150,350,350);
		 
		 stable  = new JButton();
		  stable .setBounds(650,350,150,50);  
		  //this.add(stable );
		 //stable .addActionListener(this);
		 stable .setText("upgrade");
		 stable .setFocusable(false );
		 
		 stabler  = new JButton();
		  stabler .setBounds(650,420,150,50);  
		  //this.add(stabler );
		 //stabler.addActionListener(this);
		 stabler.setText("recruit");
		 stabler.setFocusable(false );
		 stablelvl = new JLabel();

		 stableb  = new JButton();
		  stableb .setBounds(650,475,150,50);  
		  this.add(stableb );
		 //stableb .addActionListener(this);
		 stableb .setText("build 2500");
		 stableb .setFocusable(false );
		 
		 
		 
		 
		 	back = new JButton();
			back.setText("Back");
			back.setFont(new Font(back.getFont().getName(),Font.BOLD,30));
			back.setSize(back.getPreferredSize().width , back.getPreferredSize().height);
			back.setBorder(null);
			
			JLabel backl = new JLabel();
			backl.add(back);
			backl.setText(back.getText());
			backl.setSize(back.getSize().width,back.getSize().height);
			backl.setBounds(1300 , 20 , backl.getSize().width , backl.getSize().height);
			backl.setBorder(null);
			add(back);
			
		  //ImageIcon image  = new ImageIcon("farm.jpg");
		 // farml.setIcon(image); 
			 myPicture = new ImageIcon("farm.png");
			  farmpicture = new JLabel();
			  farmpicture.setBounds(0,0,150,150);
			  farmpicture.setIcon(myPicture);
			  
			marketp = new ImageIcon("market.png");
			 archerp = new ImageIcon("arcehr.png");
			  barracksp = new ImageIcon("barracks.png");
			 stablep = new ImageIcon("stable.jpg");
			 
			barpicture.setBounds(0,325,150,150);
			  barpicture.setIcon(barracksp);
			  
			  market.setBounds(250,150,200,50);  
			  marl.setBounds(250,150,150,50);
			  marketb.setBounds(250,225,150,50);  
			  barl.setBounds(0,250,150,150);
			  barb.setBounds(0,455,150,50);  
			  bar.setBounds(0,450,150,50); 
			  farmb.setBounds(0,225,150,50);  
				 arl.setBounds(250,250,350,350);
				  archer .setBounds(250,450,150,50);  
				  stal.setBounds(500,350,150,150);
				  stable .setBounds(500,450,150,50); 
				  marketpicture.setBounds(250,0,150,150);
					 archerpicture.setBounds(250,300,150,150);	  
				  
				 stablepicture.setBounds(500,350,150,150);
				 
				 archerr  = new JButton();
				 archerr.setText("rectruit 400");
				  stableb .setBounds(500,450,150,50);  
				 stabler .setBounds(500,520,150,50); 
				 archerb .setBounds(250,450,150,50);  
				 barr.setBounds(0,520,150,50);
				  archerr .setBounds(250,520,150,50);  
				  add(initiatearmy);
				  initiatearmy.setVisible(false);
	}
	
	
		public JLabel getFarmlvl() {
		return farmlvl;
	}


		public String getCityName() {
		return cityName;
	}

	 
		public void setBuildcostfarm(int buildcostfarm) {
			this.buildcostfarm = buildcostfarm;
		}
		public void setBuildcostmarket(int buildcostmarket) {
			this.buildcostmarket = buildcostmarket;
		}
		public boolean getbuildfarm() {
			return buildfarm;
		}
		
		public JButton Getfarmb() {
			return farmb;
		}


		public JButton getFarm() {
			return farm;
		}


		public JButton getMarket() {
			return market;
		}


		public JButton getBar() {
			return bar;
		}


		public JButton getArcher() {
			return archer;
		}


		public JButton getStable() {
			return stable;
		}


		public JButton getBarr() {
			return barr;
		}


		public JButton getStabler() {
			return stabler;
		}


		public JButton getArcherr() {
			return archerr;
		}


		public JButton getFarmb() {
			return farmb;
		}


		public JButton getMarketb() {
			return marketb;
		}


		public JButton getBarb() {
			return barb;
		}


		public JButton getStableb() {
			return stableb;
		}


		public JButton getArcherb() {
			return archerb;
		}


		public JLabel getFarml() {
			return farml;
		}


		public JLabel getMarl() {
			return marl;
		}


		public JLabel getBarl() {
			return barl;
		}


		public JLabel getArl() {
			return arl;
		}


		public JLabel getStal() {
			return stal;
		}


		public boolean isBuildfarm() {
			return buildfarm;
		}


		public int getBuildcostfarm() {
			return buildcostfarm;
		}


		public int getBuildcostmarket() {
			return buildcostmarket;
		}


		public ImageIcon getMyPicture() {
			return myPicture;
		}


		public JLabel getFarmpicture() {
			return farmpicture;
		}
		public JLabel getArcherlvl() {
			return archerlvl;
		}
		public JLabel getMarketlvl() {
			return marketlvl;
		}


		public JButton getBack() {
			return back;
		}


		public JLabel getStablelvl() {
			return stablelvl;
		}


		public JLabel getBarlvl() {
			return barlvl;
		}


		public JTextArea getDefending() {
			return defending;
		}


		public JPanel getDefpanel() {
			return defpanel;
		}


		public JList getDeflist() {
			return deflist;
		}


		public void setDeflist(JList deflist) {
			this.deflist = deflist;
		}


		public JScrollPane getScrollPane() {
			return scrollPane;
		}


		public void setScrollPane(JScrollPane scrollPane) {
			this.scrollPane = scrollPane;
		}


		public ImageIcon getMarketp() {
			return marketp;
		}


		public ImageIcon getArcherp() {
			return archerp;
		}


		public ImageIcon getBarracksp() {
			return barracksp;
		}


		public ImageIcon getStablep() {
			return stablep;
		}


		public JLabel getMarketpicture() {
			return marketpicture;
		}


		public JLabel getStablepicture() {
			return stablepicture;
		}


		public JLabel getBarpicture() {
			return barpicture;
		}


		public JLabel getArcherpicture() {
			return archerpicture;
		}


		public JTextArea getArmy() {
			return army;
		}


		public JTextArea getArea() {
			return area;
		}


		public JButton getInitiatearmy() {
			return initiatearmy;
		}


		public JButton getRelocateunit() {
			return relocateunit;
		}


		public JTextArea getDefendingtext() {
			return defendingtext;
		}


		


		public JScrollPane getDefscroll() {
			return defscroll;
		}


		public JPanel getCityarmypanel() {
			return cityarmypanel;
		}


		public JTextArea getCityarmy() {
			return cityarmy;
		}


		public JScrollPane getCityarmyscroll() {
			return cityarmyscroll;
		}
		
	
}
