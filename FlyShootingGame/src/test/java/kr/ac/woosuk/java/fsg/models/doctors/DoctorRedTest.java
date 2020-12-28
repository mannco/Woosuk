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
	void 닥터생성_테스트() {
		Doctor doctor = new DoctorRed();
		assertNotNull(doctor);
	}
	
	@Test
	void 총알발사_테스트() {
		Doctor doctor = new DoctorRed();
		
		DoctorShot shot = doctor.inject();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void 아이템먹기_테스트() {
		Doctor doctor = new DoctorRed();
		Item item = new ThumbsUp();
		doctor.getItem(item);
		assertEquals(10, doctor.getScore());
		doctor.getItem(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void 파워업줍기_테스트() {
		//닥터 생성
		Doctor doctor = new DoctorRed();
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
	   void 점수얻기_테스트() {
	      //닥터 생성
		  Doctor doctor = new DoctorRed(); 
	        // 적 생성
	      Enemy virus = new Virus();
	       //적의 체력은 20
	       assertEquals(20, virus.hp());
	       //의사가 총알을 발사
	       DoctorShot shot = doctor.shot();
	       //총알이 바이러스를 때림
	       shot.attackEnemy(virus);
	       //총알이 바이러스를 때림
	       shot.attackEnemy(virus);
	       //체력이 20인 바이러스가 공격을 2번 맞아서 0이 됨
	       assertNull(virus);
	       //바이러스가 죽어서 점수 10점을 줌
	       assertEquals(10, doctor.Score());
	   }
	   
	   @Test 
	   void 닥터움직임_테스트() {
		   //사전조건
		   //닥터 생성
		   Doctor doctor = new DoctorRed();
		   
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
	   void 닥터lLife감소소멸_테스트() {
		   //사전조건
		   //닥터생성
		   Doctor doctor = new DoctorRed();
		   
		   //행위 
		   //닥터 life 감소 , life가 0이면 소멸
		   doctor.lifeDecrease();
		   doctor.lifeDecrease();
		   doctor.lifeDecrease();
		   
		   //테스트
		   assertNull(doctor);
	   }
	   //수정해야함
	   
	   
	   @Test
	   void 폭탄사용_테스트() {
		   //닥터 생성
		   Doctor doctor = new DoctorRed();
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
