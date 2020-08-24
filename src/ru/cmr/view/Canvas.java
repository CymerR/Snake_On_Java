package ru.cmr.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import ru.cmr.model.SnakeObject;

public class Canvas extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5160695626515961040L;

	// preferences
	public static int tileSize = 32;
	public static final int cols = 40;
	public static final int WIDTH = tileSize * cols, HEIGHT = tileSize * cols;
	//

	private SnakeObject snake;

	public Canvas() {
		snake = new SnakeObject(2, 1);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setBackground(Color.black);
		addKeyListener(new EventHandler());
		setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// timer worked as it do;
		// repaint
		repaint();

		snake.step();

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		snake.draw(g);

		// grid
		g.setColor(Color.darkGray.darker());
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < cols; j++) {
				g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
			}
		}

	}

	class EventHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				snake.changeDirection(SnakeObject.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDirection(SnakeObject.DOWN);
				break;

			case KeyEvent.VK_LEFT:
				snake.changeDirection(SnakeObject.LEFT);
				break;

			case KeyEvent.VK_RIGHT:
				snake.changeDirection(SnakeObject.RIGHT);
				break;

			default:
				break;
			}
			;
		}

	}

}
