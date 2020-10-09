package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import action.KeyHandler;
import action.Timer;
import game.Snake;

public class Screen {
	static JFrame frame;
	static int height = 850;
	static int width = 1000;
	static int captionHeight = height / 17;
	public static int xoff = 55;
	public static int yoff = 70;
	public static GameState gamestate = GameState.MENU;
	public static MainMenu menu = new MainMenu();
	public static Board board = new Board();
	public static PauseMenu pausemenu = new PauseMenu();
	public static GameOver gameOver = new GameOver();

	public void createFrame() {
		frame = new JFrame("The snake");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(true);

		frame.addKeyListener(new KeyHandler());

		JLabel captionLabel = new JLabel("Snake");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Cambria Math", Font.BOLD, 30));
		captionLabel.setForeground(new Color(127, 255, 0));
		captionLabel.setBackground(new Color(0, 0, 128));
		captionLabel.setBounds(0, 0, width, captionHeight);
		captionLabel.setOpaque(true);
		frame.getContentPane().add(captionLabel);

		frame.add(menu);

		frame.setVisible(true);
		System.out.println("Window made");
	}

	public static void setGameState() {
		if (gamestate == GameState.GAME) {
			frame.add(board);
			board.setBounds(0, 0, width, height);
			board.requestFocus();
			board.setVisible(true);
			Timer timer = new Timer();
			timer.start();
			System.out.println("Game");

		} else if (gamestate == GameState.PAUSE) {
			Timer.running = false;
			frame.requestFocus();
			frame.add(pausemenu);
			board.setVisible(false);
			pausemenu.setVisible(true);
			System.out.println("Pause");
		
		} else if (gamestate == GameState.GAMEOVER) {
			frame.requestFocus();
			frame.add(gameOver);
			board.setVisible(false);
			gameOver.setVisible(true);
			System.out.println("Game over");

		}
	}
}
