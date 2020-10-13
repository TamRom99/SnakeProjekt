package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import game.Snake;

/**
 * In the PauseMenu class, Swing is used to display the pause menu that can be
 * called during the game with the space bar.
 * 
 * @author Tamara Romer
 */

public class PauseMenu extends JPanel {

	/**
	 * Declaration of the menu components.
	 */
	private JPanel PausePanel;
	private JLabel PauseCaption;
	private JButton ContinueButton;

	/**
	 * Constructor of the class PauseMenu, which creates the JPanel (without any
	 * Layout) and calls createPauseMenuPanel-Method.
	 */
	PauseMenu() {
		add(createPauseMenuPanel());
		setBounds(0, Screen.height / 3, Screen.width, Screen.height / 4);
		setBackground(Color.GREEN);
		setLayout(null);
		setVisible(true);

	}

	/**
	 * In the method, the various Swing elements are instantiated and combined into
	 * a menu using a JLabel and the grid layout manager. A JLabel for the headline
	 * and a button to continue the game is added to the panel.
	 */
	private JPanel createPauseMenuPanel() {
		// Create the Panel for the menucomponents
		PausePanel = new JPanel();
		PausePanel.setBounds(Screen.width / 3, 0, Screen.width / 3, Screen.height / 5);
		PausePanel.setBackground(Color.GREEN);
		PausePanel.setLayout(new GridLayout(0, 1));

		// Create Pause Caption
		PauseCaption = new JLabel("P A U S E");
		PauseCaption.setFont(new Font("Tahoma", Font.BOLD, 25));
		PauseCaption.setHorizontalAlignment(SwingConstants.CENTER);
		PauseCaption.setForeground(Color.BLACK);
		PauseCaption.setBounds(0, Screen.height / 3, Screen.width, 25);

		// Create a JButton with which the game can be continued
		ContinueButton = new JButton("Continue");
		ContinueButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ContinueButton.setForeground(Color.GREEN);
		ContinueButton.setBackground(Color.BLACK);
		ContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sets the game state to game and calls the setGameStateMethod to change
				// graphics
				Screen.gamestate = GameState.GAME;
				Screen.setGameState();
				// Makes the pause menu disappear and shows the board
				Screen.board.setVisible(true);
				Screen.pausemenu.setVisible(false);
				// Starts the timer again and continue the game process
				Snake.timer.start();
				// Set the focus new
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Screen.menu);
				frame.requestFocusInWindow();
				System.out.println("Continue Game");
			}
		});

		// Merge the menu components
		PausePanel.add(PauseCaption);
		PausePanel.add(ContinueButton);
		System.out.println("Pause Menu is build");
		return PausePanel;

	}

}
