package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class Screen {
	JFrame frame= new JFrame ();
	
	public static int height = 600;
	public static int width = 800;
	public static int xoff = 130;
	public static int yoff=40; //20
	
	public void createFrame() {
		frame.setTitle("Snake");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		//frame.addKeyListener(new KeyHandler());
		
		JLabel captionLabel = new JLabel("Snake");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Cambria Math", Font.BOLD, 20));
		captionLabel.setForeground(new Color(127, 255, 0));
		captionLabel.setBackground(new Color(0, 0, 128));
		captionLabel.setBounds(0, 0, 800, 32);
		captionLabel.setOpaque(true);
		frame.getContentPane().add(captionLabel);
		
		Board board = new Board();
		board.setBounds(0, 0, width, height);
		board.setVisible(true);
		
		frame.add(board);		
		frame.setVisible(true);		
		System.out.println("Window made");
		
	}
	
	
	

}
