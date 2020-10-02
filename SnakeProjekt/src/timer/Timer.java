package timer;

import game.Snake;

public class Timer extends Thread {
	public static boolean running = true;
	
	public void run() {
		while (running) {
			try {
				sleep (200);
				Snake.move();
				Snake.waitToMove = false;
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
