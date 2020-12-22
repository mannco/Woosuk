package kr.ac.woosuk.java.fsg.views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeBoard extends JPanel {
	private GameView gameView;
	
	public LifeBoard(GameView gameView) {
		this.gameView = gameView;
		this.setBounds(109, 10, 450, 84);
		this.setOpaque(false);
		this.setLayout(new GridLayout(1, 6, 3, 0));
		JLabel empty = new JLabel();
		this.add(empty);
	}
}
