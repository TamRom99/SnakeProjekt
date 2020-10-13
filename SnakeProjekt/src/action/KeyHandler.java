package action;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import game.Direction;
import game.Snake;
import gui.Screen;
import gui.GameState;

/**
 * The class KeyHandler is used to control the snake with the arrow keys and to
 * stop it with the space bar.
 * 
 * @author Chiara Frankenbach
 */

public class KeyHandler implements KeyListener {

	/**
	 * Not in use.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Control and pause of snake are defined here.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		// Move upwards
		case KeyEvent.VK_UP:
			if (!(Snake.head.getDirection() == Direction.DOWN) && !Snake.waitToMove) {
				Snake.head.setDirection(Direction.UP);
				Snake.waitToMove = true;
			}
			break;
		// Move to the right
		case KeyEvent.VK_RIGHT:
			if (!(Snake.head.getDirection() == Direction.LEFT) && !Snake.waitToMove) {
				Snake.head.setDirection(Direction.RIGHT);
				Snake.waitToMove = true;
			}
			break;
		// Move to the left
		case KeyEvent.VK_LEFT:
			if (!(Snake.head.getDirection() == Direction.RIGHT) && !Snake.waitToMove) {
				Snake.head.setDirection(Direction.LEFT);
				Snake.waitToMove = true;
			}
			break;
		// Move down
		case KeyEvent.VK_DOWN:
			if (!(Snake.head.getDirection() == Direction.UP) && !Snake.waitToMove) {
				Snake.head.setDirection(Direction.DOWN);
				Snake.waitToMove = true;
			}
			break;

		// Stop moving
		case KeyEvent.VK_SPACE:
			if (Screen.gamestate == GameState.GAME && !Snake.waitToMove) {
				Screen.gamestate = GameState.PAUSE;
				Screen.setGameState();
			}

		}
	}

	/**
	 * Not in use.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
