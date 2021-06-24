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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	JButton farm, market , bar,archer, stable ,barr,stabler,archerr,farmb,marketb,barb,stableb,archerb;
	JLabel farml,marl,barl,arl,stal, farmlvl;
	String cityName;
	//int farmLevel,marketLevel,barLevel,archerLevel,stableLevel;
	boolean buildfarm = false;
	int buildcostfarm,buildcostmarket ;
	ImageIcon myPicture;
	JLabel farmpicture ;
	public MyFrame(String cityName){
		 this.cityName = cityName;
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		  this.setResizable(false);
		  this.setSize(1400,1000);
		  this.setVisible(true);
		  this.setLayout(null);
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
		 farm.setText("upgrade ");
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
		  marl.setBounds(350,00,350,350);
		   market  = new JButton();
		  market.setBounds(350,250,150,50);  
		  //this.add(market);
		 //market.addActionListener(this);
		 market.setText("upgrade");
		 market.setFocusable(false ); 
		 
		 
		 

		 marketb  = new JButton();
		  marketb.setBounds(350,325,200,50);  
		  this.add(marketb);
		// marketb.addActionListener(this);
		 marketb.setText("build 1500");
		 marketb.setFocusable(false );
		
		 
		 
		 
		 
		 
		 
		 
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
		  this.add(bar);
		 bar.addActionListener(this);
		 bar.setText("upgrade");
		 bar.setFocusable(false );
		 
		 barb = new JButton();
		  barb.setBounds(0,575,150,50);  
		  this.add(barb);
		 barb.addActionListener(this);
		 barb.setText("build 2000");
		 barb.setFocusable(false );
		 
		 
		 barr = new JButton();
		  barr.setBounds(0,520,150,50);  
		  this.add(barr);
		 barr.addActionListener(this);
		 barr.setText("recruit");
		 barr.setFocusable(false );
		 
		 
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
		  this.add(archer );
		 archer .addActionListener(this);
		 archer .setText("upgrade");
		 archer .setFocusable(false ); 
		 
		 archerr  = new JButton();
		  archerr .setBounds(350,520,150,50);  
		  this.add(archerr );
		 archerr .addActionListener(this);
		 archerr .setText("recruit");
		 archerr .setFocusable(false );
		 
		 
		 archerb  = new JButton();
		  archerb .setBounds(350,600,150,50);  
		  this.add(archerb );
		 archerb .addActionListener(this);
		 archerb .setText("build 1500");
		 archerb .setFocusable(false );
		 
		 
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
		  this.add(stable );
		 stable .addActionListener(this);
		 stable .setText("upgrade");
		 stable .setFocusable(false );
		 
		 stabler  = new JButton();
		  stabler .setBounds(650,420,150,50);  
		  this.add(stabler );
		 stabler.addActionListener(this);
		 stabler.setText("recruit");
		 stabler.setFocusable(false );
		 

		 stableb  = new JButton();
		  stableb .setBounds(650,475,150,50);  
		  this.add(stableb );
		 stableb .addActionListener(this);
		 stableb .setText("build 2500");
		 stableb .setFocusable(false );
		 
		 
		 
		 
		 
		 
		  //ImageIcon image  = new ImageIcon("farm.jpg");
		 // farml.setIcon(image); 
		 
	}
	
	
		public JLabel getFarmlvl() {
		return farmlvl;
	}


		public String getCityName() {
		return cityName;
	}


		@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==market )
		{
			//farm
		}if (e.getSource()==bar )
		{
			//farm
		}if (e.getSource()==archer )
		{
			//farm
		}if (e.getSource()==stable )
		{
			//farm
		}
		
		
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
		
}
