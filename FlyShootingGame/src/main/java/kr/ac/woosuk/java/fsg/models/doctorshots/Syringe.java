package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
public class Syringe extends DoctorShot {
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource(this.path));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public Syringe(Controller controller, int x, int y) {
		super(controller,x,y);
		this.attackpoint = 10;
	}

	@Override
	public void run() {
		flag : while (this.getY() >= 0) {
			try {
				if(this.attackpoint == 10) {
					this.path = "/kr/ac/woosuk/java/fsg/images/imgsyringe.png";
				} else if(this.attackpoint > 10) {
					this.path = "/kr/ac/woosuk/java/fsg/images/imgsyringered.png";
				}
				this.setLocation(this.getX(), this.getY()-20);
				List<Enemy> enemies = this.controller.getEnemies();
				for(Enemy enemy : enemies) {
					if(this.getX() <= enemy.getX()+75 && this.getX() >= enemy.getX() && this.getY()-5 <= enemy.getY()) {
						this.attackEnemy(enemy);
						System.out.println(enemy.getHppoint());
						this.controller.removeDoctorShot(this);
						break flag;
					}
				}
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeDoctorShot(this);
	}
}
