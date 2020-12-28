package kr.ac.woosuk.java.fsg.models.enemyShot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.BossShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;

class BossShotTest {

	@Test
	void 공격테스트() {
		Enemy enemy = new Virus();	//바이러스 생성
		
		EnemyShot enemyShot = new BossShot();	//발사체 생성
		assertEquals(1, enemyShot.getAttackpoint());	//발사체 공격력 확인
		
		Doctor doctor = new DoctorRed();	//의사 생성
		assertEquals(3, doctor.getLifepoint());	//객체 체력 확인
		
		enemyShot.AttackDoctor(doctor);	//보스가 의사 공격
		
		assertEquals(2, doctor.getLifepoint());
	}
	
	@Test
	void 움직임테스트() {
		EnemyShot enemyShot = new BossShot();	//보스샷 생성
		enemyShot.moveDown();	//아래로 움직임
		assertEquals(1, enemyShot.getY());
	}

}
