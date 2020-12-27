package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;

class AlcoholBombTest {

	@Test
	void 움직임테스트() {
		DoctorShot doctorShot = new AlcoholBomb();	//폭탄 생성
		doctorShot.Moveup();	//위로 움직임
		assertEquals(-10, doctorShot.getY());
	}
	
	@Test
	void 공격테스트() {
		Doctor doctor = new DoctorRed();	//의사 생성
		
		DoctorShot bomb = new AlcoholBomb();	//폭탄 생성
		assertEquals(999, bomb.getAttackpoint());	//폭탄 공격력 확인
		
		//적 생성
		Enemy enemy = new Virus();
		
		//적의 체력은 20
		assertEquals(20, enemy.hp(	));
		//폭탄이 적을 때림
		bomb.attackAllEnemy(enemy);
		//체력이 20인 적이 공격을 맞아서 -979가 됨
		assertEquals(-979, enemy.hp());
	}
}