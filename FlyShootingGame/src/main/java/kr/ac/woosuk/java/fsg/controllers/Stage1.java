package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;


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
		
		this.controller.createEnemy(new Virus(this.controller), 0, 0);
		this.controller.createEnemy(new Virus(this.controller), 120, 0);
		this.controller.createEnemy(new Virus(this.controller), 240, 0);
		this.controller.createEnemy(new Virus(this.controller), 360, 0);
		this.controller.createEnemy(new Virus(this.controller), 480, 0);
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 1 Completed.");
	}
	
	@Override
	public void gameOver() throws InterruptedException {
		System.out.println("´ÚÅÍ°¡ Á×¾ú½À´Ï´Ù.");
		Thread.sleep(10000000);
	}

}
