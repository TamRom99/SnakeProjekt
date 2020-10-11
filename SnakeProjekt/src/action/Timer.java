package action;

import java.util.concurrent.atomic.AtomicBoolean;

import game.Snake;
import gui.Board;
import gui.GameState;
import gui.MainMenu;
import gui.Screen;

public class Timer implements Runnable {
	public Thread runner;
	public static int millisec = 200;

	public static AtomicBoolean running = new AtomicBoolean(false);

	public void start() {
		runner = new Thread(this);
		runner.start();
	}

	public void stop() {
		running.set(false);
	}

	public void run() {
		running.set(true);
		while (running.get()) {
			try {
				Thread.sleep(millisec);
				Snake.move();
				Snake.waitToMove = false;
				Collision.collideFood();

				if (Collision.collideItself()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					stop();
					Snake.tails.clear();

				}

				if (MainMenu.StandardModeRb.isSelected() && Collision.collideBorder()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					stop();
					Snake.tails.clear();
				}
				
				

				if (MainMenu.FreeModeRb.isSelected()) {
					if (Collision.crossLeftBorder()) {
						Snake.head.setHeadX(Board.NumberOfBoxesX);						
					} else if (Collision.crossRightBorder()) {
						Snake.head.setHeadX(0);
					} else if (Collision.crossUpperBorder()) {
						Snake.head.setHeadY(Board.NumberOfBoxesY);						
					} else if (Collision.crossDownBorder()) {
						Snake.head.setHeadY(0);
					}
				}

			}

			catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}