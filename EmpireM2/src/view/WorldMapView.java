package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WorldMapView extends ChooseCityWindow implements ActionListener{
	 
	public WorldMapView() {
		super();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JTextArea j = new JTextArea();
		j.setEditable(false);
		j.setLineWrap(true);
		j.setText("Idle Armies:\nasdsa");
		j.setBorder(null);
		j.setFont(new Font(choose.getFont().getName(),Font.BOLD,25));
		
		j.setSize(j.getPreferredSize().width , j.getPreferredSize().height);
		j.setBounds(100,100,j.getSize().width*2,j.getSize().height*2);
		
		add(j);
		add(label);
		
		
	}
	
	
}
