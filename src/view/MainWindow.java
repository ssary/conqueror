package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.StartingWindow;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	JLabel food ;
	JLabel money;
	JLabel turncount;
	JLabel name ;
	JButton map;
	public MainWindow() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,800);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		setTitle("Conqueror");
		food = new JLabel();
		money = new JLabel();
		turncount = new JLabel();
		name = new JLabel();
		map = new JButton();
		map.setText("World Map");
		map.setSize(map.getPreferredSize().width , map.getPreferredSize().height);
		setVisible(true);
		add(food);
		add(money);
		add(turncount);
		add(name);
		add(map);
	}
	public JLabel getFood() {
		return food;
	}
	public JLabel getMoney() {
		return money;
	}
	public JLabel getTurncount() {
		return turncount;
	}
	public JLabel getname() {
		return name;
	}
	public JButton getMap() {
		return map;
	}
	
}
