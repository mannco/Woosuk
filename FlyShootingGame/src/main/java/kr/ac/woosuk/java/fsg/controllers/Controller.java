package kr.ac.woosuk.java.fsg.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.items.Item;

public class Controller {
	private Doctor doctors;
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<DoctorShot> doctorshots = new ArrayList<DoctorShot>();
    private List<EnemyShot> enemyShots = new ArrayList<EnemyShot>();
    private List<Item> items = new ArrayList<Item>();
    
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
        // TODO Auto-generated method stub
        this.enemies.remove(enemy);
    }

	public void addDoctorShot(DoctorShot shot) {
		// TODO Auto-generated method stub
		this.doctorshots.add(shot);
	}

    public List<DoctorShot> getDoctorshots() {
		return doctorshots;
	}

	public void removeDoctorShot(DoctorShot shot) {
		// TODO Auto-generated method stub
		this.doctorshots.remove(shot);
	}

	public void addEnemyShot(EnemyShot shot) {
		// TODO Auto-generated method stub
		this.enemyShots.add(shot);
	}

	public List<EnemyShot> getEnemyshots() {
		// TODO Auto-generated method stub
		return enemyShots;
	}

	public void removeEnemyShot(EnemyShot shot) {
		// TODO Auto-generated method stub
		this.enemyShots.remove(shot);
	}

	public void addItem(Item item) {
		// TODO Auto-generated method stub
		this.items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public void removeItem(Item item) {
		// TODO Auto-generated method stub
		this.items.remove(item);
	}


}