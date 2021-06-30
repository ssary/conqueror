package view;
import controller.*;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class BattleView extends JFrame{

	JButton back;
	JComboBox<String> myarmy , defendingarmy;
	
	public BattleView () {
		super();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(1400,800);
		this.setResizable(false);
		setTitle("Battle");
	 	back = new JButton();
		back.setText("Back");
		back.setFont(new Font(back.getFont().getName(),Font.BOLD,30));
		back.setSize(back.getPreferredSize().width , back.getPreferredSize().height);
		back.setBorder(null);
		
		this.setVisible(true);
		
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

	public JComboBox<String> getDefendingarmy() {
		return defendingarmy;
	}

	public void setDefendingarmy(JComboBox<String> defendingarmy) {
		this.defendingarmy = defendingarmy;
	}
	
}
