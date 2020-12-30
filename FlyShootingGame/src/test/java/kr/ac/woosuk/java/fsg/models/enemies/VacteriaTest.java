package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;

class VacteriaTest {


	@Test
	void 바이러스생성_테스트() {
		Enemy enemy = new Bacteria();
		assertNotNull(enemy);
	}
	
	@Test
	void 바이러스움직임_테스트() {
		Enemy enemy = new Bacteria();	//바이러스 생성
		
		enemy.moveright();	//바이러스 오른쪽으로 움직임
		assertEquals(1, enemy.getx());
		
		enemy.moveleft();	//바이러스 왼쪽으로 움직임
		assertEquals(0, enemy.getx());
		
		enemy.moveup();		//바이러스 위쪽으로 움직임
		assertEquals(-1, enemy.gety());
		
		enemy.movedown();	//바이러스 아래쪽으로 움직임
		assertEquals(0, enemy.gety());
	}

	@Test
	void 총알발사_테스트() {
		Enemy enemy = new Bacteria();
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void 바이러스소멸_테스트 () {
		
	}
	
	@Test
	void 아이템드롭_테스트() {
		Enemy enemy = new Bacteria();
		
	}
	
}