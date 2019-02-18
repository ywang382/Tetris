package model;

/**
 * 
 * 	Piece: L
 *  Orientation:  
 *        up       left      down      right
 *       _____ 	   _____     _____ 	   _____
 *     0|  *  |  0|   * |  0|  ** |  0|     |
 *     1|  *  |  1| *** |  1|   * |  1|  ***| 
 *     2|  ** |  2|     |  2|   * |  2|  *  |
 *	   3|_____|  3|_____|  3|_____|  3|_____|
 *       01234     01234     01234     01234
 */

import java.util.ArrayList;

public class L extends Tetromino {

	public L(Game game) {
		/**
		 * Constructor. You may want to modify
		 * @param game used in the call to super constructor
		 */
		super(game, "L", Cell.ORANGE);
		length = 2;
		height = 3;
		orientation = 0;
		
		layout[0] = new ArrayList<Coordinate>();
		layout[0].add(new Coordinate(0, 0));
		layout[0].add(new Coordinate(1, 0));
		layout[0].add(new Coordinate(2, 0));
		layout[0].add(new Coordinate(2, 1));
		layout[1] = new ArrayList<Coordinate>();
		layout[1].add(new Coordinate(0, 0));
		layout[1].add(new Coordinate(0, 1));
		layout[1].add(new Coordinate(0, 2));
		layout[1].add(new Coordinate(-1, 2));
		layout[2] = new ArrayList<Coordinate>();
		layout[2].add(new Coordinate(0, 0));
		layout[2].add(new Coordinate(0, 1));
		layout[2].add(new Coordinate(1, 1));
		layout[2].add(new Coordinate(2, 1));
		layout[3] = new ArrayList<Coordinate>();
		layout[3].add(new Coordinate(0, 0));
		layout[3].add(new Coordinate(1, 0));
		layout[3].add(new Coordinate(0, 1));
		layout[3].add(new Coordinate(0, 2));
		
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
		if(orientation == 0) {
			if (!setOrigin(getOrigin().translate(-1, 0))) {
				orientation--; 
				return false;
			}
		}
		else if(orientation == 1) {
			if (!setOrigin(getOrigin().translate(1, -1))) {
				orientation--; 
				return false;
			}
		}
		else if(orientation == 2) {
			if (!setOrigin(getOrigin().translate(-1, 1))) {
				orientation--; 
				return false;
			}
		}
		else if(orientation == 3) {
			if (!setOrigin(getOrigin().translate(1, 0))) {
				orientation--; 
				return false;
			}
		}
		
		return true;
	}	
		
	
}