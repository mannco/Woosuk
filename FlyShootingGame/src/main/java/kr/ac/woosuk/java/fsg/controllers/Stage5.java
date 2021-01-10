package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.enemies.Bacteria;
import kr.ac.woosuk.java.fsg.models.enemies.Germ;

public class Stage5 implements Stage{
	private Controller controller;
	
	public Stage5(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
		System.out.println("Stage 5 start");
		Thread.sleep(5000);
	}

	@Override
	public void runningStage() throws InterruptedException {
		this.controller.createEnemy(new Bacteria(this.controller), 0, 100);
		this.controller.createEnemy(new Bacteria(this.controller), 120, 0);
		this.controller.createEnemy(new Bacteria(this.controller), 240, 100);
		this.controller.createEnemy(new Bacteria(this.controller), 360, 0);
		this.controller.createEnemy(new Bacteria(this.controller), 480, 0);
		this.controller.createEnemy(new Bacteria(this.controller), 300, 200);

		this.controller.createEnemy(new Germ(this.controller), 0, 200);
		this.controller.createEnemy(new Germ(this.controller), 120, 100);
		this.controller.createEnemy(new Germ(this.controller), 240, 200);
		this.controller.createEnemy(new Germ(this.controller), 360, 100);
		this.controller.createEnemy(new Germ(this.controller), 480, 200);
		this.controller.createEnemy(new Germ(this.controller), 180, 100);
		this.controller.createEnemy(new Germ(this.controller), 400, 100);
		this.controller.createEnemy(new Germ(this.controller), 300, 200);
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 5 Completed.");
	}

	@Override
	public void gameOver() throws InterruptedException {
		System.out.println("´ÚÅÍ°¡ Á×¾ú½À´Ï´Ù.");
		Thread.sleep(10000000);
	}
}
