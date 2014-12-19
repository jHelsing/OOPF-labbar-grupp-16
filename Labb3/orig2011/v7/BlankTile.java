package orig2011.v6;

import java.awt.Dimension;
import java.awt.Graphics;

/**
 * A graphical representation of a blank tile.
 * @author Tobias Alld?n
 * @author Jonathan Helsing
 *
 */
public class BlankTile implements GameTile{

	@Override
	public void draw(Graphics g, int x, int y, Dimension d) {
		// Nothing will be drawn,since tile is blank.
		
	}

	
	
}
