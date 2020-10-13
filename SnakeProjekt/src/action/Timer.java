package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Snake;
import gui.Screen;
import gui.GameState;
import gui.MainMenu;
import gui.Board;

/**
 * The Timer lets the snake moving and stopping.
 * 
 * @author Chiara Frankenbach
 */

public class Timer {

	/**
	 * Declaration of the time delay, which is needed to move the snake in
	 * intervals.
	 */
	public static int millisec = 200;

	/**
	 * Method to start or restart the snake.
	 */
	public void start() {
		timer.start();
	}

	/**
	 * Method to stop the snake.
	 */
	public void stop() {
		timer.stop();
	}

	/**
	 * Lets the snake moving faster with every collected food.
	 */
	private void decreaseInterval() {
		if (millisec >= 10) {
			timer.stop();
			millisec = millisec - 5;
			timer.setDelay(millisec);
			timer.start();
		}
	}

	/**
	 * Moving the snake forward in constant steps. Furthermore stop the snake if it
	 * collides with itself and if Standard Mode is selected with the border too. If
	 * Free Mode is chosen turn to the other side of the border.
	 * 
	 * @author of collision cases Ilayda Alkan - revised from Tamara Romer and
	 *         Chiara Frankenbach
	 */
	javax.swing.Timer timer = new javax.swing.Timer(millisec, new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Snake.waitToMove = false;
			Snake.move();
			if (Collision.collideFood()) {
				decreaseInterval();
			}

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
	});
}