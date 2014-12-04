package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A graphical representation of a line.
 * 
 * @author Tobias Alld�n
 * @author Jonathan Helsing
 */
public class Line extends AbstractGeometricalForm{
	//Instance Variables
	private Slope slope;
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
		super(x1,y1,(x2-x1),(y2-y1),c);
		if(y2 > y1) {
			this.slope = Slope.UPWARDS; 
		} else {
			this.slope = Slope.DOWNWARDS;
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
		super(f1,(f2.getX() - f1.getX()),(f2.getY()-f1.getY()),c);
		if(f2.getY() > f1.getY()) {
			this.slope = Slope.UPWARDS;
		} else {
			this.slope = Slope.UPWARDS;
		}
		
	   }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(this.getColor());
		if(this.slope == Slope.UPWARDS) {
			g.drawLine(this.getX(), this.getY(), this.getX()+getWidth(), this.getY()-this.getHeight());
		}
		else if (this.slope == Slope.DOWNWARDS) {
			g.drawLine(this.getX(), this.getY(), this.getX()+getWidth(), this.getY()+this.getHeight());
		}
		
		
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
			if (this.equals(o)) {
				return 0;
			} else if(this.getPerimeter()< tmp.getPerimeter() && this.getSlope() != tmp.getSlope()) {
				return -1;
			}
			else if(this.getPerimeter() > tmp.getPerimeter() && this.getSlope() != tmp.getSlope()) {
				return 1;
			}
			else{
				return 0;
			}
		} else {
			return -1;
		}
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
	public int getPerimeter() {
		double tmpX;//Temporary variable for difference of the x - coordinates
		double tmpY; //Temporary variable for difference of the y- coordinates
		if(this.slope == Slope.DOWNWARDS) {
			tmpX = (this.getX() + this.getWidth());
			tmpY = (this.getY() + this.getHeight());
		} else {
			tmpX = (this.getX() + this.getWidth());
			tmpY = (this.getY() - this.getHeight());			
		}
		return (int)Math.sqrt((Math.pow(tmpX, 2) + Math.pow(tmpY, 2)));
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
		super.move(dx, dy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		super.place(x, y);
		
	}

/**
 * {@inheritDoc}
 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((slope == null) ? 0 : slope.hashCode());
		return result;
	}


	/**
	 * {@inheritDoc}
	 * Also compares the slope and the peremeter of the line.
	 */
	@Override
	public boolean equals(Object o) {
		if(super.equals(o) && o instanceof Line) {
			if(((Line) o).getPerimeter() == this.getPerimeter() && this.getSlope() == ((Line) o).getSlope() ) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


	
	
	
}
