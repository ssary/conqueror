package view;
import controller.*;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class BattleView extends JFrame{

	JButton back;
	JComboBox myarmy , defendingarmy;
	
	public BattleView () {
		super();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(1400,800);
		this.setResizable(false);
		setTitle("Battle");
		
		
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JComboBox getMyarmy() {
		return myarmy;
	}

	public void setMyarmy(JComboBox myarmy) {
		this.myarmy = myarmy;
	}

	public JComboBox getDefendingarmy() {
		return defendingarmy;
	}

	public void setDefendingarmy(JComboBox defendingarmy) {
		this.defendingarmy = defendingarmy;
	}
	
}
