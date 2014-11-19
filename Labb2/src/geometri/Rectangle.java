package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a rectangle with methods adapted to rectangles
 * from the GeometricalForm interface.
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * @version 1.0
 *
 */

public class Rectangle implements GeometricalForm {
	
	/**
	 * The x-coordinate for the top left corner of the rectangle
	 */
	private int x;
	
	/**
	 * The y-coordinate for the top left corner of the rectangle
	 */
	private int y;
	
	/**
	 * The width of the rectangle
	 */
	private int width;
	
	/**
	 * The height of the rectangle
	 */
	private int height;
	
	/**
	 * The colour of the rectangle
	 */
	private Color color;
	
	/**
	 * Constructs a new Rectangle object.
	 * 
	 * @param x The position of the rectangle's top left corner on the x-axis.
	 * @param y The position of the rectangle's top left corner on the y-axis.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The colour of the rectangle.
	 * @throws IllegalPositionException Thrown if the x and y coordinates is less than 0 (Illegal).
	 */
	public Rectangle(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to construct a new Rectangle " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = c;
	}
	
	/**
	 * Constructs a new Rectangle object.
	 * 
	 * @param f  A GeometricalForm that contains the x and y coordinates for the new rectangle object.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The colour of the rectangle.
	 */
	public Rectangle(GeometricalForm f, int width, int height, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.width = width;
		this.height = height;
		color = c;
	}
	
	/**
	 * Get the area of this rectangle as rounded to the closest integer.
	 * 
	 * @return - The area of the rectangle as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return this.height*this.width;
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
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	/**
	 * Get the colour of this rectangle.
	 * 
	 * @return The colour of this rectangle.
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Get the width of this rectangle.
	 * 
	 * @return The width of this rectangle.
	 */
	@Override
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Get the height of this rectangle.
	 * 
	 * @return The height of this rectangle.
	 */
	@Override
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Get the x-coordinate of the top left corner for this rectangle.
	 * 
	 * @return The x-coordinate of the top left corner for this rectangle.
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the y-coordinate of the top left corner of this rectangle.
	 * 
	 * @return The y-coordinate of the top left corner of this rectangle.
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
			throw new IllegalPositionException();
		}
		x = x+dx;
		y = y+dy;
	}//end move
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException();
		}
		this.x = x;
		this.y = y;
	}//end place
	
	/**
	 * Get the perimeter for this rectangle
	 * 
	 * @return - the perimeter of this rectangle
	 */
	@Override
	public int getPerimeter() {
		return (this.height*2) + (this.width*2);
	}

}//end Rectangle