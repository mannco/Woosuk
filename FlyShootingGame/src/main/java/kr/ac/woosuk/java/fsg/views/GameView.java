package kr.ac.woosuk.java.fsg.views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.ac.woosuk.java.fsg.controllers.Controller;

public class GameView extends JPanel{
	private JLabel scoreBoard;
	private JPanel lifeBoard;
	
	private Controller gameController;
	
	public Controller getGameController() {
		return gameController;
	}
	
	public GameView() {
		init();
	}
	
	private void init() {
		this.setSize(600, 800);
		this.setLayout(null);
		this.scoreBoard = new ScoreBoard();
		this.add(this.scoreBoard);
		this.lifeBoard = new LifeBoard(this);
		this.add(this.lifeBoard);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/mainBG.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public JLabel getSunBoard() {
		return this.scoreBoard;
	}
}
