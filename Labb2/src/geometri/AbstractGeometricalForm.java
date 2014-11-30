package geometri;

import Car;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractGeometricalForm implements GeometricalForm {
	
	private int x, y, width, height;
	private Color c;
	
	public AbstractGeometricalForm(int x, int y, int width, int height, Color c)
				throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to construct a new form " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	public AbstractGeometricalForm(GeometricalForm f, int width, int height, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.width = width;
		this.height = height;
		this.c = c;
	}

	@Override
	public int getArea() {
		return width*height;
	}

	@Override
	public int compareTo(GeometricalForm f) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public abstract void fill(Graphics g);

	@Override
	public Color getColor() {
		return c;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPerimeter() {
		return 2*width + 2*height;
	}

	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException();
		}
		this.x = x;
		this.y = y;
	}
	
	@Override
	public abstract int hashCode();
	
	@Override
	public boolean equals(Object o) {
		return false;
	}

}
