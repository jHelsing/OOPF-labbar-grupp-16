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
	
	/**
	 * the x-coordinate of the point
	 */
	private int x;
	
	/**
	 * The y-coordinate of the point
	 */
	private int y;
	
	/**
	 * The colour of the point
	 */
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
		
	}
	
	/**
	 * Constructs a new Point object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new point object
	 * @param c The colour of the point
	 */
	public Point(GeometricalForm f, Color c) {
		
	}
	
	/**
	 * Get the area of this point as rounded to the closest integer.
	 * 
	 * @return - The area of this point as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		// TODO Auto-generated method stub
		return 0;
	}//end compareTo
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get the colour of this point
	 * 
	 * @return - The colour of this point
	 */
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Get the width of this point.
	 * 
	 * @return - The width of this point
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Get the height of this point.
	 * 
	 * @return - The height of this point
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Get the x coordinate for this point's top left corner
	 * 
	 * @return - the x coordinate for this point's top left corner
	 */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Get the y coordinate for this point's top left corner
	 * 
	 * @return - the y coordinate for this point's top left corner
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}//end move
	
	/**
	 * Get the perimeter for this point
	 * 
	 * @return - the perimeter of this point
	 */
	@Override
	public int getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}//end move

}//end point