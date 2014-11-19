package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Oval implements GeometricalForm {
	
	private int x, y, width, height;
	private Color color;
	
	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		if(x < 0 || y < 0) {
			throw new IllegalPositionException();
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = c;
	}
	
	public Oval(GeometricalForm f, int width, int height, Color c) {
		x = f.getX();
		y = f.getY();
		this.width = width;
		this.height = height;
		color = c;
	}	
	
	@Override
	public int compareTo(GeometricalForm o) {
		if(this.getArea()<o.getArea()) {
			return -1;
		}
		if(this.getArea()>o.getArea()) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public void fill(Graphics g) {
		g.fillOval(this.x, this.y, this.width, this.height);
	}
	
	@Override
	public Color getColor() {
		return this.color;
	}
	
	@Override
	public int getArea() {
		return (int) (Math.PI*(this.width/2)*(this.height/2));
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public int getPerimeter() {
		return this.width*this.height;
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}
	
	@Override
	public int getX() {
		return this.x;
	}
	
	@Override
	public int getY() {
		return this.y;
	}
	
	public void move(int dx, int dy) throws IllegalPositionException {
		if((x + dx) < 0 || (y + dy) < 0) {
			throw new IllegalPositionException();
		}
		x = x+dx;
		y = y+dy;
		//TODO funkar?
	}//end move
	
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x < 0 || y < 0) {
			throw new IllegalPositionException();
		}
		this.x = x;
		this.y = y;
		// TODO funkar?
	}//end place

}