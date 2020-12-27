package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;

class AlcoholBombTest {

	@Test
	void �������׽�Ʈ() {
		DoctorShot doctorShot = new AlcoholBomb();	//��ź ����
		doctorShot.Moveup();	//���� ������
		assertEquals(-10, doctorShot.getY());
	}
	
	@Test
	void �����׽�Ʈ() {
		Doctor doctor = new DoctorRed();	//�ǻ� ����
		
		DoctorShot bomb = new AlcoholBomb();	//��ź ����
		assertEquals(999, bomb.getAttackpoint());	//��ź ���ݷ� Ȯ��
		
		//�� ����
		Enemy enemy = new Virus();
		
		//���� ü���� 20
		assertEquals(20, enemy.hp(	));
		//��ź�� ���� ����
		bomb.attackAllEnemy(enemy);
		//ü���� 20�� ���� ������ �¾Ƽ� -979�� ��
		assertEquals(-979, enemy.hp());
	}
}