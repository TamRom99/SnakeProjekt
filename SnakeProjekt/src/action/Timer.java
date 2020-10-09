package action;

import game.Snake;
import gui.Board;
import gui.GameState;
import gui.MainMenu;
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

				if (Collision.collideItself()) {
					Screen.gamestate = GameState.GAMEOVER;
					Screen.setGameState();
					running = false;
					Snake.tails.clear();
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossLeftBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX - 1);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossRightBorder()) {
					Snake.head.setHeadX(Board.NumberOfBoxesX - 35);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossUpperBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY - 1);
				} else if (MainMenu.FreeModeRb.isSelected() && Collision.crossDownBorder()) {
					Snake.head.setHeadY(Board.NumberOfBoxesY - 25);
				} else if (MainMenu.StandardModeRb.isSelected() && Collision.collideBorder()) {
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