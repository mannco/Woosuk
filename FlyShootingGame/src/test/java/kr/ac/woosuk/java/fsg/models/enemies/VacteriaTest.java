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
	void ���̷�������_�׽�Ʈ() {
		Enemy enemy = new Bacteria(controller);
		assertNotNull(enemy);
	}
	
	@Test
	void ���̷���������_�׽�Ʈ() {
		Enemy enemy = new Bacteria(controller);	//���̷��� ����
		
		enemy.moveright();	//���̷��� ���������� ������
		assertEquals(1, enemy.getx());
		
		enemy.moveleft();	//���̷��� �������� ������
		assertEquals(0, enemy.getx());
		
		enemy.moveup();		//���̷��� �������� ������
		assertEquals(-1, enemy.gety());
		
		enemy.movedown();	//���̷��� �Ʒ������� ������
		assertEquals(0, enemy.gety());
	}

	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Enemy enemy = new Bacteria(controller);
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void ���̷����Ҹ�_�׽�Ʈ () {
		
	}
	
	@Test
	void �����۵��_�׽�Ʈ() {
		Enemy enemy = new Bacteria(controller);
		
	}
	
}