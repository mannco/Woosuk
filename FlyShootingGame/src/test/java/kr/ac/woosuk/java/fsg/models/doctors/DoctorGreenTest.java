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
	void 닥터생성_테스트() {
		Doctor doctor = new DoctorGreen();
		assertNotNull(doctor);
	}
	
	@Test
	void 총알발사_테스트() {
		Doctor doctor = new DoctorGreen();
		
		DoctorShot shot = doctor.inject();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void 엄지척먹기_테스트() {
		Doctor doctor = new DoctorGreen();
		Item item = new ThumbsUp();
		assertEquals(0, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(10, doctor.getScore());
		doctor.getThumbsUp(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void 라이프업먹기_테스트() {
		Doctor doctor = new DoctorGreen();
		Item item = new LifeUp();
		assertEquals(3, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(4, doctor.getLife());
		doctor.getLifeUp(item);
		assertEquals(5, doctor.getLife());
	}
	
	@Test
	void 폭탄먹기_테스트() {
		Doctor doctor = new DoctorGreen();
		Item item = new AlcoholBombUp();
		assertEquals(3, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(4, doctor.getBombScore());
		doctor.getBombUp(item);
		assertEquals(5, doctor.getBombScore());
	}
	
	@Test
	void 파워업줍기_테스트() {
		
		//닥터 생성
		Doctor doctor = new DoctorGreen();
		//파워업 아이템 생성
		Item item = new PowerUp();
		//닥터가 파워업 아이템을 먹는다
		doctor.getPowerUp(item);
		
		
		//테스트
		//닥터가 아이템 먹었는지 확인
		assertNotNull(item);
		//닥터의 파워가 상승했는지 확인
		assertEquals(2, doctor.getPower());
		
	}
	
	   
	   @Test 
	   void 닥터움직임_테스트() {
		   //사전조건
		   //닥터 생성
		   Doctor doctor = new DoctorGreen();
		   
		   //행위
		   //오른쪽
		   doctor.moveRight();
		   //테스트
		   assertEquals(1, doctor.getx());
		   
		   //왼쪽
		   doctor.moveleft();
		   //테스트
		   assertEquals(0, doctor.getx());
		   
		   //위로
		   doctor.moveUp();
		   //테스트
		   assertEquals(-1, doctor.gety());
		   
		   //아래로
		   doctor.moveDown();
		   //테스트
		   assertEquals(0, doctor.gety());
	   }
	   
	   @Test
	   void 닥터lLife감소_테스트() {
		   //닥터생성
		   Doctor doctor = new DoctorGreen();
		   //적 생성
		   Enemy enemy = new Virus();
		   //바이러스샷을 닥터가 맞음
		   EnemyShot shot = enemy.attack();
		   
		   
		   //닥터 life 감소 테스트
		   shot.AttackDoctor(doctor);
		   assertEquals(2, doctor.getLife());
		   shot.AttackDoctor(doctor);
		   assertEquals(1, doctor.getLife());
		   shot.AttackDoctor(doctor);
		   assertEquals(0, doctor.getLife());
	   }
	   
	   
	   @Test
	   void 폭탄사용_테스트() {
		   //닥터 생성
		   Doctor doctor = new DoctorGreen();
		   //폭탄 발사
		   DoctorShot shot = doctor.useBomb();
		   assertNotNull(shot);
		   //shot이 알콜폭탄인지 확인테스트
		   assertTrue(shot instanceof AlcoholBomb);
		   //폭탄 갯수 확인 테스트
		   assertEquals(2, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertEquals(1, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertEquals(0, doctor.getBombScore());
		   shot = doctor.useBomb();
		   assertNull(shot);
	   }

}
