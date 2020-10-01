package game;

import gui.Screen;

public class Food {

	int FoodX;
	int FoodY;

	public void placeFood() {
		this.setFoodX((int) (Screen.xoff+ Math.random() * 25));
		this.setFoodY((int) (Screen.yoff + Math.random() * 20));
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
