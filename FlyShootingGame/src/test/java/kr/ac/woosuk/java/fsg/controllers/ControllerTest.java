package kr.ac.woosuk.java.fsg.controllers;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;


class ControllerTest {

	@Test
	void 닥터생성() {
		Controller controller = new Controller();
		//닥터레드 생성
		Doctor doctor = new DoctorRed();
		//컨트롤러에 닥터 생성
		controller.addDoctor(doctor);
		//테스트
		assertNotNull(doctor);
	}
	
	@Test
	void 적생성() {
		Controller controller = new Controller();
		//적 생성
		Enemy enemy = new Virus();
		//컨트롤러에 적 생성
		controller.addEnemy(enemy);
		//테스트
		assertNotNull(enemy);
	} 
	
	@Test
	void 닥터소멸 () {
		Controller controller = new Controller();
		//닥터생성
		Doctor doctor = new DoctorRed();
		//컨트롤러에 닥터 생성
		Enemy enemy = new Virus();
		//컨트롤러에 적 생성
		controller.addDoctor(doctor);
		//컨트롤러에 있는 닥터 소멸
		
	}
	
	
}
