package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A graphical representation of a line.
 * 
 * @author Tobias Alld�n
 * @author Jonathan Helsing
 */
public class Line implements GeometricalForm{
	//Instance Variables
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Slope slope;	
	private Color color;
	//An enum representing the slope of the line
	public enum Slope {
		UPWARDS(),
		DOWNWARDS();
	}
	
	
	
	
	/** 
	 * Creates a Line.
	 * 
	 * @param x1 First x-coordinate
	 * @param y1 First y-coordinate
	 * @param x2 Second x-coordinate
	 * @param y2 Second y-coordinate
	 * @param c The Color of the line
	 * @throws IllegalPositionException
	 * 
	 * 	
	 */
	public Line(int x1, int y1, int x2, int y2, Color c) throws IllegalPositionException {
	}
	
	
	/**
	 * 
	 * @param f1 - GeometricalForm
	 * @param f2 - GeometricalForm
	 * @param c
	 *  Creates a line using two other GeometricalForms
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		
		
	   }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
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
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
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
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 * Returns the slope of the line
	 * @return slope
	 */
	public Slope getSlope() {
		return this.slope;
	}
	
	
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
