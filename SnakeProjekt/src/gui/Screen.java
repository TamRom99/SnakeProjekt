package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import action.KeyHandler;
import action.Timer;
import game.Snake;

/**
 * The Screen class creates the window and performs the graphical content
 * changes.
 * @author Tamara Romer
 */

public class Screen {

	/**
	 * Declaration of the frame,its variables and the different menus.
	 */
	private static JFrame frame;
	private JLabel captionLabel;
	static int height = 850;
	static int width = 1000;
	static int captionHeight = height / 17;
	public static int xoff = 55;
	public static int yoff = 70;
	public static GameState gamestate = GameState.MENU;
	public static MainMenu menu;
	static Board board;
	static PauseMenu pausemenu;
	static GameOver gameOver;

	/**
	 * The method creates the frame window in which the complete graphic is
	 * displayed. The frame window is not assigned a layout and is displayed in the
	 * middle of the screen. For the keyboard input the keyListener is added to the
	 * window.
	 */
	public void createFrame() {

		// Create the frame
		frame = new JFrame("The snake");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		// Places the window in the center of the screen
		frame.setLocationRelativeTo(null);
		// Adds the layout null and the backgroundcolor darkgrey to the window
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		// Does not allow to drag the game larger
		frame.setResizable(false);
		// Adds keylistener for keyboard input to the window
		frame.addKeyListener(new KeyHandler());

		// Create and add the MainCaption of the game
		captionLabel = new JLabel("Snake");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Cambria Math", Font.BOLD, 30));
		captionLabel.setForeground(new Color(127, 255, 0));
		captionLabel.setBackground(new Color(0, 0, 128));
		captionLabel.setBounds(0, 0, width, captionHeight);
		captionLabel.setOpaque(true);
		frame.add(captionLabel);

		// Instantiation and addition of the game menu
		menu = new MainMenu();
		frame.add(menu);

		frame.setVisible(true);
		System.out.println("Window made");
	}

	/**
	 * The method uses If-branches and the game state of the enum to perform
	 * graphical changes in the window.
	 * 
	 * @authors Tamara Romer, Ilayda Alkan, Chiara Frankenbach
	 */
	public static void setGameState() {
		// Performs the graphic change to the playing field
		if (gamestate == GameState.GAME) {
			board = new Board();
			frame.add(board);
			board.setBounds(0, 0, width, height);
			board.setVisible(true);
			Snake.timer = new Timer();
			System.out.println("Game");

			// Performs the graphical change to the pause menu
		} else if (gamestate == GameState.PAUSE) {
			Snake.timer.stop();
			pausemenu = new PauseMenu();
			frame.add(pausemenu);
			board.setVisible(false);
			pausemenu.setVisible(true);
			System.out.println("Pause");

			// Performs the graphical change to the game over display
		} else if (gamestate == GameState.GAMEOVER) {
			gameOver = new GameOver();
			frame.add(gameOver);
			board.setVisible(false);
			gameOver.setVisible(true);
			System.out.println("Game over");

		}
	}
}
