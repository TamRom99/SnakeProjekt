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
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossLeftBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX - 1);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossRightBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX - Board.NumberOfBoxesX);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossUpperBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY - 1);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossDownBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY - Board.NumberOfBoxesY);
				} else if (MainMenu.StandardModeRb.isSelected() && Collision.collideBorder()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					stop();
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