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
//	void 공격_테스트() {
//		DoctorShot doctorshot = new Syringe();
//		Enemy virus = new Virus();
//		virus.hp=3;
//		doctorshot.getAttackPoint();
//		assertEquals(2, virus.hp -= doctorshot.getAttackPoint());
//		
//	}
	
	@Test
	   void 주사공격력증가_테스트() {
	      //주사기가 발사됨
	      Doctor doctor =  new DoctorRed();
	      DoctorShot shot = doctor.shot();
	      //주사기의 기본공격력은 10
	      assertEquals(10, shot.getAttackpoint());
	      //파워업 아이템을 먹음
	      Item item = new PowerUp();
	      //공격력 10에  아이템의 효과로 1를 더함
	      doctor.getPowerUp(item);
	      shot = doctor.shot();
	      assertEquals(11, shot.getAttackpoint());
	   }

}
