package kr.ac.woosuk.java.fsg.models.enemyShot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.BacteriaShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;

class BacteriaShotTest {

	@Test
	void �����׽�Ʈ() {
		Enemy enemy = new Virus();	//���̷��� ����
		
		EnemyShot enemyShot = new BacteriaShot();	//�߻�ü ����
		assertEquals(1, enemyShot.getAttackpoint());	//�߻�ü ���ݷ� Ȯ��
		
		Doctor doctor = new DoctorRed();	//�ǻ� ����
		assertEquals(3, doctor.getLifepoint());	//��ü ü�� Ȯ��
		
		enemyShot.AttackDoctor(doctor);	//���׸��� �ǻ� ����
		
		assertEquals(2, doctor.getLifepoint());
	}
	
	@Test
	void �������׽�Ʈ() {
		EnemyShot enemyShot = new BacteriaShot();	//���׸��Ƽ� ����
		enemyShot.moveDown();	//�Ʒ��� ������
		assertEquals(1, enemyShot.getY());
	}

}