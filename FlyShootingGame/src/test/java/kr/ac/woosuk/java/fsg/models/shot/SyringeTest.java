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
	void 공격_테스트() {
		//주사기가 발사됨
	      Doctor doctor =  new DoctorRed();
	      DoctorShot shot = doctor.shot();
	      //주사기의 기본공격력은 10
	      assertEquals(10, shot.getAttackpoint());
	}
	
	@Test
	void 주사공격력증가_테스트() {
			//사전 조건
		//주사기가 발사됨
		Doctor doctor = new DoctorRed();
		//파워업 아이템이 생성됨
		Item item = new PowerUp();
		
		//행위
		// 의사가 아이템을 먹음
		doctor.getPowerUp(item);
		//의사가 총알 발사
		DoctorShot shot = doctor.shot();
		
		//공격력 10에 아이템의 효과로 1을 더함
		//테스트
		assertEquals(11, shot.getAttackpoint());
	}
}
