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
public class MyFrame extends JFrame {
	JButton farm, market , bar,archer, stable ,barr,stabler,archerr,farmb,marketb,barb,stableb,archerb,back;
	JLabel farml,marl,barl,arl,stal, farmlvl , archerlvl ,marketlvl , stablelvl , barlvl;
	
	String cityName;
	//int farmLevel,marketLevel,barLevel,archerLevel,stableLevel;
	boolean buildfarm = false;
	int buildcostfarm,buildcostmarket ;
	ImageIcon myPicture, marketp,archerp,barracksp,stablep;
	JLabel farmpicture , marketpicture,stablepicture,barpicture,archerpicture ;
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
		  marl.setBounds(250,150,150,50);
		   market  = new JButton();
		  market.setBounds(250,150,200,50);  
		  //this.add(market);
		 //market.addActionListener(this);
		 market.setText("upgrade 700");
		 market.setFocusable(false ); 
		 
		 
		 

		 marketb  = new JButton();
		  marketb.setBounds(250,225,150,50);  
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
		  barl.setBounds(0,250,150,150);
		  
		 bar = new JButton();
		  bar.setBounds(0,450,150,50);  
		  //this.add(bar);
		 //bar.addActionListener(this);
		 bar.setText("upgrade");
		 bar.setFocusable(false );
		 
		 barb = new JButton();
		  barb.setBounds(0,455,150,50);  
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
		  arl.setBounds(250,250,350,350);
		 
		 
		 
		 archer  = new JButton();
		  archer .setBounds(250,450,150,50);  
		 //this.add(archer );
		 //archer .addActionListener(this);
		 archer .setText("upgrade 800");
		 //archer .setFocusable(false ); 
		 
		 archerr  = new JButton();
		  archerr .setBounds(250,520,150,50);  
		  //this.add(archerr );
		 //archerr .addActionListener(this);
		 archerr .setText("recruit 500");
		 //archerr .setFocusable(false );
		 
		 
		 archerb  = new JButton();
		  archerb .setBounds(250,450,150,50);  
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
		  stal.setBounds(500,350,150,150);
		 
		 stable  = new JButton();
		  stable .setBounds(500,450,150,50);  
		  //this.add(stable );
		 //stable .addActionListener(this);
		 stable .setText("upgrade");
		 stable .setFocusable(false );
		 
		 stabler  = new JButton();
		  stabler .setBounds(500,520,150,50);  
		  //this.add(stabler );
		 //stabler.addActionListener(this);
		 stabler.setText("recruit");
		 stabler.setFocusable(false );
		 stablelvl = new JLabel();

		 stableb  = new JButton();
		  stableb .setBounds(500,450,150,50);  
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
			 marketp = new ImageIcon("market.png");
			 archerp = new ImageIcon("arcehr.png");
			  barracksp = new ImageIcon("barracks.png");
			 stablep = new ImageIcon("stable.jpg");
			 
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
			  
			  
		  barpicture.setBounds(0,325,150,150);
		  barpicture.setIcon(barracksp);
			
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
		
		
}