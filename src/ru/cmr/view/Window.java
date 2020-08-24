package ru.cmr.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Window {
	JFrame frame;
	Canvas canv;
	
	private Timer timer;

	
	
	public Window() {
		frame = new JFrame("Snake");
		canv = new Canvas();
		canv.setBounds(0,0,Canvas.WIDTH,Canvas.HEIGHT);
		canv.setPreferredSize(new Dimension(Canvas.WIDTH,Canvas.HEIGHT));
		frame.add(canv);
		frame.setSize(canv.getSize());
		timer = new Timer(80, canv);
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start() {
		if (timer != null) {
			timer.start();
		}
	}
}
