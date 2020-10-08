package action;

import game.Snake;
import gui.Screen;

public class Main {

	public static void main(String[] args) {

		Screen screen = new Screen();

		Snake.SnakeInitialize();

		screen.createFrame();

	}

}
