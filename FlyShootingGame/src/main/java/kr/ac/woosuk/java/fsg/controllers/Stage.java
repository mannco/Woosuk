package kr.ac.woosuk.java.fsg.controllers;

public interface Stage {
	public abstract void startStage() throws InterruptedException;
	public abstract void runningStage() throws InterruptedException;
	public abstract void endStage() throws InterruptedException;
	public abstract void gameOver() throws InterruptedException;
}
