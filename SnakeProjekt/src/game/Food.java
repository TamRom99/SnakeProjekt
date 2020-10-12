package game;

import java.util.concurrent.ThreadLocalRandom;
import gui.Board;

/**
 * @author
 */

public class Food {

	private int FoodX;
	private int FoodY;

	public Food() {
		this.FoodX = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesX);
		this.FoodY = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesY);
	}

	public void placeFood() {
		this.FoodX = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesX);
		this.FoodY = ThreadLocalRandom.current().nextInt(0, Board.NumberOfBoxesY);
	}

	public int getFoodX() {
		return FoodX;
	}

	public void setFoodX(int foodX) {
		FoodX = foodX;
	}

	public int getFoodY() {
		return FoodY;
	}

	public void setFoodY(int foodY) {
		FoodY = foodY;
	}
}
