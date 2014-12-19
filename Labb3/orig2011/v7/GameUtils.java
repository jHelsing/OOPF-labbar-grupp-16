package orig2011.v6;

public class GameUtils {
	
	public static void setGameboardState(final Position pos, final GameTile[][] board, final GameTile tile) {
		setGameboardState(pos.getX(), pos.getY(), board,  tile);
	}
	
	public static void setGameboardState(final int x, final int y,
			final GameTile[][] board, GameTile tile) {
		board[x][y] = tile;
	}
	
}
