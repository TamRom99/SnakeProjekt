package game;

/**
 * @author Ilayda Alkan
 */

public class Head {

	/**
	 * declaration of the head coordinates and the direction the head moves to.
	 */
	private int HeadX;
	private int HeadY;
	private Direction direction;

	
	public Head(int headX, int headY) {
		super();
		HeadX = headX;
		HeadY = headY;
	}

	/**
	 * Needed to get the x-coordinates of the head.
	 */
	public int getHeadX() {
		return HeadX;
	}

	/**
	 * Needed to set the x-coordinates of the head.
	 */
	public void setHeadX(int headX) {
		HeadX = headX;
	}

	/**
	 * Needed to get the y-coordinates of the head.
	 */
	public int getHeadY() {
		return HeadY;
	}

	/**
	 * Needed to set the y-coordinates of the head.
	 */
	public void setHeadY(int headY) {
		HeadY = headY;
	}

	/**
	 * Needed to get the direction of the head.
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Needed to set the direction of the head.
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
