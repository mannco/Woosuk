package kr.ac.woosuk.java.fsg.controllers;

import kr.ac.woosuk.java.fsg.models.enemies.Bacteria;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;

public class Stage2 implements Stage {

	private Controller controller;
	
	public Stage2(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
		System.out.println("Stage 2 start");
		Thread.sleep(5000);
	}

	@Override
	public void runningStage() throws InterruptedException {
		
		this.controller.createEnemy(new Virus(this.controller), 0, 0);
		this.controller.createEnemy(new Virus(this.controller), 480, 0);
		
		this.controller.createEnemy(new Bacteria(this.controller), 120, 0);
		this.controller.createEnemy(new Bacteria(this.controller), 240, 100);
		this.controller.createEnemy(new Bacteria(this.controller), 360, 0);
		this.controller.createEnemy(new Bacteria(this.controller), 500, 100);
	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 2 Completed.");
	}

	@Override
	public void gameOver() throws InterruptedException {
		System.out.println("���Ͱ� �׾����ϴ�.");
		Thread.sleep(10000000);
	}
}
