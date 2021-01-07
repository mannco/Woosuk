package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.views.GameView;

class SyringeTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void 공격_테스트() {
		//주사기가 발사됨
	      Doctor doctor =  new DoctorRed(controller);
	    //의사가 총알을 발사
	      DoctorShot shot = doctor.shot();
	      //주사기의 기본공격력은 10
	      assertEquals(10, shot.getAttackpoint());
	      //적이 생성됨
	      Enemy virus = new Virus(controller);
	      //적의 체력은 20
	      assertEquals(20, virus.hp());
	      //총알이 바이러스를 때림
	      shot.attackEnemy(virus);
	      //체력이 20인 바이러스가 공격을 맞아서 10이 됨
	      assertEquals(10, virus.hp());
	}
	
	@Test
	void 주사공격력증가_테스트() {
		//사전 조건
		//주사기가 발사됨
		Doctor doctor = new DoctorRed(controller);
		//파워업 아이템이 생성됨
		Item item = new PowerUp(controller,1,1);
		
		//행위
		// 의사가 아이템을 먹음
		doctor.getPowerUp(item);
		//의사가 총알 발사
		DoctorShot shot = doctor.shot();
		
		//공격력 10에 아이템의 효과로 1을 더함
		//테스트
		assertEquals(11, shot.getAttackpoint());
	}
	
	
	
	@Test
	void 적찾기_테스트() {
		Doctor doctor = new DoctorRed(controller);
		DoctorShot shot = doctor.shot();
		List<Enemy> enemies = new ArrayList<Enemy>();
		
		shot.search(enemies);
	}
}
