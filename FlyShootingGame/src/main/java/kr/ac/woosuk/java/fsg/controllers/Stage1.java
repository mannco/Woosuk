package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;


public class Stage1 implements Stage {

	private Controller controller;
	
	public Stage1(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
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

	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 1 Completed.");
	}

}
