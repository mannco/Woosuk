package kr.ac.woosuk.java.fsg.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;
import kr.ac.woosuk.java.fsg.views.GameView;

class ControllerTest {
	
	GameView gameview = new GameView();

    @Test
    void ���ͻ���_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Doctor doctor = new DoctorRed(controller);
        controller.addDoctor(doctor);

        assertNotNull(controller.getDoctors());
    }

    @Test
    void �ֳʹ̻���_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        controller.createEnemy();
        assertEquals(3, controller.getEnemies().size());
        controller.addEnemy(enemy);
        assertEquals(4, controller.getEnemies().size());
        
    }
    @Test
    void ���ͼҸ�_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Doctor doctor = new DoctorRed(controller);
        controller.addDoctor(doctor);
        assertNotNull(controller.getDoctors());

        controller.removeDoctor();

        assertNull(controller.getDoctors());

    }

    @Test
    void ���Ҹ�_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        controller.addEnemy(enemy);
        
        assertNotNull(controller.getEnemies());
  
        controller.removeEnemy(enemy);
        assertEquals(0, controller.getEnemies().size());
    }
    
    @Test
    void ���ͼ�����_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Doctor doctor = new DoctorRed(controller);
        DoctorShot shot = doctor.shot();
        controller.addDoctorShot(shot);
        
        assertNotNull(controller.getDoctorshots());
    }
    
    @Test
    void ���ͼ��Ҹ�_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Doctor doctor = new DoctorRed(controller);
        DoctorShot shot = doctor.shot();
        controller.addDoctorShot(shot);
        
        assertNotNull(controller.getDoctorshots());
        
        controller.removeDoctorShot(shot);
        
        assertEquals(0, controller.getDoctorshots().size());
    }
    
    @Test
    void ��������_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        EnemyShot shot = enemy.attack();
        controller.addEnemyShot(shot);
        
        assertNotNull(controller.getEnemyshots());
    }
    
    @Test
    void �����Ҹ�_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        EnemyShot shot = enemy.attack();
        controller.addEnemyShot(shot);
        
        assertNotNull(controller.getEnemyshots());
        
        controller.removeEnemyShot(shot);
        assertEquals(0, controller.getEnemyshots().size());
    }
    
    @Test
    void �����ۻ���_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        Item item = enemy.addItem();
        controller.addItem(item);
        
        assertNotNull(controller.getItems());
    }
    
    @Test
    void �����ۼҸ�_�׽�Ʈ() {
        Controller controller = new Controller(gameview);
        Enemy enemy = new Virus();
        Item item = enemy.addItem();
        controller.addItem(item);
        
        assertNotNull(controller.getItems());
        
        controller.removeItem(item);
        
        assertEquals(0, controller.getItems().size());
    }
    
}