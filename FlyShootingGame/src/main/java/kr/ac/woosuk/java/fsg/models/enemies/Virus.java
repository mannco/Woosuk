package kr.ac.woosuk.java.fsg.models.enemies;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;

public class Virus extends Enemy{
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgvirus.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public Virus(Controller controller) {
		super(controller);
		this.hppoint = 20;
	}

	@Override
	public void run() {
		while (this.hppoint > 0) {
			try {
				
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeEnemy(this);
	}
	
}