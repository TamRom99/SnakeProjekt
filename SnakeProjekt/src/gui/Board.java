package gui;

import game.Snake;
import javax.swing.*;
import java.awt.*;

public class Board extends JLabel {
	public static int NumberOfBoxesX = 35;
	public static int NumberOfBoxesY = 25;
	private static int BoxWidth = 25;
	private static int BoxHeight = 25;
	Point p;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

		// Draw background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Screen.width, Screen.height);


		// Draw Grid
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < NumberOfBoxesX; i++) {
			for (int k = 0; k < NumberOfBoxesY; k++) {
				g.drawRect(i * 25 + Screen.xoff, k * 25 + Screen.yoff, BoxWidth, BoxHeight);	}
		}
		// Draw Border
		g.setColor(Color.black);
		g.drawRect(Screen.xoff, Screen.yoff, BoxWidth*NumberOfBoxesX , BoxHeight* NumberOfBoxesY);

		//Draw Head
				g.setColor(Color.GREEN);
				p = Snake.coordinates(Snake.head.getHeadX(), Snake.head.getHeadY());
				g.fillRect(p.x, p.y, BoxWidth, BoxHeight);
				
		//Draw Tails
		g.setColor(new Color(127, 255, 0));
		for (int i = 0; i < Snake.tails.size(); i++) {
			p = Snake.coordinates(Snake.tails.get(i).getTailX(), Snake.tails.get(i).getTailY());
			g.fillRect(p.x, p.y, BoxWidth, BoxHeight);
		}

		//Draw Food
		g.setColor(Color.ORANGE);
		p = Snake.coordinates(Snake.food.getFoodX(), Snake.food.getFoodY());
		g.fillRect(p.x, p.y, BoxWidth, BoxHeight);
		
		//Draw Score
		g.setColor(new Color(127, 255, 0));
		g.fillOval(300,725 , 400, 50);
		g.setColor(new Color(0, 0, 128));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score:", 450, 760);
		

		repaint();
	}

}
