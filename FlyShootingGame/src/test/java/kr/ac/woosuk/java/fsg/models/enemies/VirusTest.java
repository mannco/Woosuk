package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;



class VirusTest {

	@Test
	void 바이러스생성_테스트() {
		Enemy enemy = new Virus();
		assertNotNull(enemy);
	}

	@Test
	void 총알발사_테스트() {
		Enemy enemy = new Virus();
		
		EnemyShot shot = enemy.dispense();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void 아이템생성_테스트() {
		Enemy enemy = new Virus();
		
	}
}
