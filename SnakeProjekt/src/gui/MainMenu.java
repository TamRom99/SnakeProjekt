package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends Screen {
	JButton StartButton;
	JRadioButton StandardModeRb;
	JRadioButton FreeModeRb;
	
	
	
	
	
	public void createMenu() {
		
	
		
		StartButton = new JButton("S T A R T");
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		StartButton.setForeground(Color.GREEN);
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		StartButton.setBounds(155, 73, 109, 44);
		StartButton.setVisible(true);
		frame.getContentPane().add(StartButton);
		
		
		StandardModeRb = new JRadioButton("Standard-Modus");
		StandardModeRb.setBounds(155, 136, 127, 25);
		StandardModeRb.setVisible(true);
		frame.getContentPane().add(StandardModeRb);
		
		FreeModeRb = new JRadioButton("Freier-Modus");
		FreeModeRb.setBounds(155, 166, 127, 25);
		FreeModeRb.setVisible(true);
		frame.getContentPane().add(FreeModeRb);
		
	}
	

}
