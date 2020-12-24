package kr.ac.woosuk.java.fsg.models.doctors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;
import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

class DoctorRedTest {

	@Test
	void �ν��Ͻ�����_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		assertNotNull(doctor);
	}
	
	
	@Test
	void �Ѿ˹߻�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		
		DoctorShot shot = doctor.inject();
		assertNotNull(shot);
		assertTrue(shot instanceof Syringe);
	}
	
	@Test
	void �����۸Ա�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		Item item = new ThumbsUp();
		doctor.getItem(item);
		assertEquals(10, doctor.getScore());
		doctor.getItem(item);
		assertEquals(20, doctor.getScore());
	}
	
	@Test
	void �Ŀ����ݱ�_�׽�Ʈ() {
		Doctor doctor = new DoctorRed();
		Item item = new PowerUp();
		doctor.getPowerUp(item);
		assertNotNull(item);
	}
	

}
