package kr.ac.woosuk.java.fsg.models.shot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

class SyringeTest {

	@Test
	void 공격_테스트() {
		DoctorShot doctorshot = new Syringe();
		Enemy virus = new Virus();
		virus.hp=3;
		doctorshot.getAttackPoint();
		assertEquals(2, virus.hp -= doctorshot.getAttackPoint());
		
	}
	
	@Test
	void 공격력증가_테스트() {
		
	}

}
