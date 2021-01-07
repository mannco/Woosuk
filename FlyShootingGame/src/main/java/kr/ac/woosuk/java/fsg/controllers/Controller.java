package kr.ac.woosuk.java.fsg.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.views.GameView;

public class Controller implements Runnable {


	private List<Doctor> doctors;
    private List<Enemy> enemies;
    private List<DoctorShot> doctorshots;
    private List<EnemyShot> enemyShots;
    private List<Item> items;
    private GameView gameView;
	private List<Stage> stages;
    
    public Controller(GameView gameview) {
    	this.gameView = gameview;
    	this.doctorshots = new ArrayList<DoctorShot>();
    	this.enemies = new ArrayList<Enemy>();
    	this.enemyShots = new ArrayList<EnemyShot>();
    	this.doctors = new ArrayList<Doctor>();
    	this.items = new ArrayList<Item>();
    	this.stages = new ArrayList<Stage>();
		this.stages.add(new Stage1(this));
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
	public void createEnemy() {
		
	}

	@Override
	public void run() {
		for(Stage stage : this.stages) {
			try {
				stage.startStage();
				stage.runningStage();
				while(!this.isCompleteStage()) {
					Thread.sleep(100);
				}
				if(this.isCompleteStage()) {
				stage.endStage();
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
}