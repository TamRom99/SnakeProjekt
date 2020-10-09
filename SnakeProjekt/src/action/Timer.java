package action;

import game.Snake;
import gui.GameState;
import gui.Screen;

public class Timer extends Thread {
	public static int millisec = 200;

	public static boolean running = true;

	public void run() {
		while (running) {
			try {
				sleep(millisec);
				Snake.move();
				Snake.waitToMove = false;
				Collision.collideFood();

				// Free mode
				/*
				 * if(Collision.crossLeftBorder()) { Snake.head.setHeadX(Board.NumberOfBoxesX
				 * -1); } if(Collision.crossRightBorder()) {
				 * Snake.head.setHeadX(Board.NumberOfBoxesX -35); }
				 * if(Collision.crossUpperBorder()) { Snake.head.setHeadY(Board.NumberOfBoxesY
				 * -1); } if(Collision.crossDownBorder()) {
				 * Snake.head.setHeadY(Board.NumberOfBoxesY -25); }
				 */

				// CollideItself use at Free and Standard mode
				if (Collision.collideItself()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					running = false;
					Snake.tails.clear();
				}

				// Standard mode - noch zusmmenfassen mit CollideItself
				if (Collision.collideBorder()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					running = false;
					Snake.tails.clear();
				}
			}

			catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}