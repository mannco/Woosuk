package kr.ac.woosuk.java.fsg.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public class Controller {

	private Doctor doctors;
	private List<Enemy> enemies;
	
	public void addDoctor(Doctor doctor) {
		this.doctors=doctor;
	}


	public void addEnemy(Enemy enemy) {
		this.enemies = new ArrayList<Enemy>();
	}
}
