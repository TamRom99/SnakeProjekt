package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import action.Collision;
import action.Timer;
import game.Snake;

/**
 * The Game Over class forms the menu that is displayed at the end of a game. It
 * can be used to start a new game or close the window
 * 
 * @author Tamara Romer
 */

public class GameOver extends JPanel {

	// Declaration of the menu components
	private JPanel GameOverPanel;
	private JLabel GameOverCaption;
	private JLabel ScoreLabel;
	private JButton RestartButton;
	private JButton ExitButton;

	/**
	 * Constructor of the class Game Over, which creates the JPanel (without any Layout) and calls
	 * createPanelGameOver-Method.
	 */
	GameOver() {
		add(createGameOverPanel());
		setBounds(Screen.xoff, Screen.captionHeight + 150, Screen.width - 2 * Screen.xoff, Screen.height / 2 + 50);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);

	}

	/**
	 * In the method, the various Swing elements are instantiated and combined into
	 * a menu using a JLabel and the grid layout manager. Action Listener and Action
	 * Performed give the two buttons the functions for restarting a game and
	 * closing the window.
	 */
	private JPanel createGameOverPanel() {
		// Create the Panel for the menucomponents
		GameOverPanel = new JPanel();
		GameOverPanel.setBounds(Screen.width / 5, 0, Screen.width / 2, Screen.height / 2);
		GameOverPanel.setLayout(new GridLayout(0, 1));
		GameOverPanel.setBackground(Color.BLACK);

		// Create GameOver Caption
		GameOverCaption = new JLabel("G A M E    O V E R");
		GameOverCaption.setFont(new Font("Tahoma", Font.BOLD, 50));
		GameOverCaption.setHorizontalAlignment(SwingConstants.CENTER);
		GameOverCaption.setForeground(Color.ORANGE);

		// Create display for the score
		ScoreLabel = new JLabel("Your Score: " + Collision.score);
		ScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreLabel.setForeground(Color.ORANGE);

		// Create RestartButton
		RestartButton = new JButton("Restart");
		RestartButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		RestartButton.setForeground(Color.WHITE);
		RestartButton.setBackground(Color.ORANGE);
		RestartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sets the game state to game and calls the setGameMethode to change graphics
				Screen.gamestate = GameState.GAME;
				Screen.setGameState();
				Screen.gameOver.setVisible(false);
				// Sets the score, timer and snake to initial values
				Collision.score = 0;
				Timer.millisec = 200;
				Snake.head.setHeadX(Board.NumberOfBoxesX / 2);
				Snake.head.setHeadY(Board.NumberOfBoxesY / 2);
				Snake.SnakeInitialize();
				System.out.println("Restart Game");
			}
		});

		// Create ExitButton to close the game and the window
		ExitButton = new JButton("Exit");
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setBackground(Color.ORANGE);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Merge the menu components
		GameOverPanel.add(GameOverCaption);
		GameOverPanel.add(ScoreLabel);
		GameOverPanel.add(RestartButton);
		GameOverPanel.add(ExitButton);
		System.out.println("GameOver Menu is build");
		return GameOverPanel;

	}

}
