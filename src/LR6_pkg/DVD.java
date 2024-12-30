package LR6_pkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import javax.swing.ImageIcon;
//import javax.swing.JLabel;

//import javax.swing.JTextField;


//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;


public class DVD extends Thread {
	private JPanel panel;
	private int step;
	private int size_x;
	private int size_y;
	private int x0;
	private int y0;

	public DVD(JPanel panel, int step, int size_x, int size_y, int x0, int y0) {
		super();
		this.panel = panel;
		this.step = step;
		this.size_x = size_x;
		this.size_y = size_y;
		this.x0 = x0;
		this.y0 = y0;
	}

	@Override
	public void run() {
		
        int x = x0;
		int y = y0;
		int xdir = +1;
		int ydir = +1;
		panel.setBackground(Color.BLUE);
		Graphics gr = panel.getGraphics();
        
		
		// получаем текущую рабочую папку откуда запущена программа
		// папка с изображением должна находиться в текущей папке программы
        var cwd = System.getProperty("user.dir");
		BufferedImage icon= new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Image icon2= icon;
		try {
			icon = ImageIO.read(new File(cwd + "\\images\\DVD_logo.png"));
			icon2 = icon.getScaledInstance(size_x, size_y, Image.SCALE_DEFAULT);
			gr.drawImage(icon2, x, y, panel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			icon= new BufferedImage(size_x, size_y, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = icon.createGraphics();
			graphics2D.setColor(Color.WHITE);
			graphics2D.fillRect(0, 0, size_x, size_y);
			graphics2D.dispose();
	        icon2= icon;
		}  

        

		while (true) {
			
				
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			gr.setColor(Color.BLUE);
			gr.fillRect(x, y, size_x, size_y);
			
			
			if (x > panel.getWidth() - size_x) {
				xdir = -1;
			}
			if (x < 0) {
				xdir = +1;
			}
			if (y > panel.getHeight() - size_y) {
				ydir = -1;
			}
			if (y < 0) {
				ydir = +1;
			}

			x += xdir * step;
			y += ydir * step;
			
			gr.drawImage(icon2, x, y, panel);
		}
	}
	
 	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
	
 	
	
	
}

