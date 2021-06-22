package view;
import javax.swing.*;

import engine.Player;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class StartingWindow extends JFrame implements ActionListener{
	JButton button ;
	JTextField name;
	Player p ;
	boolean nextwindow = false;
	public StartingWindow() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,800);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		setTitle("Conqueror");
		
		name = new JTextField();
		name.setPreferredSize(new Dimension(250,40));
		
		add(name);
		
		
		button = new JButton();
		button.setText("Start");
		button.setActionCommand("EnterName");
		button.addActionListener(this);
		button.setSize( 100 , 100);
		button.setActionCommand(getName());
		add(button);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(button)) {
			
			String s = this.name.getText();
			
			
			if(!s.equals("")) {
				//p = new Player(s);
				//new MainWindow();
				//p.setTreasury(5000);
				
				nextwindow= true;
				//Control c = new Control();
				//c.setP(p);
				//dispose();
				}
//			else {
//				dispose();
//				StartingWindow w = new StartingWindow();
//				JLabel again = new JLabel("enter valid name");
				
//				again.setHorizontalTextPosition(JLabel.CENTER);
//				again.setVerticalTextPosition(JLabel.CENTER);
//				w.add(again);
//				}
			
		}
		
	}

	public boolean isNextwindow() {
		return nextwindow;
	}

	public String getNameText() {
		return name.getText();
	}
	
}
