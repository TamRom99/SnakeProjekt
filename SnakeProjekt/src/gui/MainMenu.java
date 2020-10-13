package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Snake;

/**
 * In the class, the main menu is created which can be used to start the game
 * and select the game modes.
 * 
 * @author Tamara Romer
 */

public class MainMenu extends JPanel {

	/**
	 * Declaration of components for the startmenu.
	 */
	private JPanel menuPanel;
	private JLabel picture;
	private Icon snakeIcon;
	private JButton StartButton;
	public static JRadioButton StandardModeRb;
	public static JRadioButton FreeModeRb;

	/**
	 * Constructor of the Main Menu class, which creates the panel for the menu at
	 * the beginning of a game.
	 */
	MainMenu() {
		add(createPicture());
		add(createMainMenuPanel());
		setSize(Screen.width, Screen.height - Screen.captionHeight);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);

	}

	/**
	 * The create Picture method implements the png image into the panel.
	 */
	private JLabel createPicture() {
		snakeIcon = new ImageIcon(getClass().getResource("SnakeIcon.png"));
		picture = new JLabel(snakeIcon);
		picture.setBounds(Screen.width / 3, Screen.captionHeight + 50, Screen.width / 3, Screen.height / 3);

		return picture;
	}

	/**
	 * In the method, the various Swing elements are instantiated and combined into
	 * a menu using a JLabel and the grid layout manager. With the JButton Start the
	 * playing field appears and the game is started. With the help of the two radio
	 * buttons you can also select the game mode.
	 */
	private JPanel createMainMenuPanel() {
		// Create the Panel for the menucomponents
		menuPanel = new JPanel();
		menuPanel.setBounds(Screen.width / 3, Screen.height / 2, Screen.width / 3, Screen.height / 3);
		menuPanel.setLayout(new GridLayout(0, 1));
		menuPanel.setBackground(Color.DARK_GRAY);

		// Create the JButton for the gamestart
		StartButton = new JButton("Start");
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		StartButton.setForeground(Color.GREEN);
		StartButton.setBackground(new Color(0, 0, 128));
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Sets the game state to game and calls the setGameMethode to change graphics
				Screen.gamestate = GameState.GAME;
				Screen.setGameState();
				// Makes the main menu disappear, shows the board and initialize the snake
				Screen.menu.setVisible(false);
				Snake.SnakeInitialize();
				System.out.println("Button is pressed");

			}
		});

		// Create a button group so that only one button can be selected at a time
		ButtonGroup bg = new ButtonGroup();

		// Create the radio button for selecting the game mode Standard,
		// in which the snake dies when it collides with the wall
		StandardModeRb = new JRadioButton("Standard-Mode");
		StandardModeRb.setForeground(Color.WHITE);
		StandardModeRb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StandardModeRb.setBackground(Color.DARK_GRAY);
		// Set a start marker on the button Standard.
		StandardModeRb.setSelected(true);
		// Add the button to the button group
		bg.add(StandardModeRb);

		// Create the radio button for selecting the game mode Freemode,
		// in which the snake can run through the walls
		FreeModeRb = new JRadioButton("Free-Mode");
		FreeModeRb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FreeModeRb.setForeground(Color.WHITE);
		FreeModeRb.setBackground(Color.DARK_GRAY);
		// Add the button to the button group.
		bg.add(FreeModeRb);

		// Merge the menu components
		menuPanel.add(StartButton);
		menuPanel.add(StandardModeRb);
		menuPanel.add(FreeModeRb);

		System.out.println("Menu is build");
		return menuPanel;

	}

}
