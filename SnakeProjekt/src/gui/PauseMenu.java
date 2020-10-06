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

public class PauseMenu extends JPanel {

	private JPanel PausePanel;
	private static JLabel PauseCaption;
	private static JButton ContinueButton;
	
	
	public PauseMenu() {
		add(createPauseMenuPanel());
		setBounds(0, Screen.height/3, Screen.width, Screen.height/4);
		setBackground(Color.GREEN);
		setLayout(null);
		setVisible(true);

	}
	
	
	private JPanel createPauseMenuPanel() {
		PausePanel = new JPanel();
		PausePanel .setBounds(Screen.width/3, 0, Screen.width/3, Screen.height/5);
		PausePanel.setBackground(Color.GREEN);
		PausePanel .setLayout(new GridLayout(0,1));
	
		
		PauseCaption = new JLabel("P A U S E");
		PauseCaption.setFont(new Font("Tahoma", Font.BOLD, 25));
		PauseCaption.setHorizontalAlignment(SwingConstants.CENTER);
		PauseCaption.setForeground(Color.BLACK);
		PauseCaption.setBounds(0, Screen.height/3,Screen.width, 25);
		
		
		ContinueButton= new JButton("Continue");
		ContinueButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ContinueButton.setForeground(Color.GREEN);
		ContinueButton.setBackground(Color.BLACK);
		ContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//Screen.gamestate = GameState.GAME;
				System.out.println("Continue Game");
			}
		});
		
		
	
		PausePanel.add(PauseCaption);
		PausePanel.add(ContinueButton);
		System.out.println("Pause Menu is build");
		return PausePanel;

	}


}
