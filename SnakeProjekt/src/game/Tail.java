package game;

/**
 * @author
 */

public class Tail {

	/**
	 * 
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
	 */
	public int getTailX() {
		return TailX;
	}

	/**
	 */
	public void setTailX(int tailX) {
		TailX = tailX;
	}

	/**
	 */
	public int getTailY() {
		return TailY;
	}

	/**
	 */
	public void setTailY(int tailY) {
		TailY = tailY;
	}

	/**
	 */
	public boolean isWait() {
		return wait;
	}

	/**
	 */
	public void setWait(boolean wait) {
		this.wait = wait;
	}

}
