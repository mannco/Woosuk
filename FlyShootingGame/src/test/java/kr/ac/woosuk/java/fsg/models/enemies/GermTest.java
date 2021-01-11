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
	void ���̷�������_�׽�Ʈ() {
		Enemy enemy = new Germ(controller);
		assertNotNull(enemy);
	}
	
	

	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Enemy enemy = new Germ(controller);
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof EnemyBullet);
	}
	
	@Test
	void ���̷����Ҹ�_�׽�Ʈ () {
		
	}
	
	@Test
	void �����۵��_�׽�Ʈ() {
		Enemy enemy = new Germ(controller);
		
	}
	
}