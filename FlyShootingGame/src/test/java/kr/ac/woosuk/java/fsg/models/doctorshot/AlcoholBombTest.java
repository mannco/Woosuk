package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.views.GameView;

class AlcoholBombTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void 움직임테스트() {
		DoctorShot doctorShot = new AlcoholBomb(controller,1,1);	//폭탄 생성
		doctorShot.Moveup();	//위로 움직임
		assertEquals(-10, doctorShot.getY());
	}
	
	@Test
	void 공격테스트() {
		Doctor doctor = new DoctorRed(controller);	//의사 생성
		
		DoctorShot bomb = new AlcoholBomb(controller,1,1);	//폭탄 생성
		assertEquals(999, bomb.getAttackpoint());	//폭탄 공격력 확인
		
		//적 생성
		Enemy enemy = new Virus(controller);
		Enemy enemy2 = new Virus(controller);
		ArrayList<Enemy> list = new ArrayList<Enemy>();
		list.add(enemy);
		list.add(enemy2);
		
		//적의 체력은 20
		assertEquals(20, enemy.hp());
		assertEquals(20, enemy2.hp());
		//폭탄이 적을 때림
		bomb.attackAllEnemy(list);
		//체력이 20인 적이 공격을 맞아서 -979가 됨
		assertEquals(-979, enemy.hp());
		assertEquals(-979, enemy2.hp());
	}
}