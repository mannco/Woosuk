package kr.ac.woosuk.java.fsg.models.enemyShot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.BacteriaShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.views.GameView;

class BacteriaShotTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void 공격테스트() {
		Enemy enemy = new Virus(controller);	//바이러스 생성
		
		EnemyShot enemyShot = new BacteriaShot();	//발사체 생성
		assertEquals(1, enemyShot.getAttackpoint());	//발사체 공격력 확인
		
		Doctor doctor = new DoctorRed(controller);	//의사 생성
		assertEquals(3, doctor.getLifepoint());	//객체 체력 확인
		
		enemyShot.AttackDoctor(doctor);	//박테리아 의사 공격
		
		assertEquals(2, doctor.getLifepoint());
	}
	
	@Test
	void 움직임테스트() {
		EnemyShot enemyShot = new BacteriaShot();	//박테리아샷 생성
		enemyShot.moveDown();	//아래로 움직임
		assertEquals(1, enemyShot.getY());
	}

}
