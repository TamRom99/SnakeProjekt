package gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JLabel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		//Draw bsckground
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Screen.width, Screen.height);
		
		
		
		g.setColor(Color.black);
		for(int i =0; i < 16; i++) {
			for(int k = 0; k < 16; i++) {
				g.drawRect(i*32 + Screen.xoff, i*32 + Screen.yoff, 32, 32);
				
				
		g.setColor(Color.black);
		g.fillRect(Screen.xoff, Screen.yoff, 512, 512);
			}
		}
	}

}
