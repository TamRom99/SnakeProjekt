package action;

import java.util.concurrent.atomic.AtomicBoolean;
import game.Snake;
import gui.Screen;
import gui.GameState;
import gui.MainMenu;
import gui.Board;

/**
 * Timer lets the snake moving and stopping.
 * 
 * @author Chiara Frankenbach
 */

public class Timer implements Runnable {
	
	/**
	 * Declaration of 
	 */
	private Thread runner;
	public static int millisec = 200;
	private AtomicBoolean running = new AtomicBoolean(false);

	/**
	 * Method to start or restart the snake.
	 */
	public void start() {
		runner = new Thread(this);
		runner.start();
	}

	/**
	 * Method to stop the snake.
	 */
	public void stop() {
		running.set(false);
	}

	/**
	 * Moving the snake forward in constant steps. Furthermore stop the snake if it
	 * collides with itself and if Standard Mode is selected with the border too. If
	 * Free Mode is chosen turn to the other side of the border.
	 * 
	 * @author of collision cases Ilayda Alkan - revised from Tamara Romer and
	 *         Chiara Frankenbach
	 */
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
						Snake.head.setHeadX(Board.NumberOfBoxesX - 1);
					} else if (Collision.crossRightBorder()) {
						Snake.head.setHeadX(0);
					} else if (Collision.crossUpperBorder()) {
						Snake.head.setHeadY(Board.NumberOfBoxesY - 1);
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