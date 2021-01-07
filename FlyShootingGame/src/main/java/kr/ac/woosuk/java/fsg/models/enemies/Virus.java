package kr.ac.woosuk.java.fsg.models.enemies;

import java.awt.Graphics;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.items.AlcoholBombUp;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.LifeUp;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;

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
		int j = 0;
		while (this.hppoint > 0) {
			try {
				this.setLocation(this.getX(), this.getY()+5);
				if(this.getY() >= 800) {
					this.controller.removeEnemy(this);
				}
				if(j%15 == 0) {
				this.attack();
				}
				
				j++;
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Random random = new Random();
		int i = random.nextInt(20);
		if(i == 0) {
			Item item = new AlcoholBombUp(controller, this.getX(), this.getY());
			this.controller.addItem(item);
			Thread thread = new Thread(item);
			thread.start();
		} else if(i == 1){
			Item item = new LifeUp(controller, this.getX(), this.getY());
			this.controller.addItem(item);
			Thread thread = new Thread(item);
			thread.start();
		} else if(i == 2){
			Item item = new PowerUp(controller, this.getX(), this.getY());
			this.controller.addItem(item);
			Thread thread = new Thread(item);
			thread.start();
		} else if(i == 3){
			Item item = new ThumbsUp(controller, this.getX(), this.getY());
			this.controller.addItem(item);
			Thread thread = new Thread(item);
			thread.start();
		}
		this.controller.removeEnemy(this);
	}
	
}