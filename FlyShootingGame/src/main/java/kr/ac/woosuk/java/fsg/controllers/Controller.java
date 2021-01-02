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


	private Doctor doctors;
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<DoctorShot> doctorshots;
    private List<EnemyShot> enemyShots = new ArrayList<EnemyShot>();
    private List<Item> items = new ArrayList<Item>();
    private GameView gameView;
    
    public Controller(GameView gameview) {
    	this.gameView = gameview;
    	this.doctorshots = new ArrayList<DoctorShot>();
	}
    
	public GameView getGameView() {
		return gameView;
	}
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors = doctor;
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeDoctor() {
        this.doctors = null;
    }

    public Doctor getDoctors() {
        return doctors;
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
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
	}

	public void addEnemyShot(EnemyShot shot) {
		this.enemyShots.add(shot);
	}

	public List<EnemyShot> getEnemyshots() {
		return enemyShots;
	}

	public void removeEnemyShot(EnemyShot shot) {
		this.enemyShots.remove(shot);
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}
	public void createEnemy() {
		this.enemies.add(new Virus());
		this.enemies.add(new Virus());
		this.enemies.add(new Virus());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}