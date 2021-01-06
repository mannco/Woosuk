package kr.ac.woosuk.java.fsg.models.enemies;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;

public class Germ extends Enemy{
	
	public Germ(Controller controller) {
		super(controller);
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imggerm.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}

	@Override
	public void run() {
		
	}


}
