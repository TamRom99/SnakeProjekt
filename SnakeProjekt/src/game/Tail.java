package game;

/**
 * @author Ilayda Alkan
 */

public class Tail {

	/**
	 * Declaration of the needed Tail coordinates
	 */
	int TailX;
	int TailY;
	private boolean wait = true;

	/**
	 */
	public Tail(int tailX, int tailY) {
		super();
		TailX = tailX;
		TailY = tailY;
	}

	/**
	 * Needed to get the x-coordinates of the tail.
	 */
	public int getTailX() {
		return TailX;
	}

	/**
	 * Needed to set the x-coordinates of the tail.
	 */
	public void setTailX(int tailX) {
		TailX = tailX;
	}

	/**
	 * Needed to get the y-coordinates of the tail.
	 */
	public int getTailY() {
		return TailY;
	}

	/**
	 * Needed to set the y-coordinates of the tail.
	 */
	public void setTailY(int tailY) {
		TailY = tailY;
	}

	/**
	 * Needed that the snake can grow when adding the tails. 
	 * Otherwise the tail would be placed on the last snake tail 
	 * and you were not able to see the snake growing.
	 */
	public boolean isWait() {
		return wait;
	}


	public void setWait(boolean wait) {
		this.wait = wait;
	}

}
