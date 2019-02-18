package model;
/**
Piece: I
*  Orientation:  
*        up       left      down      right       up again
*      	_____  	  _____	    _____     _____        _____
*     0|   * |  0|     |  0|  *  |  0|     | ->  0| *   |
*     1|   * |  1| ****|  1|  *  |  1|**** | ->  1| *   |
*     2|   * |  2|     |  2|  *  |  2|     | ->  2| *   |
*     3|   * |  3|     |  3|  *  |  3|     | ->  3| *   |
*     4|_____|  4|_____|  4|_____|  4|_____| ->  4|_____|
*     	01234     01234	    01234	  01234		   01234
*     
*     Notice this means that as you keep rotating it 
*     will automatically move left
*/

import java.util.ArrayList;

public class I extends Tetromino {
	/**
	 * Constructor. You may want to modify
	 * @param game used in the call to super constructor
	 */
	public I(Game game) {
		super(game, "I", Cell.CYAN);
		length = 1;
		height = 4;
		orientation = 0;
		
		layout[0] = new ArrayList<Coordinate>();
		layout[0].add(new Coordinate(0, 0));
		layout[0].add(new Coordinate(1, 0));
		layout[0].add(new Coordinate(2, 0));
		layout[0].add(new Coordinate(3, 0));
		layout[1] = new ArrayList<Coordinate>();
		layout[1].add(new Coordinate(0, 0));
		layout[1].add(new Coordinate(0, 1));
		layout[1].add(new Coordinate(0, 2));
		layout[1].add(new Coordinate(0, 3));
		layout[2] = new ArrayList<Coordinate>();
		layout[2].add(new Coordinate(0, 0));
		layout[2].add(new Coordinate(1, 0));
		layout[2].add(new Coordinate(2, 0));
		layout[2].add(new Coordinate(3, 0));
		layout[3] = new ArrayList<Coordinate>();
		layout[3].add(new Coordinate(0, 0));
		layout[3].add(new Coordinate(0, 1));
		layout[3].add(new Coordinate(0, 2));
		layout[3].add(new Coordinate(0, 3));
		
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
		if (orientation == 1 || orientation == 3) {
			if (!setOrigin(getOrigin().translate(1, -2))) {
				orientation--; 
				return false;
			}
		}
		else if (orientation == 0 || orientation == 2) {
			if (!setOrigin(getOrigin().translate(-1, 1))) {
				orientation--; 
				return false;
			}
		}
		return true;
	}
}
