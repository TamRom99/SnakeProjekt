package game;

/**
 * @author Ilayda Alkan
 */

public class Head {

	/**
	 * 
	 */
	private int HeadX;
	private int HeadY;
	private Direction direction;

	/**
	 */
	public Head(int headX, int headY) {
		super();
		HeadX = headX;
		HeadY = headY;
	}

	/**
	 */
	public int getHeadX() {
		return HeadX;
	}

	/**
	 */
	public void setHeadX(int headX) {
		HeadX = headX;
	}

	/**
	 */
	public int getHeadY() {
		return HeadY;
	}

	/**
	 */
	public void setHeadY(int headY) {
		HeadY = headY;
	}

	/**
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
