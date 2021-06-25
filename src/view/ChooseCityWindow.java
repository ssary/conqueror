package view;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ChooseCityWindow extends JFrame implements ActionListener{
	
	JLabel choose ;
	JLabel label ;
	JLabel buttons ;
	JLabel buttonr ;
	JLabel buttonca ;
	JButton rome;
	JButton sparta;
	JButton cairo;
	String chosen; 
	boolean pressed =false;
	
	public ChooseCityWindow() {
	super();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1400,800);
	this.setResizable(false);
	//this.setLayout(new FlowLayout());
	this.setLayout(null);
	setTitle("Conqueror");
	ImageIcon mapimage = new ImageIcon("map.jpg");
	
	label =  new JLabel();
	label.setBounds(0,0,1400,800);
	label.setIcon(mapimage);	
	
	choose = new JLabel("choose a city to play with : ");
	choose.setFont(new Font(choose.getFont().getName(),Font.BOLD,10));
	choose.setSize(choose.getPreferredSize().width ,choose.getPreferredSize().height );
	choose.setBounds(50,10 ,choose.getSize().width ,choose.getSize().height);
	choose.setBorder(null);
	
	rome = new JButton();
	rome.setText("Rome");
	rome.setSize(rome.getPreferredSize().width,rome.getPreferredSize().height);
	rome.setBorder(null);
	
	cairo = new JButton();
	cairo.setText("CAIRO");
	cairo.setSize(cairo.getPreferredSize().width,cairo.getPreferredSize().height);
	cairo.setBorder(null);
	
	sparta = new JButton();
	sparta.setText("SPARTAA");
	sparta.setSize(sparta.getPreferredSize().width,sparta.getPreferredSize().height);
	sparta.setBorder(null);
	
	rome.addActionListener(this);
	cairo.addActionListener(this);
	sparta.addActionListener(this);
	
	
	buttons = new JLabel();
	buttons.add(sparta);
	buttons.setText(sparta.getText());
	buttons.setSize(sparta.getSize().width,sparta.getSize().height);
	buttons.setBounds(670, 300,buttons.getSize().width,(int) buttons.getSize().height);
	buttons.setBorder(null);
	
	buttonr = new JLabel();
	buttonr.add(rome);
	buttonr.setText(rome.getText());
	buttonr.setSize(rome.getSize().width,rome.getSize().height);
	buttonr.setBounds(560, 300,buttonr.getSize().width, buttonr.getSize().height);
	
	buttonca = new JLabel();
	buttonca.add(cairo);
	buttonca.setText(cairo.getText());
	buttonca.setSize(cairo.getSize().width,cairo.getSize().height);
	buttonca.setBounds(700, 400,buttonca.getSize().width, buttonca.getSize().height);
	
	add(choose);
	add(buttonr);
	add(buttonca);
	add(buttons);
	add(label);
	setVisible(true);
	
	
	}


	public JLabel getChoose() {
		return choose;
	}


	public JLabel getLabel() {
		return label;
	}


	public JLabel getButtons() {
		return buttons;
	}


	public JButton getRome() {
		return rome;
	}


	public JButton getSparta() {
		return sparta;
	}


	public JButton getCairo() {
		return cairo;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		pressed = true;
		if(e.getSource() == rome) {
			chosen = "Rome";
		}
		else if(e.getSource() == cairo) {
			chosen = "Cairo";}
		else if(e.getSource() == sparta) {
			chosen = "Sparta";
		}
	}
	
	public String getChosen() {
		return chosen;
	}
	public boolean getPressed() {
		return pressed;
	}
	
	public void 	clearall() {
		label.setVisible(false);
		buttonr.setVisible(false);
		buttonca.setVisible(false);
		buttons.setVisible(false);
	}
}
