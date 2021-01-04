package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.views.GameView;

class AlcoholBombTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void �������׽�Ʈ() {
		DoctorShot doctorShot = new AlcoholBomb(controller,1,1);	//��ź ����
		doctorShot.Moveup();	//���� ������
		assertEquals(-10, doctorShot.getY());
	}
	
	@Test
	void �����׽�Ʈ() {
		Doctor doctor = new DoctorRed(controller);	//�ǻ� ����
		
		DoctorShot bomb = new AlcoholBomb(controller,1,1);	//��ź ����
		assertEquals(999, bomb.getAttackpoint());	//��ź ���ݷ� Ȯ��
		
		//�� ����
		Enemy enemy = new Virus(controller);
		Enemy enemy2 = new Virus(controller);
		ArrayList<Enemy> list = new ArrayList<Enemy>();
		list.add(enemy);
		list.add(enemy2);
		
		//���� ü���� 20
		assertEquals(20, enemy.hp());
		assertEquals(20, enemy2.hp());
		//��ź�� ���� ����
		bomb.attackAllEnemy(list);
		//ü���� 20�� ���� ������ �¾Ƽ� -979�� ��
		assertEquals(-979, enemy.hp());
		assertEquals(-979, enemy2.hp());
	}
}