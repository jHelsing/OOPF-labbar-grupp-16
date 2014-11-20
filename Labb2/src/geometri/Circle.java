package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a circle with methods adapted to circles
 * from the GeometricalForm interface.
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * @version 1.0
 */

public class Circle implements GeometricalForm {
	
	/*
	 * Instansvariabler
	 */
	private int x, y, diameter;
	private Color color;
	
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
		if(x<=0 || y<=0) {
			throw new IllegalPositionException("Tried to construct a new Circle " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = c;
	}
	
	/**
	 * Constructs a new Circle object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new circle object
	 * @param diameter The diameter of the circle
	 * @param c The colour of the circle
	 */
	public Circle(GeometricalForm f, int diameter, Color c) {
		x = f.getX();
		y = f.getY();
		this.diameter = diameter;
		color = c;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm o) {
		if(this.getArea()<o.getArea()) {
			return -1;
		}
		if(this.getArea()>o.getArea()) {
			return 1;
		}
		return 0;
	}//end compareTo
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.fillOval(this.x, this.y, this.diameter, this.diameter);
	}
	
	/**
	 * Get the colour of this circle
	 * 
	 * @return - The colour of this circle
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Get the area of this circle as rounded to the closest integer.
	 * 
	 * @return - The area of the circle as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return (int) (Math.PI*Math.pow(diameter/2, 2));
	}
	
	/**
	 * Get the height of this circle.
	 * 
	 * @return - The height of this circle
	 */
	@Override
	public int getHeight() {
		return this.diameter;
	}
	
	/**
	 * Get the perimeter for this circle
	 * 
	 * @return - the perimeter of this circle
	 */
	@Override
	public int getPerimeter() {
		return (int) (Math.PI*this.diameter);
	}
	
	/**
	 * Get the width of this Circle.
	 * 
	 * @return - The width of this circle
	 */
	@Override
	public int getWidth() {
		return this.diameter;
	}
	
	/**
	 * Get the x coordinate for this circle's top left corner
	 * 
	 * @return - the x coordinate for this circle's top left corner
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the y coordinate for this circle's top left corner
	 * 
	 * @return - the y coordinate for this circle's top left corner
	 */
	@Override
	public int getY() {
		return this.y;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		if((x + dx) <= 0 || (y + dy) <= 0) {
			throw new IllegalPositionException("Tried to move a circle to " +
					"an illegal position");
		}
		x = x+dx;
		y = y+dy;
	}//end move

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x<=0 || y<=0) {
			throw new IllegalPositionException("Tried to place a cricle on " +
					"an illegal position");
		}
		this.x = x;
		this.y = y;
	}//end place

}//end Circle