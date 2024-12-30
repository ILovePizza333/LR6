package LR6_pkg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends Thread {
	private JPanel panel;
	private int step;
	private int size;
	private int x0;
	private int y0;

	public Ball(JPanel panel, int step, int size, int x0, int y0) {
		super();
		this.panel = panel;
		this.step = step;
		this.size = size;
		this.x0 = x0;
		this.y0 = y0;
	}

	@Override
	public void run() {
		int x = x0;
		int y = y0;
		int xdir = +1;
		int ydir = +1;
		panel.setBackground(Color.GRAY);
		Graphics gr = panel.getGraphics();
		while (true) {
			gr.setColor(Color.WHITE);
			gr.fillOval(x, y, size, size);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gr.setColor(Color.GRAY);
			gr.fillOval(x, y, size, size);

			if (x > panel.getWidth() - size) {
				xdir = -1;
			}
			if (x < size) {
				xdir = +1;
			}
			if (y > panel.getHeight() - size) {
				ydir = -1;
			}
			if (y < size) {
				ydir = +1;
			}

			x += xdir * step;
			y += ydir * step;
		}
	}
}