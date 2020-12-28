package kr.ac.woosuk.java.fsg.models.doctors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

class DoctorGreenTest {

	@Test
	void ���ͻ���_�׽�Ʈ() {
		Doctor doctor = new DoctorGreen();
		assertNotNull(doctor);
	}
	
	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Doctor doctor = new DoctorGreen();
		
		DoctorShot shot = doctor.inject();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void ����ô�Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorGreen();
		Item item = new ThumbsUp();
		assertEquals(0, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(10, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void ���������Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorGreen();
		Item item = new LifeUp();
		assertEquals(3, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(4, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(5, doctor.getLife());
	}
	
	@Test
	void ��ź�Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorGreen();
		Item item = new AlcoholBombUp();
		assertEquals(3, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(4, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(5, doctor.getBombScore());
	}
	
	@Test
	void �Ŀ����ݱ�_�׽�Ʈ() {
		
		//���� ����
		Doctor doctor = new DoctorGreen();
		//�Ŀ��� ������ ����
		Item item = new PowerUp();
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
		   Doctor doctor = new DoctorGreen();
		   
		   //����
		   //������
		   doctor.moveRight();
		   //�׽�Ʈ
		   assertEquals(1, doctor.getx());
		   
		   //����
		   doctor.moveleft();
		   //�׽�Ʈ
		   assertEquals(0, doctor.getx());
		   
		   //����
		   doctor.moveUp();
		   //�׽�Ʈ
		   assertEquals(-1, doctor.gety());
		   
		   //�Ʒ���
		   doctor.moveDown();
		   //�׽�Ʈ
		   assertEquals(0, doctor.gety());
	   }
	   
	   @Test
	   void ����lLife����_�׽�Ʈ() {
		   //���ͻ���
		   Doctor doctor = new DoctorGreen();
		   //�� ����
		   Enemy enemy = new Virus();
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
		   Doctor doctor = new DoctorGreen();
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
