package action;

import gui.Screen;
import timer.Timer;

public class Main {

	public static void main(String[] args) {

		Screen screen = new Screen();
		Timer timer = new Timer();
		
		screen.createFrame();
		timer.start();
	}

}
