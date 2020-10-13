package gui;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import game.Snake;
import action.Collision;

/**
 * The class board is responsible for drawing the playing field and the game
 * components.
 * 
 * @author Tamara Romer
 */

public class Board extends JLabel {

	/**
	 * Declaration of field and box width and height.
	 */
	public static int NumberOfBoxesX = 35;
	public static int NumberOfBoxesY = 25;
	public static int BoxWidth = 25;
	public static int BoxHeight = 25;
	Point p;

	/**
	 * The PaintComponent method with the Graphics g parameter is used to draw the
	 * elements. The Graphics object is casted to Graphics2D to improve the display.
	 * By setRenderingHint the anti-aliasing is turned on, which smoothes the edges
	 * and avoids steps.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw Background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Screen.width, Screen.height);

		// Draw Grid
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < NumberOfBoxesX; i++) {
			for (int k = 0; k < NumberOfBoxesY; k++) {
				g.drawRect(i * BoxWidth + Screen.xoff, k * BoxHeight + Screen.yoff, BoxWidth, BoxHeight);
			}
		}

		// Draw Border
		g.setColor(Color.black);
		g.drawRect(Screen.xoff, Screen.yoff, BoxWidth * NumberOfBoxesX, BoxHeight * NumberOfBoxesY);

		// Draw Head
		g.setColor(new Color(0, 204, 0));
		p = Snake.coordinates(Snake.head.getHeadX(), Snake.head.getHeadY());
		g.fillRect(p.x, p.y, BoxWidth, BoxHeight);

		// Draw Tails
		g.setColor(new Color(127, 255, 0));
		for (int i = 0; i < Snake.tails.size(); i++) {
			p = Snake.coordinates(Snake.tails.get(i).getTailX(), Snake.tails.get(i).getTailY());
			g.fillRect(p.x, p.y, BoxWidth, BoxHeight);
		}

		// Draw Food
		g.setColor(Color.ORANGE);
		p = Snake.coordinates(Snake.food.getFoodX(), Snake.food.getFoodY());
		g.fillRect(p.x, p.y, BoxWidth, BoxHeight);

		// Draw Score
		g.setColor(new Color(127, 255, 0));
		g.fillOval(300, 725, 400, 50);
		g.setColor(new Color(0, 0, 128));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Score: " + Collision.score, 470, 760);

		repaint();
	}

}
