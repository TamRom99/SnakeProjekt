package action;

import game.Snake;

public class Collision {

	public static boolean collideItself() {
		for(int i=0; i<Snake.tails.size();i++) {
			if(Snake.head.getHeadX() == Snake.tails.get(i).getTailX() && Snake.head.getHeadY() == Snake.tails.get(i).getTailY() 
					&& !Snake.tails.get(i).isWait()){
			return true;
			}
	
	}
		return false;
		
		
	}
	
	public static boolean collideBorder() {
		
		return (Snake.head.getHeadX()<0 ||Snake.head.getHeadX()>34 || Snake.head.getHeadY()<0 || Snake.head.getHeadY()>24);
		
	}
	
	public static void collideFood() {
		if(Snake.head.getHeadX()==Snake.food.getFoodX() && Snake.head.getHeadY()==Snake.food.getFoodY()){
			Snake.addTail();
			Snake.food.placeFood();
			
		}
	}
}
