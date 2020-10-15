package action;

import game.Snake;
import gui.Board;

/**
 * The class collision is responsible for the different snake actions 
 * when it collides with different barriers.
 * @author Ilayda Alkan
 */

public class Collision {

	/**
	 * Declaration of the counter score.
	 */
	public static int score;

	/**
	 * Eat food and grow tail if the head coordinates are equal to the food
	 * coordinates.
	 */
	public static boolean collideFood() {
		if (Snake.head.getHeadX() == Snake.food.getFoodX() && Snake.head.getHeadY() == Snake.food.getFoodY()) {
			Snake.addTail();
			Snake.food.placeFood();
			score = score + 10;
			return true;
		}
		return false;
	}

	/**
	 * This Method checks if the head coordinates are equal to one of the tail
	 * coordinates. In this case return true.
	 */
	public static boolean collideItself() {
		for (int i = 0; i < Snake.tails.size(); i++) {
			if (Snake.head.getHeadX() == Snake.tails.get(i).getTailX()
					&& Snake.head.getHeadY() == Snake.tails.get(i).getTailY() && !Snake.tails.get(i).isWait()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if the head coordinates collide with the border. This
	 * case can only be true if StandardMode is selected.
	 */
	public static boolean collideBorder() {
		return (Snake.head.getHeadX() < 0 || Snake.head.getHeadX() > Board.NumberOfBoxesX - 1
				|| Snake.head.getHeadY() < 0 || Snake.head.getHeadY() > Board.NumberOfBoxesY - 1);
	}

	// Free mode
	/**
	 * This method makes able that the head can cross the
	 * border at the left side. This case can only be true if FreeMode is selected.
	 */
	public static boolean crossLeftBorder() {
		return (Snake.head.getHeadX() < 0);
	}

	/**
	 * This method makes able that the head can cross the
	 * border at the right side. This case can only be true if FreeMode is selected.
	 */
	public static boolean crossRightBorder() {
		return (Snake.head.getHeadX() > Board.NumberOfBoxesX - 1);
	}

	/**
	 * This method makes able that the head can cross the
	 * border at the upper side. This case can only be true if FreeMode is selected.
	 */
	public static boolean crossUpperBorder() {
		return (Snake.head.getHeadY() < 0);
	}

	/**
	 * This method makes able that the head can cross the
	 * border at the down side. This case can only be true if FreeMode is selected.
	 */
	public static boolean crossDownBorder() {
		return (Snake.head.getHeadY() > Board.NumberOfBoxesY - 1);

	}

}
