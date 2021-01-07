package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.items.AlcoholBombUp;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.LifeUp;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;


public class Stage1 implements Stage {

	private Controller controller;
	
	public Stage1(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
		Doctor doctor = new DoctorRed(this.controller);
		this.controller.addDoctor(doctor);
		doctor.setLocation(400, 600);
		Thread thread = new Thread(doctor);
		thread.start();
		System.out.println("Stage 1 start");
		Thread.sleep(2000);
	}

	@Override
	public void runningStage() throws InterruptedException {
		
		Enemy enemy =  new Virus(this.controller);
		this.controller.addEnemy(enemy);
		enemy.setLocation(200, 200);
		Thread thread = new Thread(enemy);
		thread.start();
		
		Enemy enemy2 =  new Virus(this.controller);
		this.controller.addEnemy(enemy2);
		enemy2.setLocation(200, 400);
		Thread thread2 = new Thread(enemy2);
		thread2.start();
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 1 Completed.");
	}

}
