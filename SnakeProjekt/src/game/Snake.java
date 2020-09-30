package game;

import gui.Screen;
import java.awt.*;
import java.util.ArrayList;

public class Snake {
	public static boolean waitToMove = false;
	public static Head head = new Head(7, 7);
	public static ArrayList<Tail> tails = new ArrayList<>();

	public static Food food = new Food();

	public static void addTail() {
		if (tails.size() < 1) {
			tails.add(new Tail(head.getHeadX(), head.getHeadY()));
		} else {
			tails.add(new Tail(tails.get(tails.size() - 1).TailX, tails.get(tails.size() - 1).TailY));
		}
	}

	void move() {
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

		// Move first Tail to Head
		if (tails.size() >= 1) {
			if (tails.get(0).isWait()) {
				tails.get(0).setTailX(head.getHeadX());
				tails.get(0).setTailY(head.getHeadY());
			}
		}

		// Move Head
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

	public static Point coordinates(int x, int y) {
		Point p = new Point(0, 0);
		p.x = x * 32 + Screen.xoff;
		p.y = y * 32 + Screen.yoff;

		return p;
	}

}
