package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class describes a oval with methods adapted to oval's
 * from the GeometricalForm interface.
 * 
 * @author Tobias Alldén
 * @author Jonathan Helsing
 * @version 1.0
 *
 */
public class Oval implements GeometricalForm {
	
	/*
	 * Instansvariabler
	 */
	private int x, y, width, height;
	private Color color;
	
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
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to construct a new Oval " + 
					"with negative x and/or y coordinates");
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = c;
	}
	
	/**
	 * Constructs a new Oval object.
	 * 
	 * @param f a GeometricalForm that contains the x and y coordinates for the new oval object
	 * @param diameter The diameter of the oval
	 * @param c The colour of the oval
	 */
	public Oval(GeometricalForm f, int width, int height, Color c) {
		x = f.getX();
		y = f.getY();
		this.width = width;
		this.height = height;
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
		g.fillOval(this.x, this.y, this.width, this.height);
	}
	
	/**
	 * Get the colour of this oval
	 * 
	 * @return - The colour of this oval
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Get the area of this oval as rounded to the closest integer.
	 * 
	 * @return - The area of this oval as rounded to the closest integer.
	 */
	@Override
	public int getArea() {
		return (int) (Math.PI*(this.width/2)*(this.height/2));
	}
	
	/**
	 * Get the height of this oval.
	 * 
	 * @return - The height of this oval
	 */
	@Override
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Get the perimeter for this oval
	 * 
	 * @return - the perimeter of this oval
	 */
	@Override
	public int getPerimeter() {
		return (int) (Math.PI*(this.height + this.width));
	}
	
	/**
	 * Get the width of this oval.
	 * 
	 * @return - The width of this oval
	 */
	@Override
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Get the x coordinate for this oval's top left corner
	 * 
	 * @return - the x coordinate for this oval's top left corner
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the y coordinate for this oval's top left corner
	 * 
	 * @return - the y coordinate for this oval's top left corner
	 */
	@Override
	public int getY() {
		return this.y;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void move(int dx, int dy) throws IllegalPositionException {
		if((x + dx) <= 0 || (y + dy) <= 0) {
			throw new IllegalPositionException("Tried to move a oval to " +
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
		if(x <= 0 || y <= 0) {
			throw new IllegalPositionException("Tried to place a oval at an illegal position");
		}
		this.x = x;
		this.y = y;
	}//end place

}//end Oval