package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a rectangle with methods adapted to rectangles
 * from the AbstractGeometricalForm class.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.5
 *
 */

public class Rectangle extends AbstractGeometricalForm {
	
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
		super.place(x, y);
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
	 * {@inheirtDoc}
	 */
	@Override
	public int getArea() {
		return getHeight()*getWidth();
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * A getter for the perimeter for a rectangle
	 * @return The perimeter of this rectangle
	 */
	@Override
	public int getPerimeter() {
		return 2*getWidth() + 2*getHeight();
	}
	
	/**
	 * {@ineheirtDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 29;
		int res = 1;
		res = prime * res + ((this.getColor() == null) ? 0 : this.getColor().hashCode());
		res = prime * res + this.getHeight();
		res = prime * res + this.getWidth();
		return res;
	}

}//end Rectangle