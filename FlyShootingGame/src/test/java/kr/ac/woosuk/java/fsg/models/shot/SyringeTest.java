package kr.ac.woosuk.java.fsg.models.shot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

class SyringeTest {

	@Test
	void ����_�׽�Ʈ() {
		DoctorShot doctorshot = new Syringe();
		doctorshot.attack();
		
	}

}
