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
		if((x1 < 0 || x2 <0) || (y1 <0 || y2<0)  ) {
			throw new IllegalPositionException();
		}
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = c;	
		if(this.y1 < this.y2) {
			this.slope = Slope.DOWNWARDS;
		} else {
			this.slope = Slope.UPWARDS;
		}
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
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm o) {
		if(o == this) {
			return 0;
		}
		if(o == null) {
			return -1;	
		}
		if(o instanceof Line) {
			Line tmp = (Line)o;
			if (tmp.getX() == this.getX() && this.getY() == tmp.getY() 
					&& this.getPerimeter() == tmp.getPerimeter() && this.getSlope() == tmp.getSlope()) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return this.color;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHeight() {
		if(y1 < y2) {
			return this.y2 - this.y1;
		} else {
			return this. y1 - this.y2; 			
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPerimeter() {
		double tmpX;//Temporary variable for difference of the x - coordinates
		double tmpY; //Temporary variable for difference of the y- coordinates
		if(this.x1 < this.x2) {
			tmpX = Math.pow((x2-x1),2); 
		} else {
			tmpX = Math.pow(this.x2 - this.x1,2);
		}
		if(y1 < y2) {
			tmpY = Math.pow(y2-y1,2);
		} else {
			tmpY = Math.pow(y1-y2,2);
		}		
		//return the diagonal line
		return (int)Math.sqrt(tmpY+tmpX);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWidth() {
		double tmpPeremeter = Math.pow(this.getPerimeter(),2);
		double tmpHeight = Math.pow(this.getHeight(),2);
		return (int)Math.sqrt(tmpPeremeter-tmpHeight);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		return this.x1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getY() {
		return this.y1;
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
		if(this.x1 + dx < 0 || this.x2 + dx <0 
				|| this.y1 + dy <0 || this.y2 +dy <0) {
			throw new IllegalPositionException();
		}		
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		if((x1 < 0 || y <0)) {
			throw new IllegalPositionException();
		}
		this.x2 = x1 + x;
		this.x1 = x;
		this.y2 = y1 + y;
		this.y1 = y;
		
	}

	
	
	
}
