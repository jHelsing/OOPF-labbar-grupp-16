package lab1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

/**
 * A simple "Snake"-Game.
 * 
 * <p>
 * 
 * An apple is placed on the board, the objective is to steer the snake into "consuming" the apple
 * if the apple is consumed, the snake will become one joint longer, and another apple will be placed
 * on a random location within the board. If the snake "crawls" into the border or itself, its game over.
 */
public class SnakeModel extends GameModel {
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}

	/*
	 * The following GameTile objects are used only
	 * to describe how to paint the specified item.
	 * 
	 * This means that they should only be used in
	 * conjunction with the get/setGameboardState()
	 * methods.
	 */

	/** Graphical representation of a red apple. */
	private static final GameTile APPLE_TILE = new RoundTile(new Color(255, 215,
			0),
			new Color(255, 0, 0), 2.0);

	/** Graphical representation of the snake */
	private static final GameTile SNAKE_TILE = new RectangularTile(Color.BLACK);

	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();

	/** The position of the apple */
	private Position appleLocation;
	/*
	 * The declaration and object creation above uses the new language feature
	 * 'generic types'. It can be declared in the old way like this:
	 * private java.util.List coins = new ArrayList();
	 * This will however result in a warning at compilation
	 * "Position" in this case is the type of the objects that are going
	 * to be used in the List
	 */

	/** Length of the snake */

	private int snakeLength;

	/** A list of the snake's positions in the board. */
	private ArrayList<Position> SnakePos = new ArrayList<Position>();

	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;

	/** Number of apples eaten */
	private int score;


	/**
	 * Constructor, create a new SnakeModel-game. 
	 */
	public SnakeModel() {
		snakeLength = 3;
		Dimension size = getGameboardSize();

		// Blank out the whole gameboard
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Insert the snake in the middle of the gameboard.
		for(int i = 0; i < snakeLength; i++) {
			this.SnakePos.add(new Position(size.width / 2, (size.height / 2) + i ));
			setGameboardState(this.SnakePos.get(i), SNAKE_TILE);
		}

		//Insert the first apple to the gameboard.
		addApple();
	}

	/**
	 * Insert an apple at a random location
	 */
	private void addApple() {
		Position newApplePos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newApplePos = new Position((int) (Math.random() * size.width),
					(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newApplePos));

		// ... add an apple to the empty tile.
		setGameboardState(newApplePos, APPLE_TILE);
		this.appleLocation = newApplePos;
	}

	/**
	 * Return whether the specified position is empty or a snake-tile.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}

	/**
	 * Update the direction of the collector
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
		case KeyEvent.VK_LEFT:
			this.direction = Directions.WEST;
			break;
		case KeyEvent.VK_UP:
			this.direction = Directions.NORTH;
			break;
		case KeyEvent.VK_RIGHT:
			this.direction = Directions.EAST;
			break;
		case KeyEvent.VK_DOWN:
			this.direction = Directions.SOUTH;
			break;
		default:
			// Don't change direction if another key is pressed
			break;
		}
	}

	/**
	 * Get next position of the snake.
	 */	
	private Position getNextSnakePos() {
		return new Position(
				SnakePos.get(0).getX() + direction.getXDelta(),
				SnakePos.get(0).getY() + direction.getYDelta());



	}



	/**
	 * This method is called repeatedly so that the
	 * game can update its state.
	 * 
	 * @param lastKey
	 *            The most recent keystroke.
	 */
	@Override
	public void gameUpdate(final int lastKey) throws GameOverException {
		updateDirection(lastKey);

		// Erase the previous position.
		setGameboardState(this.SnakePos.get(snakeLength-1), BLANK_TILE);
		// Change snake position.
		SnakePos.add(0, getNextSnakePos());

		if (isOutOfBounds(this.SnakePos.get(0))) {
			throw new GameOverException(this.score);
		}
		if (isSnakeTile(getNextSnakePos())) {
			throw new GameOverException(this.score);
		}

		// If the snakes head is at the same location as the apple, 
		// the snake consumes the apple, becomes one joint longer and another apple is placed on the board.
		if (this.SnakePos.get(0).equals(this.appleLocation)) {
			this.score++;
			Position oldCoinPos = this.appleLocation;
			setGameboardState(oldCoinPos, BLANK_TILE);
			snakeLength++;
			addApple();
		}
		// Draw the snake on the gameboard
		for(int i = 0; i<snakeLength; i++) {
			setGameboardState(this.SnakePos.get(i), SNAKE_TILE);
		}

		// TODO add win-clause
		if (this.score == 40) {
			throw new GameOverException(this.score + 5);
		}


	}


	/**
	 * 
	 * @param pos The position to test.
	 *@return <code>True</code> if the position is a snake tile, <code>false</code> otherwise.
	 */
	private boolean isSnakeTile(Position pos) {
		if(isOutOfBounds(pos)) { 
			return false;
		}
		else {
			return(getGameboardState(pos.getX(), pos.getY()) == SNAKE_TILE);
		}
	}

	/**
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
	}

}
