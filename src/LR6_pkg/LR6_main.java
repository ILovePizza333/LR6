package LR6_pkg;


import java.awt.GridLayout;

import javax.swing.*;

public class LR6_main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("DVD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocation(300, 0);
		frame.setLayout(new GridLayout(2,2,10,10));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		frame.setVisible(true);
		DVD dvd1 = new DVD(panel1, 20, 70, 70, 30, 80);
		DVD dvd2 = new DVD(panel2, 10, 100, 100, 50, 50);
		DVD dvd3 = new DVD(panel3, 5, 150, 150, 30, 30);
		DVD dvd4 = new DVD(panel4, 5, 200, 200, 30, 30);
		dvd1.start();
		dvd2.start();
		dvd3.start();
		dvd4.start();
		
		//Ball ball4 = new Ball(panel4, 5, 50, 30, 30);
		//ball4.start();
	}


}