package timer;

import action.Collision;
import game.Snake;

public class Timer extends Thread {
	public static boolean running = true;
	
	public void run() {
		while (running) {
			try {
				sleep (200);
				Snake.move();
				Snake.waitToMove = false;
				Collision.collideFood();
				if(Collision.collideItself()) {
					Snake.tails.clear();
				}
				if(Collision.collideBorder()) {
					Snake.tails.clear();
					Snake.head.setHeadX(16);
					Snake.head.setHeadY(12);
				}
			}
				
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
