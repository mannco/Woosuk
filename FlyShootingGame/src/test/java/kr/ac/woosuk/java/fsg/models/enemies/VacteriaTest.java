package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.views.GameView;

class VacteriaTest {
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void 바이러스생성_테스트() {
		Enemy enemy = new Bacteria(controller);
		assertNotNull(enemy);
	}
	
	@Test
	void 총알발사_테스트() {
		Enemy enemy = new Bacteria(controller);
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void 바이러스소멸_테스트 () {
		
	}
	
	@Test
	void 아이템드롭_테스트() {
		Enemy enemy = new Bacteria(controller);
		
	}
	
}