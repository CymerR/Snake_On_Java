package ru.cmr.model;

import java.awt.Color;
import java.awt.Graphics;

import ru.cmr.view.Canvas;

public class SnakeObject {

	public static final int MAX_LENGTH = 200;

	private int[] sX = new int[MAX_LENGTH];
	private int[] sY = new int[MAX_LENGTH];

	private int currentLength = 2;
	
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	private int dir = DOWN;

	public SnakeObject(int x0, int y0) {
		sX[0] = x0;
		sY[0] = y0;
		sX[1] = x0 - 1;
		sY[1] = y0;
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(sX[0] * Canvas.tileSize, sY[0] * Canvas.tileSize, Canvas.tileSize, Canvas.tileSize);
		for (int i = currentLength; i > 0; i--) {
			g.setColor(Color.blue);
			g.fillRect(sX[i] * Canvas.tileSize, sY[i] * Canvas.tileSize, Canvas.tileSize, Canvas.tileSize);
		}
	}

	public void step() {

		autoMove();

	}

	private void autoMove() {
		move();
	}

	public void move() {

		for (int i = currentLength; i > 0; i--) {
			
			sX[i] = sX[i - 1];
			sY[i] = sY[i - 1];
		}

		switch (dir) {
		case LEFT:
			sX[0]--;
			break;
		case RIGHT:
			sX[0]++;
			break;
		case UP:
			sY[0]--;
			break;
		case DOWN:
			sY[0]++;
			break;
		}

	}

	public void changeDirection(int newDirection) {
		// change the direction only if the new direction is valid
		boolean isValidDirection = (dir == LEFT & newDirection != RIGHT) || (dir == RIGHT & newDirection != LEFT)
				|| (dir == UP & newDirection != DOWN) || (dir == DOWN & newDirection != UP);
		if (isValidDirection) {
			dir = newDirection;
		}
	}

}
