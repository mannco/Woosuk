package kr.ac.woosuk.java.fsg.views;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ScoreBoard extends JLabel {
	public ScoreBoard() {
		super("0");
		this.setBounds(17, 40, 70, 25);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
