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

public class Rectangle extends AbstractGeometricalForm {
	
	/*
	 * Instansvariabler
	 */
	private int x, y, width, height;
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
		super(x, y, width, height, c);
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
		super(f, width, height, c);
	}
	
	/**
	 * Get the area of this rectangle as rounded to the closest integer.
	 * 
	 * @return - The area of the rectangle as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return height*width;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	/**
	 * Get the perimeter for this rectangle
	 * 
	 * @return - the perimeter of this rectangle
	 */
	@Override
	public int getPerimeter() {
		return this.height*2 + this.width*2;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}//end Rectangle