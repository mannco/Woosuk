package kr.ac.woosuk.java.fsg.models.doctorshot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;
import kr.ac.woosuk.java.fsg.models.doctors.DoctorRed;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.enemies.Virus;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.views.GameView;

class SyringeTest {
	
	GameView gameView = new GameView();
	Controller controller = new Controller(gameView);

	@Test
	void ����_�׽�Ʈ() {
		//�ֻ�Ⱑ �߻��
	      Doctor doctor =  new DoctorRed(controller);
	    //�ǻ簡 �Ѿ��� �߻�
	      DoctorShot shot = doctor.shot();
	      //�ֻ���� �⺻���ݷ��� 10
	      assertEquals(10, shot.getAttackpoint());
	      //���� ������
	      Enemy virus = new Virus(controller);
	      //���� ü���� 20
	      assertEquals(20, virus.hp());
	      //�Ѿ��� ���̷����� ����
	      shot.attackEnemy(virus);
	      //ü���� 20�� ���̷����� ������ �¾Ƽ� 10�� ��
	      assertEquals(10, virus.hp());
	}
	
	@Test
	void �ֻ���ݷ�����_�׽�Ʈ() {
		//���� ����
		//�ֻ�Ⱑ �߻��
		Doctor doctor = new DoctorRed(controller);
		//�Ŀ��� �������� ������
		Item item = new PowerUp(controller,1,1);
		
		//����
		// �ǻ簡 �������� ����
		doctor.getPowerUp(item);
		//�ǻ簡 �Ѿ� �߻�
		DoctorShot shot = doctor.shot();
		
		//���ݷ� 10�� �������� ȿ���� 1�� ����
		//�׽�Ʈ
		assertEquals(11, shot.getAttackpoint());
	}
	
	
	
	@Test
	void ��ã��_�׽�Ʈ() {
		Doctor doctor = new DoctorRed(controller);
		DoctorShot shot = doctor.shot();
		List<Enemy> enemies = new ArrayList<Enemy>();
		
		shot.search(enemies);
	}
}
