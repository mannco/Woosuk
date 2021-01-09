package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public class AlcoholBomb extends DoctorShot {
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource(this.path));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public AlcoholBomb(Controller controller, int x, int y) {
		super(controller,x,y);
		this.attackpoint = 5000; //초기값 : 999
		this.path = "/kr/ac/woosuk/java/fsg/images/imgalcoholbomb.png";
	}

	@Override
	public void run() {
		int i=0;
		int j=0; //적에게 폭탄의 데미지가 1번만 들어가게 하기 위해 만들었습니다.
		this.setBounds(this.getX()-50, this.getY(), 100, 100);
		while (i < 53) {
			try {
				this.setLocation(this.getX(), this.getY()-10);
				if(i >= 50) {
					this.path = "/kr/ac/woosuk/java/fsg/images/imgsyringe.png";
					this.setBounds(this.getX(), this.getY(), 300, 300);
				List<Enemy> enemies = this.controller.getEnemies();
				if(j ==0) {
				for(Enemy enemy : enemies) {
					this.attackEnemy(enemy);
					System.out.println(enemy.getHppoint());
					j++;
					}
				}
				}
				i++;
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeDoctorShot(this);
	}
}
