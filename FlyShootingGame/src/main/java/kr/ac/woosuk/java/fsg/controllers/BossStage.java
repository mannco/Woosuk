package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.enemies.Boss;

public class BossStage implements Stage {
	private Controller controller;
	
	public BossStage(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
		System.out.println("Boss Stage start");
		Thread.sleep(5000);
	}

	@Override
	public void runningStage() throws InterruptedException {
		
		this.controller.createEnemy(new Boss(this.controller), 250, 150);
	
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Boss Stage Completed.");
	}
	
	@Override
	public void gameOver() throws InterruptedException {
		System.out.println("´ÚÅÍ°¡ Á×¾ú½À´Ï´Ù. GAME OVER");
		Thread.sleep(10000000);
	}
}
