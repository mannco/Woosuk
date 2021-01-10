package kr.ac.woosuk.java.fsg.models.enemies;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.items.AlcoholBombUp;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.LifeUp;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;

public class Germ extends Enemy{
	
	public Germ(Controller controller) {
		super(controller);
		this.hppoint = 30;
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
		int j = 0; //공격딜레이
		int k = 0; //좌우움직임
		int l = 0; //가운데서 꺾이게 하는것
		while (this.hppoint > 0) {
			try {
				if(this.getX()==250 && k == 0) {
					l = 1;
				}
				if(this.getX()==250 && k == 1) {
					l = 0;
				}
				if(k == 0 && l == 0) {
					this.setLocation(this.getX()+10, this.getY()+5);
				}
				if(k == 1 && l == 1) {
					this.setLocation(this.getX()-10, this.getY()+5);
				}
				if(k == 0 && l == 1) {
					this.setLocation(this.getX()+10, this.getY()-5);
				}
				if(k == 1 && l == 0) {
					this.setLocation(this.getX()-10, this.getY()-5);
				}
				if(this.getX()>=525) {
					k = 1;
					l = 1;
				}
				if(this.getX()<0) {
					k = 0;
					l = 0;
				}
				if(this.getY() >= 800) {
					this.controller.removeEnemy(this);
				}
				if(j%15 == 0) {
				this.attack();
				}
				j++;
				Thread.sleep(200);
				if(this.hppoint <= 0) {
					this.controller.removeEnemy(this);
				}
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
		this.controller.addScore(10);
	}


}
