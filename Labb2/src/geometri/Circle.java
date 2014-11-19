package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements GeometricalForm {
	
	private int x, y, diameter;
	private Color color;
	
	public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
		if(x<0 || y<0) {
			throw new IllegalPositionException();
		}
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = c;
	}
	
	public Circle(GeometricalForm f, int diameter, Color c) {
		x = f.getX();
		y = f.getY();
		this.diameter = diameter;
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
		g.fillOval(this.x, this.y, this.diameter, this.diameter);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public int getArea() {
		return (int) (Math.PI*Math.pow(diameter/2, 2));
	}

	@Override
	public int getHeight() {
		return this.diameter;
	}

	@Override
	public int getPerimeter() {
		return (int) Math.pow(this.getWidth(), 2);
	}

	@Override
	public int getWidth() {
		return this.diameter;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
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

}//end Circle
