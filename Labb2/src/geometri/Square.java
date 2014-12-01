package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a square with methods adapted to squares
 * from the AbstractGeometricalForm class
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.5
 *
 */

public class Square extends AbstractGeometricalForm {
	
	
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
		super(x, y, side, side, c);
	}
	
	/**
	 * Constructs a new Square object.
	 * 
	 * @param f  A GeometricalForm that contains the x and y coordinates for the new rectangle object.
	 * @param side The length of each of the square's sides.
	 * @param c The colour of the square.
	 */
	public Square(GeometricalForm f, int side, Color c) {
		super(f, side, side, c);
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
	 * Get the perimeter for this square
	 * 
	 * @return - the perimeter of this square
	 */
	@Override
	public int getPerimeter() {
		return getWidth()*4;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int getArea() {
		return getWidth()*getHeight();
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int hashCode() {
		return 0;
	}
	
}//end Oval