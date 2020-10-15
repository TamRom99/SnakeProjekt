package game;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import gui.Board;
import gui.MainMenu;
import gui.Screen;
import action.Timer;

/**
 * All parts of snake are united in this class.
 * 
 * @authors Tamara Romer, Ilayda Alkan and Chiara Frankenbach
 */

public class Snake {

	/**
	 * Declaration of needed snake parts and qualities.
	 */
	public static boolean waitToMove = false;
	public static Head head = new Head(Board.NumberOfBoxesX / 2, Board.NumberOfBoxesY / 2);
	public static ArrayList<Tail> tails = new ArrayList<>();
	public static Food food = new Food();
	public static Timer timer;

	/**
	 * Set the initial length of five fields.
	 * 
	 * @author Chiara Frankenbach
	 */
	public static void SnakeInitialize() {
		head.setDirection(Direction.LEFT);
		tails.add(new Tail(head.getHeadX(), head.getHeadY()));
		tails.add(new Tail(head.getHeadX() + 1, head.getHeadY()));
		tails.add(new Tail(head.getHeadX() + 2, head.getHeadY()));
		tails.add(new Tail(head.getHeadX() + 3, head.getHeadY()));
		// Snake starts to move
		timer = new Timer();
		timer.start();

		// Set the focus to menu
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Screen.menu);
		frame.requestFocusInWindow();
	}

	/**
	 * Add a new tail on the last position of snake.
	 * 
	 * @author Tamara Romer
	 */
	public static void addTail() {
		tails.add(new Tail(tails.get(tails.size() - 1).TailX, tails.get(tails.size() - 1).TailY));
	}

	/**
	 * How the snake moves actually forward.
	 * 
	 * @author Ilayda Alkan
	 */
	public static void move() {
		// First move tails
		if (tails.size() >= 2) {
			for (int i = tails.size() - 1; i >= 1; i--) {
				if (tails.get(i).isWait()) {
					tails.get(i).setWait(false);
				} else {
					tails.get(i).setTailX(tails.get(i - 1).getTailX());
					tails.get(i).setTailY(tails.get(i - 1).getTailY());
				}
			}
		}

		// Then move first tail to head
		if (tails.size() >= 1) {
			if (tails.get(0).isWait()) {
				tails.get(0).setTailX(head.getHeadX());
				tails.get(0).setTailY(head.getHeadY());
			}
		}

		// Finally move head, but take the direction to move and the selected mode in
		// consideration
		if (MainMenu.FreeModeRb.isSelected()) {
			switch (head.getDirection()) {
			case RIGHT:
				if (head.getHeadX() < Board.NumberOfBoxesX - 1) {
					head.setHeadX(head.getHeadX() + 1);
				} else {
					head.setHeadX(0);
				}
				break;
			case LEFT:
				if (head.getHeadX() > 0) {
					head.setHeadX(head.getHeadX() - 1);
				} else {
					head.setHeadX(Board.NumberOfBoxesX - 1);
				}
				break;
			case UP:
				if (head.getHeadY() > 0) {
					head.setHeadY(head.getHeadY() - 1);
				} else {
					head.setHeadY(Board.NumberOfBoxesY - 1);
				}
				break;
			case DOWN:
				if (head.getHeadY() < Board.NumberOfBoxesY - 1) {
					head.setHeadY(head.getHeadY() + 1);
				} else {
					head.setHeadY(0);
				}
				break;
			}
		} else if (MainMenu.StandardModeRb.isSelected()) {
			switch (head.getDirection()) {
			case RIGHT:
				head.setHeadX(head.getHeadX() + 1);
				break;
			case LEFT:
				head.setHeadX(head.getHeadX() - 1);
				break;
			case UP:
				head.setHeadY(head.getHeadY() - 1);
				break;
			case DOWN:
				head.setHeadY(head.getHeadY() + 1);
				break;
			}
		}

	}

	/**
	 * Conversion of coordinates of the playing field.
	 * 
	 * @author Tamara Romer
	 */
	public static Point coordinates(int x, int y) {
		Point p = new Point(0, 0);
		p.x = x * Board.BoxWidth + Screen.xoff;
		p.y = y * Board.BoxHeight + Screen.yoff;

		return p;
	}

}
