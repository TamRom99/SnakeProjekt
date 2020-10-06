package timer;

import action.Collision;
import game.Snake;
import gui.Board;

public class Timer extends Thread {
	public static int millisec = 200;
	
	public static boolean running = true;
	
	public void run() {
		while (running) {
			try {
				sleep (millisec);
				Snake.move();
				Snake.waitToMove = false;
				Collision.collideFood();
		
				if(Collision.crossLeftBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX -1);
				}
				if(Collision.crossRightBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX -35);
				}
				if(Collision.crossUpperBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY -1);
				}
				if(Collision.crossDownBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY -25);
				}
				if(Collision.collideItself()) {
					Snake.tails.clear();
			}	
	
		}
		
			/*	if(Collision.collideBorder()) {
					Snake.tails.clear();
					Snake.head.setHeadX(16);
					Snake.head.setHeadY(12); */
				
			
			catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}