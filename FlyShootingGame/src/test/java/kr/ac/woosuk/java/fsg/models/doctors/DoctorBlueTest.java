package kr.ac.woosuk.java.fsg.models.doctors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.items.AlcoholBombUp;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.LifeUp;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;
import kr.ac.woosuk.java.fsg.views.GameView;

class DoctorBlueTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);
		
	@Test
	void ���ͻ���_�׽�Ʈ() {
		Doctor doctor = new DoctorBlue(controller);
		assertNotNull(doctor);
	}
	
	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Doctor doctor = new DoctorBlue(controller);
		
		DoctorShot shot = doctor.shot();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void ����ô�Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorBlue(controller);
		Item item = new ThumbsUp(controller,1,1);
		assertEquals(0, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(10, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void ���������Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorBlue(controller);
		Item item = new LifeUp(controller,1,1);
		assertEquals(3, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(4, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(5, doctor.getLife());
	}
	
	@Test
	void ��ź�Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorBlue(controller);
		Item item = new AlcoholBombUp(controller,1,1);
		assertEquals(3, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(4, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(5, doctor.getBombScore());
	}
	
	@Test
	void �Ŀ����ݱ�_�׽�Ʈ() {
		
		//���� ����
		Doctor doctor = new DoctorBlue(controller);
		//�Ŀ��� ������ ����
		Item item = new PowerUp(controller,1,1);
		//���Ͱ� �Ŀ��� �������� �Դ´�
		doctor.getPowerUp(item);
		
		
		//�׽�Ʈ
		//���Ͱ� ������ �Ծ����� Ȯ��
		assertNotNull(item);
		//������ �Ŀ��� ����ߴ��� Ȯ��
		assertEquals(2, doctor.getPower());
		
	}
	
	   
	   @Test 
	   void ���Ϳ�����_�׽�Ʈ() {
		   //��������
		   //���� ����
		   Doctor doctor = new DoctorBlue(controller);
		   
		   //����
		   //������
		   doctor.moveRight();
		   //�׽�Ʈ
		   assertEquals(1, doctor.getX());
		   
		   //����
		   doctor.moveLeft();
		   //�׽�Ʈ
		   assertEquals(0, doctor.getX());
		   
		   //����
		   doctor.moveUp();
		   //�׽�Ʈ
		   assertEquals(-1, doctor.getX());
		   
		   //�Ʒ���
		   doctor.moveDown();
		   //�׽�Ʈ
		   assertEquals(0, doctor.getY());
	   }
	   
	   @Test
	   void ����lLife����_�׽�Ʈ() {
		   //���ͻ���
		   Doctor doctor = new DoctorBlue(controller);
		   //�� ����
		   Enemy enemy = new Virus(controller);
		   //���̷������� ���Ͱ� ����
		   EnemyShot shot = enemy.attack();
		   
		   
		   //���� life ���� �׽�Ʈ
		   shot.AttackDoctor(doctor);
		   assertEquals(2, doctor.getLife());
		   shot.AttackDoctor(doctor);
		   assertEquals(1, doctor.getLife());
		   shot.AttackDoctor(doctor);
		   assertEquals(0, doctor.getLife());
	   }
	   
	   
	   @Test
	   void ��ź���_�׽�Ʈ() {
		   //���� ����
		   Doctor doctor = new DoctorBlue(controller);
		   //��ź �߻�
		   DoctorShot shot = doctor.useBomb();
		   assertNotNull(shot);
		   //shot�� ������ź���� Ȯ���׽�Ʈ
		   assertTrue(shot instanceof AlcoholBomb);
		   //��ź ���� Ȯ�� �׽�Ʈ
		   assertEquals(2, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertEquals(1, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertEquals(0, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertNull(shot);
	   }

}
