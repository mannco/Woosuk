package kr.ac.woosuk.java.fsg;

import javax.swing.SwingUtilities;

import kr.ac.woosuk.java.fsg.views.GameFrame;

public class FlyShootingGame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GameFrame();
			}
		});
	}
}
