package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.Snake;
import gui.Screen;
import gui.GameState;
import gui.MainMenu;
import gui.Board;

/**
 * The Timer allows the snake moving and stopping.
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
	 * Makes the snake moving faster per 2 milliseconds.
	 */
	private void decreaseInterval() {
		if (millisec >= 10) {
			timer.stop();
			millisec = millisec - 2;
			timer.setDelay(millisec);
			timer.start();
		}
	}

	/**
	 * Declaration of swing timer.
	 */
	javax.swing.Timer timer = new javax.swing.Timer(millisec, new ActionListener() {

		/**
		 * Auto-generated method, which has to exist due to ActionListener. It allows the
		 * snake to move forward in constant steps. Furthermore it stops the snake if it
		 * collides with itself and if Standard Mode is selected with the border as well. If
		 * Free Mode is chosen call the relevant method from class collision and which
		 * turns the snake to the other side of the field.
		 * 
		 * @author of collision cases Ilayda Alkan - revised from Tamara Romer and
		 *         Chiara Frankenbach
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// When the snake don't wait to move, move
			Snake.waitToMove = false;
			Snake.move();

			// Call method decreaseInterval to set the Interval to move lower when food
			// was collected
			if (Collision.collideFood()) {
				decreaseInterval();
			}
			// Set the game state to game over and call the setGameStateMethod to change
			// graphics to GameOver Menu if snake is collided with itself
			if (Collision.collideItself()) {
				Screen.gamestate = GameState.GAMEOVER;
				Screen.setGameState();
				stop();
				Snake.tails.clear();
			}
			// When causing a collision with the border in StandardMode set game state to
			// game over and call setGameState for GameOverMenu
			if (MainMenu.StandardModeRb.isSelected() && Collision.collideBorder()) {
				Screen.gamestate = GameState.GAMEOVER;
				Screen.setGameState();
				stop();
				Snake.tails.clear();
			}
			// Possibility to come through the wall in FreeMode. Set the head of snake at
			// the same coordinate on the other side of the field
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