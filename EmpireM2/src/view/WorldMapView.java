package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JButton back;
	
	public WorldMapView(ArrayList<Army> army) {
		super();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		
		this.setLayout(null);
		JTextArea j = new JTextArea();
		j.setEditable(false);
		j.setLineWrap(true);
		j.setBorder(null);
		
		JTextArea be = new JTextArea();
		be.setEditable(false);
		be.setLineWrap(true);
		be.setBorder(null);
		
		JTextArea mar = new JTextArea();
		mar.setEditable(false);
		mar.setLineWrap(true);
		mar.setBorder(null);
		
		
		
		String ad = "my Idle Armies:\n";
		String besiege ="my Besiege Armies:\n";
		String marching ="my Marching Armies:\n";
		
		int i =1 ;
		for(Army a : army) {
			if(a.getCurrentStatus()==Status.IDLE) {
			System.out.println("aw");
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
		j.setBounds(0,0,j.getSize().width,j.getSize().height);
		
		add(j);
		
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
		backl.setBounds(700 , 20 , backl.getSize().width , backl.getSize().height);
		backl.setBorder(null);
		
		this.remove(choose);
		mar.setText(marching);
		mar.setFont(new Font(choose.getFont().getName(),Font.BOLD,20));
		mar.setSize(mar.getPreferredSize().width , mar.getPreferredSize().height);
		mar.setBounds(150,0,mar.getSize().width,mar.getSize().height);
		add(mar);
		
		be.setText(besiege);
		be.setFont(new Font(choose.getFont().getName(),Font.BOLD,20));
		be.setSize(be.getPreferredSize().width , be.getPreferredSize().height);
		be.setBounds(300,0,be.getSize().width,be.getSize().height);
		add ( backl);
		add(be);
		add(label);
		
		
		
		
		this.getContentPane().repaint();
	}
	
	
	public JButton getBack() {
		return back;
	}


	public void setAvailablecities(ArrayList<City> availablecities) {
		this.availablecities = availablecities;
	}
	
	
}
