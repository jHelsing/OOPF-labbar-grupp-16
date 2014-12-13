package orig2011.v2;

import java.awt.Dimension;

import orig2011.v2.GameTile;
import orig2011.v2.Position;

public interface GameModel {
	
	public static class GameUtils {
		
		protected void setGameboardState(final Position pos, final GameTile tile) {
			setGameboardState(pos.getX(), pos.getY(), tile);
		}
		
		protected void setGameboardState(final int x, final int y,
				final GameTile tile) {
			//super.gameboardState[x][y] = tile;
		}
		
	}
	
	/**
	 * Returns the GameTile in logical position (x,y) of the gameboard.
	 * 
	 * @param pos
	 *            The position in the gameboard matrix.
	 */
	public GameTile getGameboardState(final Position pos);
	
	/**
	 * Returns the GameTile in logical position (x,y) of the gameboard.
	 * 
	 * @param x
	 *            Coordinate in the gameboard matrix.
	 * @param y
	 *            Coordinate in the gameboard matrix.
	 */
	public GameTile getGameboardState(final int x, final int y);
	
	/**
	 * Returns the size of the gameboard.
	 */
	public Dimension getGameboardSize();
	
	/**
	 * This method is called repeatedly so that the game can update it's state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	public void gameUpdate(int lastKey) throws GameOverException;
	
}
