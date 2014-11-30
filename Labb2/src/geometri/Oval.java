package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a oval with methods adapted to oval's
 * from the AbstractGeometricalForm class.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.5
 *
 */
public class Oval extends AbstractGeometricalForm {
	
	
	/**
	 * Constructs a new Oval object.
	 * 
	 * @param x The position of the oval's top left corner on the x-axis
	 * @param y The position of the oval's top left corner on the y-axis
	 * @param diameter The diameter for the oval
	 * @param c The colour of the oval
	 * @throws IllegalPositionException Thrown if the x- and y-coordinates is less than 0 (Illegal)
	 */
	public Oval(int x, int y, int width, int height, Color c) throws IllegalPositionException {
		super(x, y, width, height, c);
	}
	
	/**
	 * Constructs a new Oval object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new oval object
	 * @param diameter The diameter of the oval
	 * @param c The colour of the oval
	 */
	public Oval(GeometricalForm f, int width, int height, Color c) {
		super(f, width, height, c);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Get the area of this oval as rounded to the closest integer.
	 * 
	 * @return - The area of this oval as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return (int) (Math.PI*(getWidth()/2)*(getHeight()/2));
	}
	
	/**
	 * Get the perimeter for this oval
	 * 
	 * @return - the perimeter of this oval
	 */
	@Override
	public int getPerimeter() {
		return (int) (Math.PI*(getHeight() + getWidth()));
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int hashCode() {
		return 0;
	}

}//end Oval