package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JLabel {
	JButton StartButton;
	JRadioButton StandardModeRb;
	JRadioButton FreeModeRb;
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		StartButton = new JButton("S T A R T");
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		StartButton.setForeground(Color.GREEN);
		StartButton.setBounds(155, 73, 109, 44);
		StartButton.setVisible(true);		
		
		
		StandardModeRb = new JRadioButton("Standard-Mode");
		StandardModeRb.setBounds(155, 136, 127, 25);
		StandardModeRb.setVisible(true);
		
		
		FreeModeRb = new JRadioButton("Free-Mode");
		FreeModeRb.setBounds(155, 166, 127, 25);
		FreeModeRb.setVisible(true);
		 repaint();
		
	}
	

}
