package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyBullet;
import kr.ac.woosuk.java.fsg.views.GameView;

class GermTest {
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void 바이러스생성_테스트() {
		Enemy enemy = new Germ(controller);
		assertNotNull(enemy);
	}
	
	

	@Test
	void 총알발사_테스트() {
		Enemy enemy = new Germ(controller);
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof EnemyBullet);
	}
	
	@Test
	void 바이러스소멸_테스트 () {
		
	}
	
	@Test
	void 아이템드롭_테스트() {
		Enemy enemy = new Germ(controller);
		
	}
	
}