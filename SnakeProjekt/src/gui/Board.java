package gui;

import game.Snake;
import javax.swing.*;
import java.awt.*;

public class Board extends JLabel {

	Point p;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

		// Draw background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Screen.width, Screen.height);

		// Draw caption
		/*
		 * g.setColor(new Color(0, 0, 128)); g.fillRect(0, 0, 1000, 52); g.setFont(new
		 * Font("Cambria Math", Font.BOLD, 30)); g.setColor(new Color(127, 255, 0));
		 * g.drawString("Snake", 450, 35);
		 */

		// Draw Grid
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(90, 70, 800, 640);
		for (int i = 0; i < 25; i++) {
			for (int k = 0; k < 20; k++) {
				g.drawRect(i * 32 + Screen.xoff, k * 32 + Screen.yoff, 32, 32);

			}
		}
		// Draw Border
		g.setColor(Color.black);
		g.drawRect(Screen.xoff, Screen.yoff, 800, 640);

		//Draw Tails
		g.setColor(new Color(127, 255, 0));
		for (int i = 0; i < Snake.tails.size(); i++) {
			p = Snake.coordinates(Snake.tails.get(i).getTailX(), Snake.tails.get(i).getTailY());
			g.fillRect(p.x, p.y, 32, 32);
		}

		//Draw Head
		g.setColor(Color.GREEN);
		p = Snake.coordinates(Snake.head.getHeadX(), Snake.head.getHeadY());
		g.fillRect(p.x, p.y, 32, 32);

		//Draw Food
		g.setColor(Color.ORANGE);
		p = Snake.coordinates(Snake.food.getFoodX(), Snake.food.getFoodY());
		g.fillRect(p.x, p.y, 32, 32);

		repaint();
	}

}
