package kr.ac.woosuk.java.fsg.models.doctors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;

class DoctorRedTest {

	@Test
	void ���ͻ���_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		assertNotNull(doctor);
	}
	
	
	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		
		DoctorShot shot = doctor.inject();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void �����۸Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		Item item = new ThumbsUp();
		doctor.getItem(item);
		assertEquals(10, doctor.getScore());
		doctor.getItem(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void �Ŀ����ݱ�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		Item item = new PowerUp();
		doctor.getPowerUp(item);
		assertNotNull(item);
	}
	
	   @Test
	   void �������_�׽�Ʈ() {
	      //���� ����
		  Doctor doctor = new DoctorRed(); 
	        // �� ����
	      Enemy virus = new Virus();
	       //���� ü���� 20
	       assertEquals(20, virus.hp());
	       //�ǻ簡 �Ѿ��� �߻�
	       DoctorShot shot = doctor.shot();
	       //�Ѿ��� ���̷����� ����
	       shot.attackEnemy(virus);
	       //�Ѿ��� ���̷����� ����
	       shot.attackEnemy(virus);
	       //ü���� 20�� ���̷����� ������ 2�� �¾Ƽ� 0�� ��
	       assertNull(virus);
	       //���̷����� �׾ ���� 10���� ��
	       assertEquals(10, doctor.Score());
	   }
	   
	   @Test 
	   void ���Ϳ�����_�׽�Ʈ() { 
		   //��������
		   //���� ����
		   Doctor doctor = new DoctorRed();
		   
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
	   void ����lLife���ҼҸ�_�׽�Ʈ() {
		   //��������
		   //���ͻ���
		   Doctor doctor = new DoctorRed();
		   
		   //���� 
		   //���� life ���� , life�� 0�̸� �Ҹ�
		   doctor.lifeDecrease();
		   doctor.lifeDecrease();
		   doctor.lifeDecrease();
		  
		   //�׽�Ʈ
		   assertNull(doctor);
	   }
	   //�����ؾ���
	   
	   
	   @Test
	   void ��ź���_�׽�Ʈ() {
		   //���� ����
		   Doctor doctor = new DoctorRed();
		   //��ź �߻�
		   DoctorShot shot = doctor.useBomb();
		   assertNotNull(shot);
		   
		   assertTrue(shot instanceof AlcoholBomb);
		   assertEquals(2, doctor.getBombScore());
		   shot = doctor.useBomb();
		   shot = doctor.useBomb();
		   shot = doctor.useBomb();
		   assertNull(shot);
	   }
	   
}
