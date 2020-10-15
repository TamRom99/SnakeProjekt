package game;

import java.util.concurrent.ThreadLocalRandom;
import gui.Board;

/**
 * @author Ilayda Alkan
 */

public class Food {

	/**
	 * Declaration of the food coordinates
	 */
	private int FoodX;
	private int FoodY;

	/**
	 */
	public Food() {
		this.FoodX = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesX);
		this.FoodY = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesY);
	}

	/**
	 * The food gets randomly placed on the board. 
	 * The coordinates make sure that it is placed in the board and not out of the board.
	 */
	public void placeFood() {
		this.FoodX = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesX);
		this.FoodY = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesY);
	}

	/**
	 * Needed to get the x-coordinates of the food.
	 */
	public int getFoodX() {
		return FoodX;
	}

	/**
	 * Needed to set the x-coordinates of the food.
	 */
	public void setFoodX(int foodX) {
		FoodX = foodX;
	}

	/**
	 * Needed to get the y-coordinates of the food.
	 */
	public int getFoodY() {
		return FoodY;
	}

	/**
	 * Needed to set the y-coordinates of the food.
	 */
	public void setFoodY(int foodY) {
		FoodY = foodY;
	}
}
