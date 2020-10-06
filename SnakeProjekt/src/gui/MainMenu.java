package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JPanel {

	private JPanel menuPanel;
	private JLabel picture;
	private Icon snakeIcon;
	private static JButton StartButton;
	private JRadioButton StandardModeRb;
	private JRadioButton FreeModeRb;

	public MainMenu() {
		add(createPicture());
		add(createMainMenuPanel());
		setSize(Screen.width, Screen.height - Screen.captionHight);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setVisible(true);

	}

	private JLabel createPicture() {
		snakeIcon = new ImageIcon(getClass().getResource("SnakeIcon.png"));
		picture = new JLabel(snakeIcon);
		picture.setBounds(Screen.width / 3, Screen.captionHight+50, Screen.width / 3, Screen.height / 3);

		return picture;
	}

	private JPanel createMainMenuPanel() {
		menuPanel = new JPanel();
		menuPanel.setBounds(Screen.width / 3, Screen.height / 2, Screen.width / 3, Screen.height / 3);
		menuPanel.setLayout(new GridLayout(0, 1));
		menuPanel.setBackground(Color.DARK_GRAY);

		StartButton = new JButton("Start");
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		StartButton.setForeground(Color.GREEN);
		StartButton.setBackground(new Color(0, 0, 128));
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Screen.gamestate = GameState.GAME;
				System.out.println("Button is pressed");
			}
		});

		ButtonGroup bg = new ButtonGroup();
		StandardModeRb = new JRadioButton("Standard-Mode");
		StandardModeRb.setForeground(Color.WHITE);
		StandardModeRb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StandardModeRb.setBackground(Color.DARK_GRAY);
		StandardModeRb.setSelected(true);
		bg.add(StandardModeRb);

		FreeModeRb = new JRadioButton("Free-Mode");
		FreeModeRb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FreeModeRb.setForeground(Color.WHITE);
		FreeModeRb.setBackground(Color.DARK_GRAY);
		bg.add(FreeModeRb);

		
		menuPanel.add(StartButton);
		menuPanel.add(StandardModeRb);
		menuPanel.add(FreeModeRb);

		System.out.println("Menu is build");
		return menuPanel;

	}

}
