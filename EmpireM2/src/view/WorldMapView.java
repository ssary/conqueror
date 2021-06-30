package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import engine.City;
import units.Army;
import units.Status;
import units.Unit;
import controller.*;

@SuppressWarnings("serial")
public class WorldMapView extends ChooseCityWindow implements ActionListener{
	ArrayList<City> availablecities;
	JButton back , relocatei ,relocatem , relocateb;
	JTextArea j , be , mar ;
	JScrollPane jscroll , bescroll , marscroll;
	JPanel jp , bep, marp ;
	JButton targetcity ;
	public WorldMapView(ArrayList<Army> army) {
		super();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		
		this.setLayout(null);
		j = new JTextArea();
		j.setEditable(false);
		j.setLineWrap(true);
		j.setBorder(null);
		
		be = new JTextArea();
		be.setEditable(false);
		be.setLineWrap(true);
		be.setBorder(null);
		
		mar = new JTextArea();
		mar.setEditable(false);
		mar.setLineWrap(true);
		mar.setBorder(null);
		
		targetcity = new JButton();
		targetcity.setText("target city");
		targetcity.setSize(targetcity.getPreferredSize());
		targetcity.setBounds(500,100 , targetcity.getSize().width , targetcity.getSize().height);
		
		
		relocatei = new JButton();
		relocatei.setText("Relocate unit from idle");
		relocatei.setSize(relocatei.getPreferredSize());
		relocatei.setBounds(100,600 , relocatei.getSize().width , relocatei.getSize().height);
		
		relocatem = new JButton();
		relocatem.setText("Relocate unit from marching");
		relocatem.setSize(relocatem.getPreferredSize());
		relocatem.setBounds(800,600 , relocatem.getSize().width , relocatem.getSize().height);
		
		relocateb = new JButton();
		relocateb.setText("Relocate unit from besieging");
		relocateb.setSize(relocateb.getPreferredSize());
		relocateb.setBounds(1100,600 , relocateb.getSize().width , relocateb.getSize().height);
		
		String ad = "my Idle Armies:\n";
		String besiege ="my Besiege Armies:\n";
		String marching ="my Marching Armies:\n";
		
		int i =1 ;
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
			}
			i =0 ;
			if(a.getCurrentStatus()==Status.BESIEGING) {
				besiege+= "Army" + i + "\n";
				besiege += "Besieged City : " + a.getCurrentLocation() + "\n";
				
				int turnsunder =0 ;				
				for(City c : availablecities) {
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
			}
		}
		
		j.setText(ad);
		j.setFont(new Font(choose.getFont().getName(),Font.BOLD,25));
		j.setSize(j.getPreferredSize().width , j.getPreferredSize().height);
		j.setBounds(0,0,300,600);
		
		jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.setSize(300, 600);
		jp.setBounds(0,0 ,300 , 600);
		
		jscroll = new JScrollPane(j , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		jscroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
		jscroll.setBounds(0,0 , 300 , 600);
		jscroll.setViewportView(j);
		
		jp.add(jscroll);
		add(jp);
		
		
		
		
		/*JLabel jj = new JLabel();
		jj.add(j);
		jj.setText(j.getText());
		jj.setSize(j.getSize().width , j.getSize().height);
		jj.setBounds(0 , 0 , j.getSize().width,j.getSize().height);
		jj.setBorder(null);*/
		
		back = new JButton();
		back.setText("Back");
		back.setFont(new Font(choose.getFont().getName(),Font.BOLD,30));
		back.setSize(back.getPreferredSize().width , back.getPreferredSize().height);
		back.setBorder(null);
		
		JLabel backl = new JLabel();
		backl.add(back);
		backl.setText(back.getText());
		backl.setSize(back.getSize().width,back.getSize().height);
		backl.setBounds(650 , 20 , backl.getSize().width , backl.getSize().height);
		backl.setBorder(null);
		
		this.remove(choose);
		mar.setText(marching);
		mar.setFont(new Font(choose.getFont().getName(),Font.BOLD,20));
		mar.setSize(300 ,600);
		mar.setBounds(800,0,mar.getSize().width,mar.getSize().height);
		
		marp = new JPanel();
		marp.setLayout(new GridLayout(1,4));
		marp.setSize(300, 600);
		marp.setBounds(800,0 ,300 , 600);
		
		marscroll = new JScrollPane(mar , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		marscroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
		marscroll.setBounds(800,0 , 300 , 600);
		marscroll.setViewportView(mar);
		
		marp.add(marscroll);
		add(marp);
		
		
		
		be.setText(besiege);
		be.setFont(new Font(choose.getFont().getName(),Font.BOLD,20));
		be.setSize(be.getPreferredSize().width , be.getPreferredSize().height);
		be.setBounds(1100,0,300,600);
		
		bep = new JPanel();
		bep.setLayout(new GridLayout(1,4));
		bep.setSize(300, 600);
		bep.setBounds(1100,0 ,300 , 600);
		
		bescroll = new JScrollPane(be , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		bescroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
		bescroll.setBounds(1100,0 , 300 , 600);
		bescroll.setViewportView(be);
		
		bep.add(bescroll);
		add(bep);
		
		
		add ( backl);
		add(relocatei);
		add(relocateb);
		add(relocatem);
		add(targetcity);
		add(label);
		
		
		
		
		this.getContentPane().repaint();
	}
	
	
	public JButton getBack() {
		return back;
	}


	public void setAvailablecities(ArrayList<City> availablecities) {
		this.availablecities = availablecities;
	}


	public ArrayList<City> getAvailablecities() {
		return availablecities;
	}


	public JTextArea getJ() {
		return j;
	}


	public JTextArea getBe() {
		return be;
	}


	public JTextArea getMar() {
		return mar;
	}


	public JButton getRelocatei() {
		return relocatei;
	}


	public JButton getRelocatem() {
		return relocatem;
	}


	public JButton getRelocateb() {
		return relocateb;
	}


	public JScrollPane getJscroll() {
		return jscroll;
	}


	public JScrollPane getBescroll() {
		return bescroll;
	}


	public JScrollPane getMarscroll() {
		return marscroll;
	}


	public JPanel getJp() {
		return jp;
	}


	public JPanel getBep() {
		return bep;
	}


	public JPanel getMarp() {
		return marp;
	}


	public JButton getTargetcity() {
		return targetcity;
	}
	
	
}
