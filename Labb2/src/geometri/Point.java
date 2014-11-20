package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a point with methods adapted to point's
 * from the GeometricalForm interface.
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * @version 1.0
 */
public class Point implements GeometricalForm {
	
	/*
	 * Instansvariabler
	 */
	private int x,y;
	private Color color;
	
	/**
	 * Constructs a new Point object.
	 * 
	 * @param x The x-coordinate for the point
	 * @param y The y-coordinate for the point
	 * @param c The colour of the point
	 * @throws IllegalPositionException Thrown if the x- and y-coordinates is less than 0 (Illegal)
	 */
	public Point(int x, int y, Color c) throws IllegalPositionException {
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to construct a new point at "
					+ "an illegal position");
		}
		this.x = x;
		this.y = y;
		color = c;
	}
	
	/**
	 * Constructs a new Point object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new point object
	 * @param c The colour of the point
	 */
	public Point(GeometricalForm f, Color c) {
		this.x = f.getX();
		this.y = f.getY();
		color = c;
	}
	
	/**
	 * Get the area of this point as rounded to the closest integer.
	 * 
	 * @return - The area of this point as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		//TODO Point Area
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		// TODO Point compareTo
		return 0;
	}//end compareTo
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		// TODO Point fill
		
	}
	
	/**
	 * Get the colour of this point
	 * 
	 * @return - The colour of this point
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Get the width of this point.
	 * 
	 * @return - The width of this point
	 */
	@Override
	public int getWidth() {
		// TODO Point width
		return 0;
	}
	
	/**
	 * Get the height of this point.
	 * 
	 * @return - The height of this point
	 */
	@Override
	public int getHeight() {
		// TODO Point height
		return 0;
	}
	
	/**
	 * Get the x coordinate for this point's top left corner
	 * 
	 * @return - the x coordinate for this point's top left corner
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the y coordinate for this point's top left corner
	 * 
	 * @return - the y coordinate for this point's top left corner
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
			throw new IllegalPositionException("Tried to move a point to " +
					"an illegal position");
		}
		x = x+dx;
		y = y+dy;
	}//end move
	
	/**
	 * Get the perimeter for this point
	 * 
	 * @return - the perimeter of this point
	 */
	@Override
	public int getPerimeter() {
		// TODO Point getPerimeter
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if(x<=0 || y<=0) {
			throw new IllegalPositionException("Tried to place a point on " +
					"an illegal position");
		}
		this.x = x;
		this.y = y;
	}//end move

}//end point