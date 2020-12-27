package kr.ac.woosuk.java.fsg.models.items;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThumsUpTest {

	@Test
	void 엄지척움직임_테스트() {
		// 아이템 생성
		Item item = new ThumbsUp();
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