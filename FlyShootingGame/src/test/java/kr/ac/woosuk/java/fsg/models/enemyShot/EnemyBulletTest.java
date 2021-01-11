package kr.ac.woosuk.java.fsg.models.enemyShot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyBullet;
import kr.ac.woosuk.java.fsg.views.GameView;

class EnemyBulletTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void �����׽�Ʈ() {
		Enemy enemy = new Virus(controller);	//���̷��� ����
		
		EnemyShot enemyShot = new EnemyBullet(controller,1,1);	//�߻�ü ����
		assertEquals(1, enemyShot.getAttackpoint());	//�߻�ü ���ݷ� Ȯ��
		
		Doctor doctor = new DoctorRed(controller);	//�ǻ� ����
		assertEquals(3, doctor.getLifepoint());	//��ü ü�� Ȯ��
		
		enemyShot.AttackDoctor(doctor);	//���̷��� �ǻ� ����
		
		assertEquals(2, doctor.getLifepoint());
	}
	
	@Test
	void �������׽�Ʈ() {
		EnemyShot enemyShot = new EnemyBullet(controller,1,1);	//���̷����� ����
		assertEquals(1, enemyShot.getY());
	}

}