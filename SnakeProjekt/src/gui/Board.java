package gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JLabel {

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
		g.fillRect(90, 70, 800, 640);
		for (int i = 0; i < 25; i++) {
			for (int k = 0; k < 20; k++) {
				g.drawRect(i * 32 + Screen.xoff, k * 32 + Screen.yoff, 32, 32);

			}
		}
		// Draw Border
		g.setColor(Color.black);
		g.drawRect(Screen.xoff, Screen.yoff, 800, 640);
		repaint();
	}

}
