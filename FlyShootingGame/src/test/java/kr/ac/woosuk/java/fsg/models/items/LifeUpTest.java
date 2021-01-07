package kr.ac.woosuk.java.fsg.models.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.views.GameView;

class LifeUpTest {
	GameView gameview = new GameView();
	Controller controller = new Controller(gameview);

	@Test
	void 라이프업움직임_테스트() {
		// 아이템 생성
		Item item = new LifeUp(controller,1,1);
		item.moveRight();
		assertEquals(1, item.getx());
		
		item.moveLeft();
		assertEquals(0, item.getx());
		
		item.moveUp();
		assertEquals(-1, item.gety());
		
		item.moveDown();
		assertEquals(0, item.gety());
	}

}
