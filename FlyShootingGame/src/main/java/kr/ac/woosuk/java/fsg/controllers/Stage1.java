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
		
		
		Item item = new LifeUp(this.controller);
		this.controller.addItem(item);
		item.setLocation(300, 300);
		Thread thread2 = new Thread(item);
		thread2.start();
		
		Item item2 = new PowerUp(this.controller);
		this.controller.addItem(item2);
		item2.setLocation(300, 400);
		Thread thread3 = new Thread(item2);
		thread3.start();
		
		Item item3 = new ThumbsUp(this.controller);
		this.controller.addItem(item3);
		item3.setLocation(400, 300);
		Thread thread4 = new Thread(item3);
		thread4.start();
		
		Item item4 = new AlcoholBombUp(this.controller);
		this.controller.addItem(item4);
		item4.setLocation(400, 400);
		Thread thread5 = new Thread(item4);
		thread5.start();
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 1 Completed.");
	}

}
