package kr.ac.woosuk.java.fsg.controllers;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;


class ControllerTest {

	@Test
	void ���ͻ���() {
		Controller controller = new Controller();
		//���ͷ��� ����
		Doctor doctor = new DoctorRed();
		//��Ʈ�ѷ��� ���� ����
		controller.addDoctor(doctor);
		//�׽�Ʈ
		assertNotNull(doctor);
	}
	
	@Test
	void ������() {
		Controller controller = new Controller();
		//�� ����
		Enemy enemy = new Virus();
		//��Ʈ�ѷ��� �� ����
		controller.addEnemy(enemy);
		//�׽�Ʈ
		assertNotNull(enemy);
	} 
	
	@Test
	void ���ͼҸ� () {
		Controller controller = new Controller();
		//���ͻ���
		Doctor doctor = new DoctorRed();
		//��Ʈ�ѷ��� ���� ����
		Enemy enemy = new Virus();
		//��Ʈ�ѷ��� �� ����
		controller.addDoctor(doctor);
		//��Ʈ�ѷ��� �ִ� ���� �Ҹ�
		
	}
	
	
}
