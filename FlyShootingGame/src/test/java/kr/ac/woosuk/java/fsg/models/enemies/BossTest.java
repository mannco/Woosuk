package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;

class BossTest {


	@Test
	void ���̷�������_�׽�Ʈ() {
		Enemy enemy = new Boss();
		assertNotNull(enemy);
	}
	
	@Test
	void ���̷���������_�׽�Ʈ() {
		Enemy enemy = new Boss();	//���̷��� ����
		
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
		Enemy enemy = new Boss();
		
		EnemyShot shot = enemy.attack();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void ���̷����Ҹ�_�׽�Ʈ () {
		
	}
	
	@Test
	void �����۵��_�׽�Ʈ() {
		Enemy enemy = new Boss();
		
	}
	
}