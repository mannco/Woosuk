package kr.ac.woosuk.java.fsg.views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorBlue;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorGreen;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Bacteria;
import kr.ac.woosuk.java.fsg.models.enemies.Boss;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Germ;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.BacteriaShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.BossShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.GermShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;

public class GameView extends JPanel implements Runnable {
	private JLabel scoreBoard;
	private JLabel lifeBoard;
	private JLabel bombBoard;
	
	private Controller controller;
	
	public Controller getGameController() {
		return controller;
	}
	
	public GameView() {
		this.controller = new Controller(this);
		Thread thread = new Thread(this.controller);
		thread.start();
		init();
	}
	
	private void init() {
		this.setSize(600, 800);
		this.setLayout(null);
		this.scoreBoard = new ScoreBoard();
		this.add(this.scoreBoard);
		this.lifeBoard = new LifeBoard();
		this.add(this.lifeBoard);
		this.bombBoard = new BombBoard();
		this.add(this.bombBoard);
		
		//TEST Doctor
//		Doctor doctor = new DoctorRed(controller);
//		this.add(doctor);
//		doctor.setLocation(50, 200);
		
//		doctor = new DoctorBlue(controller);
//		this.add(doctor);
//		doctor.setLocation(50, 300);
//		
//		doctor = new DoctorGreen(controller);
//		this.add(doctor);
//		doctor.setLocation(50, 400);
		
		//TEST Enemy
//		Enemy enemy = new Virus(controller);
//		this.add(enemy);
//		enemy.setLocation(150, 200);
//		
//		enemy = new Germ(controller);
//		this.add(enemy);
//		enemy.setLocation(150, 300);
//		
//		enemy = new Boss(controller);
//		this.add(enemy);
//		enemy.setLocation(150, 400);
//		
//		enemy = new Bacteria(controller);
//		this.add(enemy);
//		enemy.setLocation(150, 500);
		
		//TEST DoctorShot
//		DoctorShot doctorshot = new AlcoholBomb();
//		this.add(doctorshot);
//		doctorshot.setLocation(250, 200);
//		
//		doctorshot = new Syringe();
//		this.add(doctorshot);
//		doctorshot.setLocation(250, 300);
		
		//TEST EnemyShot
/*		EnemyShot enemyshot = new VirusShot();
		this.add(enemyshot);
		enemyshot.setLocation(350, 200);
		
		enemyshot = new BacteriaShot();
		this.add(enemyshot);
		enemyshot.setLocation(350, 300);
		
		enemyshot = new BossShot();
		this.add(enemyshot);
		enemyshot.setLocation(350, 400);
		
		enemyshot = new GermShot();
		this.add(enemyshot);
		enemyshot.setLocation(350, 500);	*/
		
		this.setFocusable(false);
		//doctor.requestFocus();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
//		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/mainBG.png"));
//		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
//		setOpaque(false);
		super.paintComponent(g);
	}
	
	public JLabel getSunBoard() {
		return this.scoreBoard;
	}
	
	@Override
	public void run() {
		
		while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
			
	}

	public JLabel getScoreBoard() {
		return this.scoreBoard;
	}

	public JLabel getLifeBoard() {
		return this.lifeBoard;
	}

	public JLabel getBombBoard() {
		return this.bombBoard;
	}
	
}
