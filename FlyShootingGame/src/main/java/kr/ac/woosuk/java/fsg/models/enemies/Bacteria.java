package kr.ac.woosuk.java.fsg.models.enemies;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bacteria extends Enemy{
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgbacteria.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	

}
