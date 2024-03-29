package kr.ac.woosuk.java.fsg.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.views.BombBoard;
import kr.ac.woosuk.java.fsg.views.GameView;
import kr.ac.woosuk.java.fsg.views.LifeBoard;
import kr.ac.woosuk.java.fsg.views.ScoreBoard;

public class Controller implements Runnable {


	private List<Doctor> doctors;
    private List<Enemy> enemies;
    private List<DoctorShot> doctorshots;
    private List<EnemyShot> enemyShots;
    private List<Item> items;
    private GameView gameView;
	private List<Stage> stages;
	private int score;
	private int life;
	private int bomb;
    
    public Controller(GameView gameview) {
    	this.gameView = gameview;
    	this.doctorshots = new ArrayList<DoctorShot>();
    	this.enemies = new ArrayList<Enemy>();
    	this.enemyShots = new ArrayList<EnemyShot>();
    	this.doctors = new ArrayList<Doctor>();
    	this.items = new ArrayList<Item>();
    	this.stages = new ArrayList<Stage>();
    	this.stages.add(new Stage1(this));
    	this.stages.add(new Stage2(this));
    	this.stages.add(new Stage3(this));
    	this.stages.add(new Stage4(this));
    	this.stages.add(new Stage5(this));
		this.stages.add(new BossStage(this));
	}
    
	public GameView getGameView() {
		return gameView;
	}
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        this.getGameView().add(doctor);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
        this.getGameView().add(enemy);
    }

    public void removeDoctor(Doctor doctor) {
        this.doctors.remove(doctor);
        this.getGameView().remove(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
        this.getGameView().remove(enemy);
    }

	public void addDoctorShot(DoctorShot shot) {
		this.doctorshots.add(shot);
		this.getGameView().add(shot);
	}

    public List<DoctorShot> getDoctorshots() {
		return doctorshots;
	}

	public void removeDoctorShot(DoctorShot shot) {
		this.doctorshots.remove(shot);
		this.getGameView().remove(shot);
	}

	public void addEnemyShot(EnemyShot shot) {
		this.enemyShots.add(shot);
		this.getGameView().add(shot);
	}

	public List<EnemyShot> getEnemyshots() {
		return enemyShots;
	}

	public void removeEnemyShot(EnemyShot shot) {
		this.enemyShots.remove(shot);
		this.getGameView().remove(shot);
	}

	public void addItem(Item item) {
		this.items.add(item);
		this.getGameView().add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public void removeItem(Item item) {
		this.items.remove(item);
		this.getGameView().remove(item);
	}
	public void createEnemy(Enemy enemy, int x, int y) {
		addEnemy(enemy);
		enemy.setLocation(x, y);
		Thread thread = new Thread(enemy);
		thread.start();
	}
	public void changeScoreBoard() {
		ScoreBoard scoreBoard = (ScoreBoard) this.gameView.getScoreBoard();
		scoreBoard.changeScoreBoardScore(this.score);
	}
	public void addScore(int score) {
		this.score += score;
		this.changeScoreBoard();
	}
	public void changeLifeBoard() {
		LifeBoard lifeBoard = (LifeBoard) this.gameView.getLifeBoard();
		lifeBoard.changeLifeBoardLife(this.life);
	}
	public void changeLife(Doctor doctor) {
		this.life = doctor.getLife();
		this.changeLifeBoard();
	}
	public void changeBombBoard() {
		BombBoard bombBoard = (BombBoard) this.gameView.getBombBoard();
		bombBoard.changeBombBoardBomb(this.bomb);
	}
	public void changeBomb(Doctor doctor) {
		this.bomb = doctor.getBombScore();
		this.changeBombBoard();
	}
	
	@Override
	public void run() {
		for(Stage stage : this.stages) {
			try {
				stage.startStage();
				stage.runningStage();
				while(!this.isCompleteStage() && !this.DoctorDie()) {
					Thread.sleep(100);
				}
				if(this.isCompleteStage()) {
				stage.endStage();
				}
				if(this.DoctorDie()) {
				stage.gameOver();
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All Stage Complete!!");
	}
	public boolean isCompleteStage() {
			if(getEnemies().size() > 0) {
				return false;
		}
		return true;
	}
	public boolean DoctorDie() {
		if(getDoctors().size() > 0) {
			return false;
		}
	return true;
	}

}