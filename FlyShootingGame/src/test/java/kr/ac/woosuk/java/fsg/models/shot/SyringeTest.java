package kr.ac.woosuk.java.fsg.models.shot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

class SyringeTest {

	@Test
	void ����_�׽�Ʈ() {
		//�ֻ�Ⱑ �߻��
	      Doctor doctor =  new DoctorRed();
	    //�ǻ簡 �Ѿ��� �߻�
	      DoctorShot shot = doctor.shot();
	      //�ֻ���� �⺻���ݷ��� 10
	      assertEquals(10, shot.getAttackpoint());
	      //���� ������
	      Enemy virus = new Virus();
	      //���� ü���� 20
	      assertEquals(20, virus.hp());
	      //�Ѿ��� ���̷����� ����
	      shot.attackEnemy(virus);
	      //ü���� 20�� ���̷����� ������ �¾Ƽ� 10�� ��
	      assertEquals(10, virus.hp());
	}
	
	@Test
	void �ֻ���ݷ�����_�׽�Ʈ() {
			//���� ����
		//�ֻ�Ⱑ �߻��
		Doctor doctor = new DoctorRed();
		//�Ŀ��� �������� ������
		Item item = new PowerUp();
		
		//����
		// �ǻ簡 �������� ����
		doctor.getPowerUp(item);
		//�ǻ簡 �Ѿ� �߻�
		DoctorShot shot = doctor.shot();
		
		//���ݷ� 10�� �������� ȿ���� 1�� ����
		//�׽�Ʈ
		assertEquals(11, shot.getAttackpoint());
	}
}
