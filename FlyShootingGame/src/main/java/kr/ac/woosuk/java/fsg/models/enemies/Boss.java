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

public class Boss extends Enemy{
	
	public Boss(Controller controller) {
		super(controller);
		this.hppoint = 9999;
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgboss.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}

	@Override
	public void run() {
		int attackdelay = 0;
		int pattern = 1;
		int pattern1 = 0;
		int pattern2 = 0;
		while (this.hppoint > 0) {
			while (this.hppoint > 0) {
				try {
					if(pattern == 1) {
						if(pattern1 == 0 && pattern == 1) {
							if (this.getX() >= 10 && pattern1 == 0) {
								this.setLocation(this.getX()-10, this.getY());
								if(this.getX() <= 10) {
									pattern1 = 1;
								}
							}
						}
						if(pattern1 == 1 && pattern == 1) {
							if (this.getX() <= 500 && pattern1 == 1) {
								this.setLocation(this.getX()+10, this.getY());
								if(this.getX() >= 500) {
									pattern1 = 2;
								}
							}
						}
						if(pattern1 == 2 && pattern == 1) {
							if(this.getX() >= 260 && pattern1 == 2) {
								this.setLocation(this.getX()-10, this.getY());
								if(this.getX() <= 260) {
									pattern1 = 3;
								}
							}
						}
						if(pattern1 == 3 && pattern == 1) {
							this.bosslazer();
							Thread.sleep(2500);
							pattern1 = 0;
						}
						if(this.hppoint <= 5000) {
							pattern = 2;
							System.out.println("2번째 패턴 시작!");
						}
					}
					if(pattern == 2) {
						if(pattern2 == 0) {
							this.setBounds(260, this.getY(), this.getWidth(), this.getHeight());
							pattern2++;
						}
						if(pattern2 == 1) {
							this.bossrush();
							Thread.sleep(2500);
							pattern2++;
						}
						if(pattern2 == 2) {
							this.setLocation(this.getX(), this.getY()-10);
							if(this.getY() <= 10) {
								pattern2++;
							}
						}
						if(pattern2 == 3) {
							this.setLocation(this.getX()-10, this.getY());
							if(this.getX() <= 10) {
								pattern2++;
							}
						}
						if(pattern2 == 4) {
							this.setLocation(this.getX()+10, this.getY());
							this.bosslazer();
							if(this.getX() >= 425) {
								Thread.sleep(3000);
								pattern2++;
							}
						}
						if(pattern2 == 5) {
							this.setLocation(this.getX()+10, this.getY());
							if(this.getX() >= 550) {
								pattern2++;
							}
						}
						if(pattern2 == 6) {
							this.setLocation(this.getX()-10, this.getY());
							this.bosslazer();
							if(this.getX() <= 100) {
								Thread.sleep(4500);
								pattern2++;
							}
						}
						if(pattern2 == 7) {
							this.setLocation(this.getX()+10, this.getY());
							if(this.getX() >= 260) {
								this.setLocation(this.getX(), this.getY()+10);
								if(this.getY()<=150) {
									pattern2 = 0;
								}
							}
						}
					}
					
					if(attackdelay%10 == 0) {
					this.attack();
					}
					attackdelay++;
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		this.controller.removeEnemy(this);
	}
}
