package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import action.KeyHandler;
import action.Main;

public class Screen {
	static JFrame frame;
	static int height = 850;
	static int width = 1000;
	static int captionHight = height / 17;
	public static int xoff = 55;
	public static int yoff = 70;
	public static GameState gamestate = GameState.MENU;
	static MainMenu menu = new MainMenu();

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
		captionLabel.setBounds(0, 0, width, captionHight);
		captionLabel.setOpaque(true);
		frame.getContentPane().add(captionLabel);

			
		

		frame.add(menu);
		
	
		

		frame.addKeyListener(new KeyHandler());

		
		
	
		frame.setVisible(true);
		System.out.println("Window made");

	}
	
	public static void setGameState () {
		if (gamestate == GameState.GAME) {
		  	System.out.println ("Gameeeee");
		  	Board board = new Board();	
			board.setBounds(0, 0, width, height);
			board.requestFocus();
			frame.add(board);
			board.setVisible(true);
			
			
		
		} else if (gamestate == GameState.PAUSE) {
			PauseMenu pausemenu = new PauseMenu();
			frame.requestFocus();
			frame.add(pausemenu);
		} else if (gamestate == GameState.GAMEOVER) {
			GameOver gameOver = new GameOver();
			frame.requestFocus();
			frame.add(gameOver);
			
		}
	}
	
}
