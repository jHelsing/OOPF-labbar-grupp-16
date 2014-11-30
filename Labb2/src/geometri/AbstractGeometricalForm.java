package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This is the abstract class for all GeometricalForms. It contains the
 * methods that the different subclasses have in-common.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.0
 *
 */
public abstract class AbstractGeometricalForm implements GeometricalForm {
	
	private int x, y, width, height;
	private Color c;
	
	/**
	 * A constructor for a new AbstractGeometricalForm instance
	 * 
	 * @param x The X-coordinate for the object
	 * @param y The Y-coordinate for the object
	 * @param width The width of the object
	 * @param height The height of the object
	 * @param c The colour of the object
	 * @throws IllegalPositionException Thrown if the x- and/or y-coordinate
	 * is less than or equals to 0
	 */
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
	
	/**
	 * A constructor for a new AbstractGeometricalForm instance
	 * @param f A GeometricalForm that contains the x-
	 *  and y coordinates for the new rectangle object.
	 * @param width The width of the object
	 * @param height The height of the object
	 * @param c The colour of the object
	 */
	public AbstractGeometricalForm(GeometricalForm f, int width, int height, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	/**
	 * Getter for the area of the form.
	 * @return The forms area
	 */
	@Override
	public abstract int getArea();
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public abstract void fill(Graphics g);
	
	/**
	 * Getter for the colour of the form.
	 * @return The colour of the form
	 */
	@Override
	public Color getColor() {
		return c;
	}
	
	/**
	 * Getter for the width of the form.
	 * @return The width of the form.
	 */
	@Override
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter for the height of the form.
	 * @return The height of the form
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	/**
	 * Getter for the x-coordinate of the form.
	 * @return The x-coordinate for the form
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for the y-coordinate of the form.
	 * @return The y-coordinate of the form
	 */
	@Override
	public int getY() {
		return y;
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Getter for the perimeter of the form.
	 * @return The perimeter of the form
	 */
	@Override
	public abstract int getPerimeter();
	
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
	}
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public abstract int hashCode();
	
	/**
	 * {@inheirtDoc}
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

}
