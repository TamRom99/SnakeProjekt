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
import game.Snake;

public class GameOver extends JPanel {

	private static JPanel GameOverPanel;
	private static JLabel GameOverCaption;
	private static JLabel ScoreLabel;

	private static JButton RestartButton;
	private static JButton ExitButton;

	public GameOver() {
		add(createGameOverPanel());
		setBounds(Screen.xoff, Screen.captionHeight + 150, Screen.width - 2 * Screen.xoff, Screen.height / 2 +50);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);

	}

	private JPanel createGameOverPanel() {
		GameOverPanel = new JPanel();
		GameOverPanel.setBounds(Screen.width / 5, 0, Screen.width / 2, Screen.height / 2);
		GameOverPanel.setLayout(new GridLayout(0, 1));
		GameOverPanel.setBackground(Color.BLACK);

		GameOverCaption = new JLabel("G A M E    O V E R");
		GameOverCaption.setFont(new Font("Tahoma", Font.BOLD, 50));
		GameOverCaption.setHorizontalAlignment(SwingConstants.CENTER);
		GameOverCaption.setForeground(Color.ORANGE);

		ScoreLabel = new JLabel("Your Score: " + Collision.score);
		ScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ScoreLabel.setForeground(Color.ORANGE);

		RestartButton = new JButton("Restart");
		RestartButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		RestartButton.setForeground(Color.WHITE);
		RestartButton.setBackground(Color.ORANGE);
		RestartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Restart Game");
				Screen.gamestate = GameState.GAME;
				Screen.gameOver.setVisible(false);
				Screen.setGameState();
				Collision.score = 0;
				Snake.head.setHeadX(Board.NumberOfBoxesX / 2);
				Snake.head.setHeadY(Board.NumberOfBoxesY / 2);
				Snake.SnakeInitialize();

			}
		});

		ExitButton = new JButton("Exit");
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setBackground(Color.ORANGE);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		GameOverPanel.add(GameOverCaption);
		GameOverPanel.add(ScoreLabel);
		GameOverPanel.add(RestartButton);
		GameOverPanel.add(ExitButton);
		System.out.println("GameOver Menu is build");
		return GameOverPanel;

	}

}
