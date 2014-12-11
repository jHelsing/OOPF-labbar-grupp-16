package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a circle with methods adapted to circles
 * from the AbstractGeometricalForm class.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.5
 */

public class Circle extends AbstractGeometricalForm {
	
	/**
	 * Constructs a new Circle object.
	 * 
	 * @param x The position of the circle's top left corner on the x-axis
	 * @param y The position of the circle's top left corner on the y-axis
	 * @param diameter The diameter for the circle
	 * @param c The colour of the circle
	 * @throws IllegalPositionException Thrown if the x and y coordinates is less than 0 (Illegal)
	 */
	public Circle(int x, int y, int diameter, Color c) throws IllegalPositionException {
		super(x, y, diameter, diameter, c);
	}
	
	/**
	 * Constructs a new Circle object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new circle object
	 * @param diameter The diameter of the circle
	 * @param c The colour of the circle
	 */
	public Circle(GeometricalForm f, int diameter, Color c) {
		super(f, diameter, diameter, c);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Get the area of this circle as rounded to the closest integer.
	 * 
	 * @return - The area of the circle as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return (int) (Math.PI*Math.pow(getWidth()/2, 2));
	}
	
	/**
	 * Get the perimeter for this circle
	 * 
	 * @return - the perimeter of this circle
	 */
	@Override
	public int getPerimeter() {
		return (int) (Math.PI*getWidth());
	}
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 11;
		int res = 1;
		res = prime * res + ((this.getColor() == null) ? 0 : this.getColor().hashCode());
		res = prime * res + this.getHeight();
		res = prime * res + this.getWidth();
		return res;
	}

}//end Circle