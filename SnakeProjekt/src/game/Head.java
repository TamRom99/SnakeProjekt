package game;

public class Head {
	
	int HeadX;
	int HeadY;	
	Direction direction = Direction.LEFT;
	
	
	public Head(int headX, int headY) {
		super();
		HeadX = headX;
		HeadY = headY;
	}

	public int getHeadX() {
		return HeadX;
	}

	public void setHeadX(int headX) {
		HeadX = headX;
	}

	public int getHeadY() {
		return HeadY;
	}

	public void setHeadY(int headY) {
		HeadY = headY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	
}
