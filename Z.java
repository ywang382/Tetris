package model;

import java.util.ArrayList;

/**
 * 
 * 	Piece: Z
 *  Orientation:  
 *      up       left     down     right
 *     _____ 	 _____	   _____	_____
 *  0 |     |  0|   * |  0|     |  |   * | 
 *  1 | **  |  1|  ** |  1| **  |  |  ** |
 *  2 |  ** |  2|  *  |  2|  ** |  |  *  |
 *  3 |_____|  3|_____|  3|_____|  |_____|
 *	   01234     01234     01234    01234
 */

public class Z extends Tetromino{
	/**
	 * Constructor. You may want to modify
	 * @param game used in the call to super constructor
	 */
	public Z(Game game) {
		super(game, "Z", Cell.RED);
		length = 3;
		height = 2;
		
		// only 2 different layouts for all orientations
		ArrayList<Coordinate> layout1 = new ArrayList<Coordinate>();
		ArrayList<Coordinate> layout2 = new ArrayList<Coordinate>();
		
		layout1.add(new Coordinate(0, 0));
		layout1.add(new Coordinate(0, -1));
		layout1.add(new Coordinate(1, 0));
		layout1.add(new Coordinate(1, 1));
		
		layout2.add(new Coordinate(0, 0));
		layout2.add(new Coordinate(0, 1));
		layout2.add(new Coordinate(1, 0));
		layout2.add(new Coordinate(-1, 1));
		
		layout[0] = layout1;
		layout[1] = layout2;
		layout[2] = layout1;
		layout[3] = layout2;

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
