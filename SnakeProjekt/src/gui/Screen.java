package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class Screen {
	JFrame frame;
	
	public static int height = 850;
	public static int width = 1000;
	public static int xoff = 90;
	public static int yoff= 70; //20
	
	public void createFrame() {
		frame = new JFrame ("The snake");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(true);
		
		//frame.addKeyListener(new KeyHandler());
		Board board = new Board();
		board.setBounds(0, 0, width, height);
		board.setVisible(true);
		
		JLabel captionLabel = new JLabel("Snake");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Cambria Math", Font.BOLD, 30));
		captionLabel.setForeground(new Color(127, 255, 0));
		captionLabel.setBackground(new Color(0, 0, 128));
		captionLabel.setBounds(0, 0, 1000, 52);
		captionLabel.setOpaque(true);		
		frame.getContentPane().add(captionLabel);		
		frame.add(board);
		
		frame.requestFocus();
		frame.setVisible(true);		
		System.out.println("Window made");
		
	}
	
	
	

}
