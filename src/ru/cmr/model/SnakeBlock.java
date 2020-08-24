package ru.cmr.model;

import java.awt.Color;
import java.awt.Graphics;

import ru.cmr.view.Canvas;

public class SnakeBlock {
	int posx, posy;

	public int[] getPos() {
		return new int[]{posx,posy};
	}

	public void setPos(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public SnakeBlock(int posx, int posy) {
		super();
		this.posx = posx;
		this.posy = posy;
	}

	public SnakeBlock() {
		super();
	}
	
	public void draw(Graphics g) {
		//draw rect representing body object
		g.setColor(Color.BLUE);
		g.fillRect(posx*Canvas.tileSize, posy*Canvas.tileSize, Canvas.tileSize, Canvas.tileSize);
	}
	
	public void move(int x, int y) {
		this.posx += x;
		this.posy += y;
	}

	@Override
	public String toString() {
		return "SnakeBlock [posx=" + posx + ", posy=" + posy + "]";
	}

	
	
}
