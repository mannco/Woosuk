package kr.ac.woosuk.java.fsg.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public class Controller {
    private Doctor doctors;
    private List<Enemy> enemies;

    public void setDoctors(Doctor doctors) {
        this.doctors = doctors;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }



    public void addDoctor(Doctor doctor) {
        // TODO Auto-generated method stub
        this.doctors = doctor;
    }

    public void addEnemy(Enemy enemy) {
        // TODO Auto-generated method stub
        this.enemies = new ArrayList<Enemy>();
    }

    public void removeDoctor() {
        // TODO Auto-generated method stub
        this.doctors = null;
    }

    public Doctor getDoctors() {
        // TODO Auto-generated method stub
        return doctors;
    }

    public void removeEnemy(Enemy enemy) {
        // TODO Auto-generated method stub
        this.enemies.remove(enemy);
    }


}