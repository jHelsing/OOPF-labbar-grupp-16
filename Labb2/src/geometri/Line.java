package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A graphical representation of a line.
 * 
 * @author Tobias Alldén
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
		super(Math.min(x1, x2),Math.max(x1, x2),Math.abs(x2-x1),Math.abs((y2-y1)),c);
		if(x1<0 || y1<0 || x2 < 0 || y2<0 ) {
			throw new IllegalPositionException("Both values should be greater than zero");
		}
		if(x1 < x2) {
			if(y2 < y1) {
				this.slope = Slope.UPWARDS; 
			} else {
				this.slope = Slope.DOWNWARDS;
			}
			super.place(x1, y1);
		} else {
			if(y1 < y2) {
				this.slope = Slope.UPWARDS; 
			} else {
				this.slope = Slope.DOWNWARDS;
			}
			super.place(x2, y2);
		}
	}//end constructor	
	
	/**
	 * 
	 * @param f1 - GeometricalForm
	 * @param f2 - GeometricalForm
	 * @param c
	 *  Creates a line using two other GeometricalForms
	 */
	public Line(GeometricalForm f1, GeometricalForm f2, Color c) {
		super(f1,f2.getX() - f1.getX(),f2.getY()-f1.getY(),c);
		if(f2.getX()>f1.getX()) {
			GeometricalForm tmp = f1;
			f1 = f2;
			f2 = tmp;
		}
		if(f2.getY() > f1.getY()) {
			this.slope = Slope.DOWNWARDS;
		} else {
			this.slope = Slope.UPWARDS;
		}
		if(this.slope == Slope.DOWNWARDS) {
			try {
				super.place(f1.getX(), f1.getY());
			} catch (IllegalPositionException e) {
				e.printStackTrace();
			}
		} else {
			try {
				super.place(f2.getX(), f2.getY());
			} catch (IllegalPositionException e) {
				e.printStackTrace();
			}
			super.width = f2.getX() - f1.getX();
			super.height = f1.getHeight() - f2.getHeight();
		}
	}//end Constructor
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(this.getColor());
		if(this.slope == Slope.DOWNWARDS) {
			g.drawLine(super.getX(), super.getY(), super.getX()+getWidth(), super.getY()+super.getHeight());
		}
		else {
			g.drawLine(super.getX(), super.getY()+getHeight(), super.getX()+getWidth(), super.getY());
		}
	}//end fill
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getArea() {
		return 0;
	}//end getArea
	
	/**
	 * {@inheritDoc}
	 */
	public int getPerimeter() {
		double tmpX;//Temporary variable for difference of the x - coordinates
		double tmpY; //Temporary variable for difference of the y- coordinates
		tmpX = (this.getX() - (super.getX()+this.getWidth()));
		tmpY = (this.getY() - (super.getY() +this.getHeight()));
		return (int)Math.sqrt((Math.pow(tmpX, 2) + Math.pow(tmpY, 2)));
	}//end getPerimeter 
	
	/**
	 * 
	 * Returns the slope of the line
	 * @return slope
	 */
	public Slope getSlope() {
		return this.slope;
	}//end getSlope
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((slope == null) ? 0 : slope.hashCode());
		return result;
	}//end HashCode
	
	/**
	 * {@inheritDoc}
	 * Also compares the slope and the peremeter of the line.
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;			
		} 
		if(!super.equals(o)) {
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		Line tmp = (Line)o;
		if(tmp.getSlope() != this.slope) {
			return false;
		}
		if(tmp.compareTo(this) != 0) {
			return false;
		}
		return true;
	}//end equals
	
}//end Line
