package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a point with methods adapted to point's
 * from the AbstractGeometricalForm class.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.5
 */
public class Point extends AbstractGeometricalForm {
	
	/**
	 * Constructs a new Point object.
	 * 
	 * @param x The x-coordinate for the point
	 * @param y The y-coordinate for the point
	 * @param c The colour of the point
	 * @throws IllegalPositionException Thrown if the x- and y-coordinates is less than 0 (Illegal)
	 */
	public Point(int x, int y, Color c) throws IllegalPositionException {
		super(x, y, 0, 0, c);
	}
	
	/**
	 * Constructs a new Point object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new point object
	 * @param c The colour of the point
	 */
	public Point(GeometricalForm f, Color c) {
		super(f, 0, 0, c);
	}
	
	/**
	 * Get the area of this point as rounded to the closest integer.
	 * 
	 * @return - The area of this point as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), 2, 2);
	}
	
	/**
	 * Get the perimeter for this point
	 * 
	 * @return - the perimeter of this point
	 */
	@Override
	public int getPerimeter() {
		return 0;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	public int hashCode() {
		final int prime = 17;
		int res = 1;
		res = prime * res + ((this.getColor() == null) ? 0 : this.getColor().hashCode());
		res = prime * res + this.getHeight();
		res = prime * res + this.getWidth();
		return res;
	}

}//end point