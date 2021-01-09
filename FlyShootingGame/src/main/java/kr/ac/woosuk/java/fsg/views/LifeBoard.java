package kr.ac.woosuk.java.fsg.views;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LifeBoard extends JLabel {
	
	public LifeBoard() {
		super("0");
		this.setBounds(16, 733, 70, 25);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void changeLifeBoardLife(int life) {
		this.setText(life+"");
	}
}
