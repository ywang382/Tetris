

package model;

import java.util.ArrayList;
/**
 *     
    Cyan I
    Yellow O
    Purple T
    Green S
    Red Z
    Blue J
    Orange L 
 *
 */
public abstract class Tetromino {
	protected final Cell cell;
	protected final String name;
	
	/**
	 * This list represents the most current coordinates of the
	 * Tetromino piece on the game board 
	 */
	protected ArrayList<Coordinate> locations;
	
	/**
	 * This is an array of ArrayLists where each ArrayList represents
	 * the layout of the Tetromino piece at a given orientation.
	 * Each ArrayList should be designed in such a way where if one
	 * cell of the piece were to be marked as the origin (0,0)
	 * the coordinates of the rest of the cells should maintain 
	 * the shape of the piece.
	 * Once initialized, the layout should NOT be altered
	 * Your initialization of layout up to you
	 * array index = orientation
	 */
	protected ArrayList<Coordinate> [] layout;
	
	protected Game game;
	public abstract boolean rotate();
	protected int orientation; // 0 up, 1 right, 2 down, 3 left
	protected int length;   // length of the piece when it is initially inserted
	protected int height;   // height of the piece when it is initially inserted
	
	
	@SuppressWarnings("unchecked")
	public Tetromino(Game game, String name, Cell cell) {
		this.name = name;
		this.cell = cell;
		locations = new ArrayList<>();
		this.game = game;
		layout = (ArrayList<Coordinate> [])(new ArrayList[4]);
		
	}
	
	public Cell getCell() { return cell;}
	
	
	
	/**
	 * This will move the piece down by one row. Otherwise known
	 * as a "soft drop." Not to be confused by the fall() method
	 * @return true if allowed, false otherwise
	 */
	public boolean moveDown() {
		return setOrigin(getOrigin().translate(1, 0));
	}
	
	/**
	 * This will move the piece to the left by one column
	 * @return true if allowed, false otherwise
	 */
	public boolean moveLeft() {
		return setOrigin(getOrigin().translate(0, -1));
	}
	
	/**
	 * This will move the piece to the right by one column
	 * @return true if allowed, false otherwise
	 */
	public boolean moveRight() {
		return setOrigin(getOrigin().translate(0, 1));
	}

	/**
	 * This will trigger a "hard drop." This means move the piece
	 * as far down as you are allowed to do so. Not to be confused
	 * with the moveDown() method. 
	 * @return true if allowed, false otherwise
	 */
	public boolean fall() {
		while(moveDown()) {
			moveDown();
		}
		return true;
	}
	
	/**
	 * This insets the piece at the top center of the game board only if 
	 * all the tiles it will occupy are empty
	 * @param center is a coordinate representing the top center of the game board
	 * @return true if the piece was successfully inserted, false if the piece
	 * 			could not be inserted. 
	 */
	public boolean insertAt(Coordinate center) {
		
		for(Coordinate cor : layout[orientation]) {
			// check if cells to be inserted are empty
			if(!game.getBoardCell(center.row + cor.row, center.col + cor.col).getName().equals("."))
				return false;
			
			locations.add(center.translate(cor.row, cor.col));			
		}
		
		for(Coordinate cor : locations) {
			game.setBoardCell(cor.row, cor.col, cell);
		}
		
		return true;
	}
	
	/**
	 * This returns the location of the piece's cell that corresponds 
	 * to the origin cell in your layout
	 * @return a Coordinate of the origin cell
	 */
	public final Coordinate getOrigin() {
		return locations.get(0);
	}
	
	/**
	 * This sets the location of the origin cell to the coordinate co and sets the
	 * remaining cells to be located around co in the appropriate layout.
	 * This checks to see if the tiles it will occupy are already occupied or not 
	 * before updating the locations. Used when moving and rotating pieces around.
	 * @param coordinate of where the new origin cell should be
	 * @return true if the coordinates were able to be set, or false if any of
	 * the coordinates could not be set
	 */
	public final boolean setOrigin(Coordinate co) {
		
		// Check if new layout is out of bound
		for (Coordinate cor : layout[orientation]) {
			int newRow = co.row + cor.row;
			int newCol = co.col + cor.col;
			if (newRow < 0 || newRow >= game.getMaxRows() || newCol < 0 || newCol >= game.getMaxCols()) 
				return false;
		}
		
		// Set original cells to white cells
		for (Coordinate cor : locations) {
			game.setBoardCell(cor.row, cor.col, Cell.EMPTY);
		}
		
		// Check if new layout is occupied by other pieces
		for (Coordinate cor : layout[orientation]) {
			if (this.game.getBoardCell(co.row + cor.row, co.col + cor.col).getName() != ".") {
				// If occupied, set white cells back to original piece
				for (Coordinate c : locations) {
					game.setBoardCell(c.row, c.col, cell);
				}
				return false;
			}
		}
		
		// Set new origin and layout
		for (int i = 0; i < layout[orientation].size(); i++) {
			locations.set(i, co.translate(layout[orientation].get(i).row, layout[orientation].get(i).col));
		}
		
		// Fill cells with the appropriate piece
		for (Coordinate cor : locations) {
			game.setBoardCell(cor.row, cor.col, cell);
		}
		return true;

	}	
}
