package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a square with methods adapted to squares
 * from the GeometricalForm interface.
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * @version 1.0
 *
 */

public class Square implements GeometricalForm {
	
	/*
	 * Instansvariabler
	 */
	private int x, y, side;
	private Color color;
	
	/**
	 * Constructs a new Square object.
	 * 
	 * @param x The position of the square's top left corner on the x-axis.
	 * @param y The position of the square's top left corner on the y-axis.
	 * @param side The length of each of the square's sides.
	 * @param c The colour of the square.
	 * @throws IllegalPositionException Thrown if the x and y coordinates is less than 0 (Illegal).
	 */
	public Square(int x, int y, int side, Color c) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to construct a new Square " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.side = side;
		color = c;
	}
	
	/**
	 * Constructs a new Square object.
	 * 
	 * @param f  A GeometricalForm that contains the x and y coordinates for the new rectangle object.
	 * @param side The length of each of the square's sides.
	 * @param c The colour of the square.
	 */
	public Square(GeometricalForm f, int side, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.side = side;
		color = c;
	}
	
	/**
	 * Get the area of this square as rounded to the closest integer.
	 * 
	 * @return - The area of the square as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return (int) Math.pow(this.side, 2);
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		if(this.getArea()<f.getArea()) {
			return -1;
		}
		if(this.getArea()>f.getArea()) {
			return 1;
		}
		return 0;
	}//end compareTo
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.fillRect(x, y, this.side, this.side);
	}
	
	/**
	 * Get the colour of this square.
	 * 
	 * @return The colour of this square.
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Get the width of this square.
	 * 
	 * @return The width of this square.
	 */
	@Override
	public int getWidth() {
		return this.side;
	}

	/**
	 * Get the height of this square.
	 * 
	 * @return The height of this square.
	 */
	@Override
	public int getHeight() {
		return this.side;
	}
	
	/**
	 * Get the x-coordinate of the top left corner for this square.
	 * 
	 * @return The x-coordinate of the top left corner for this square.
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the y-coordinate of the top left corner of this square.
	 * 
	 * @return The y-coordinate of the top left corner of this square.
	 */
	@Override
	public int getY() {
		return this.y;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		if((x + dx) <= 0 || (y + dy) <= 0) {
			throw new IllegalPositionException("Tried to move a square to " +
					"an illeagl position");
		}
		x = x+dx;
		y = y+dy;
	}//end move
	
	/**
	 * Get the perimeter for this square
	 * 
	 * @return - the perimeter of this square
	 */
	@Override
	public int getPerimeter() {
		return this.side*4;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to place a square on " +
					"an illegal position");
		}
		this.x = x;
		this.y = y;
	}//end place
	
}//end Oval