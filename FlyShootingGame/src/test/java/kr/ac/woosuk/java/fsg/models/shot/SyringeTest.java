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

//	@Test
//	void ����_�׽�Ʈ() {
//		DoctorShot doctorshot = new Syringe();
//		Enemy virus = new Virus();
//		virus.hp=3;
//		doctorshot.getAttackPoint();
//		assertEquals(2, virus.hp -= doctorshot.getAttackPoint());
//		
//	}
	
	@Test
	   void �ֻ���ݷ�����_�׽�Ʈ() {
	      //�ֻ�Ⱑ �߻��
	      Doctor doctor =  new DoctorRed();
	      DoctorShot shot = doctor.shot();
	      //�ֻ���� �⺻���ݷ��� 10
	      assertEquals(10, shot.getAttackpoint());
	      //�Ŀ��� �������� ����
	      Item item = new PowerUp();
	      //���ݷ� 10��  �������� ȿ���� 1�� ����
	      doctor.getPowerUp(item);
	      shot = doctor.shot();
	      assertEquals(11, shot.getAttackpoint());
	   }

}
