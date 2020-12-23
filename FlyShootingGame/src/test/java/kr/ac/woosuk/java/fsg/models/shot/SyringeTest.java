package kr.ac.woosuk.java.fsg.models.shot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

class SyringeTest {

	@Test
	void ����_�׽�Ʈ() {
		DoctorShot doctorshot = new Syringe();
		Enemy virus = new Virus();
		virus.hp=3;
		doctorshot.getAttackPoint();
		assertEquals(2, virus.hp -= doctorshot.getAttackPoint());
		
	}
	
	@Test
	void ���ݷ�����_�׽�Ʈ() {
		
	}

}
