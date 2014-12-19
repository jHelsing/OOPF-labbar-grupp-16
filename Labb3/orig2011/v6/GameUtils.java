package orig2011.v6;

/**
 * A helper class for GameModel.
 * 
 * @author Tobias Allden
 * @author Jonathan Helsing
 * @version 1.0
 */

public class GameUtils {
	
	/**
	 * A set method for the state of the game board.
	 * @param pos The Position of the tile to change.
	 * @param board The board it should be set in.
	 * @param tile The tile to change the position into.
	 */
	public static void setGameboardState(final Position pos, final GameTile[][] board, final GameTile tile) {
		setGameboardState(pos.getX(), pos.getY(), board,  tile);
	}
	
	/**
	 * A set method for the state of the game board.
	 * @param x The X-coordinate of the tile to change.
	 * @param y The Y-coordinate for the tile to change.
	 * @param board The board in which the tile is to be changed
	 * @param tile The tile to change the position into.
	 */
	public static void setGameboardState(final int x, final int y,
			final GameTile[][] board, GameTile tile) {
		board[x][y] = tile;
	}
	
}
