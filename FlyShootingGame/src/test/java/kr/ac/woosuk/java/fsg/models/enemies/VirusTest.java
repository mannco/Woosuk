package kr.ac.woosuk.java.fsg.models.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;



class VirusTest {

	@Test
	void ���̷�������_�׽�Ʈ() {
		Enemy enemy = new Virus();
		assertNotNull(enemy);
	}
	
	@Test
	void ���̷���������_�׽�Ʈ() {
		Enemy enemy = new Virus();	//���̷��� ����
		
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
		Enemy enemy = new Virus();
		
		EnemyShot shot = enemy.dispense();
		assertNotNull(shot);
		assertTrue(shot instanceof VirusShot);
	}
	
	@Test
	void ���̷����Ҹ�_�׽�Ʈ () {
		
	}
	
	@Test
	void �����۵��_�׽�Ʈ() {
		Enemy enemy = new Virus();
	}
	
}
