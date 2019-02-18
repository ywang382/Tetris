package model;

import java.util.ArrayList;
/**
 * 
 * 	Piece: T
 *  Orientation:  
 *        up       left      down      right
 *       _____	   _____	 _____     _____
 *     0|     |  0|  *  |  0|  *  |  0|  *  |
 *     1| *** |  1|  ** |  1| *** |  1| **  |
 *     2|  *  |  2|  *  |  2|     |  2|  *  |
 *     3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */
public class T extends Tetromino {
	public T(Game game) {
		/**
		 * Constructor. You may want to modify
		 * @param game used in the call to super constructor
		 */
		super(game, "T", Cell.PURPLE);
		length = 3;
		height = 2;
		orientation = 0;
		
		layout[0] = new ArrayList<Coordinate>();
		layout[0].add(new Coordinate(0, 0));
		layout[0].add(new Coordinate(0, -1));
		layout[0].add(new Coordinate(0, 1));
		layout[0].add(new Coordinate(1, 0));
		layout[1] = new ArrayList<Coordinate>();
		layout[1].add(new Coordinate(0, 0));
		layout[1].add(new Coordinate(1, 0));
		layout[1].add(new Coordinate(-1, 0));
		layout[1].add(new Coordinate(0, 1));
		layout[2] = new ArrayList<Coordinate>();
		layout[2].add(new Coordinate(0, 0));
		layout[2].add(new Coordinate(0, -1));
		layout[2].add(new Coordinate(0, 1));
		layout[2].add(new Coordinate(-1, 0));
		layout[3] = new ArrayList<Coordinate>();
		layout[3].add(new Coordinate(0, 0));
		layout[3].add(new Coordinate(1, 0));
		layout[3].add(new Coordinate(-1, 0));
		layout[3].add(new Coordinate(0, -1));		
		
	}

	/**
	 * rotates the piece counter-clockwise. See above orientation
	 * for reference on which tile to rotate around. 
	 */
	@Override
	public boolean rotate() {
		// set new orientation
		orientation++;
		orientation %= 4;
		
		if (!setOrigin(getOrigin())) {
			orientation--; 
			return false;
		}
		
		return true;
	}
}
