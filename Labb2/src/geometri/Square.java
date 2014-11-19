package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Square implements GeometricalForm {

	private int x, y, side;
	private Color color;
	
	public Square(int x, int y, int side, Color c) throws IllegalPositionException {
		if(x < 0 || y < 0) {
			throw new IllegalPositionException("Tried to construct a new Square " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.side = side;
		color = c;
	}
	
	public Square(GeometricalForm f, int side, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.side = side;
		color = c;
	}
	
	@Override
	public int getArea() {
		return (int) Math.pow(this.side, 2);
	}

	@Override
	public int compareTo(GeometricalForm f) {
		if(this.getArea()<f.getArea()) {
			return -1;
		}
		if(this.getArea()>f.getArea()) {
			return 1;
		}
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.fillRect(this.x, this.y, this.side, this.side);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public int getWidth() {
		return this.side;
	}

	@Override
	public int getHeight() {
		return this.side;
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
	public int getPerimeter() {
		return (int) Math.pow(this.side, 2);
	}

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
