package kr.ac.woosuk.java.fsg.controllers;

public class Stage2 implements Stage {

	private Controller controller;
	
	public Stage2(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void startStage() throws InterruptedException {
		System.out.println("Stage 2 start");
		Thread.sleep(2000);
	}

	@Override
	public void runningStage() throws InterruptedException {
		

	}

	@Override
	public void endStage() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Stage 2 Completed.");
	}


}
