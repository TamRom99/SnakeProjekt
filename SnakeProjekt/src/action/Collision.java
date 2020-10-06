package action;

import game.Snake;
import gui.Board;
import timer.Timer;

public class Collision {
	public static int score;

	public static void collideFood() {
		if (Snake.head.getHeadX() == Snake.food.getFoodX() && Snake.head.getHeadY() == Snake.food.getFoodY()) {
			Snake.addTail();
			Snake.food.placeFood();
			score = score + 10;
			Timer.millisec = Timer.millisec - 5;
		}
	}
	public static boolean collideItself() {
		for (int i = 0; i < Snake.tails.size(); i++) {
			if (Snake.head.getHeadX() == Snake.tails.get(i).getTailX()
					&& Snake.head.getHeadY() == Snake.tails.get(i).getTailY() && !Snake.tails.get(i).isWait()) {
				return true;
			}
		}
		return false;
	}

	/*public static boolean collideBorder() {
		return(Snake.head.getHeadX() < 0 || Snake.head.getHeadX() > Board.NumberOfBoxesX -1|| Snake.head.getHeadY() < 0
				|| Snake.head.getHeadY() > Board.NumberOfBoxesY -1);
			
	}
	*/
	
	public static boolean crossLeftBorder() {
		return(Snake.head.getHeadX() < 0) ;
	}
	public static boolean crossRightBorder() {
		return(Snake.head.getHeadX() > Board.NumberOfBoxesX -1) ;
	}	
	public static boolean crossUpperBorder() {
		return(Snake.head.getHeadY() < 0) ;			
	}		
	public static boolean crossDownBorder() {
		return(Snake.head.getHeadY() > Board.NumberOfBoxesY -1) ;
			
		}
				
}

