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
