/**
 *  DO NOT MODIFY THIS CLASS
 */
package model;

public abstract class Game {
	protected Cell[][] board;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	public Game(int maxRows, int maxCols) {
		board = new Cell[maxRows][maxCols];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = Cell.EMPTY;
			}
		}
	}

	public int getMaxRows() {
		return board.length;
	}

	public int getMaxCols() {
		return board[0].length;
	}

	public void setBoardCell(int rowIndex, int colIndex, Cell boardCell) {
		board[rowIndex][colIndex] = boardCell;
	}

	public Cell getBoardCell(int rowIndex, int colIndex) {
		return board[rowIndex][colIndex];
	}

	/**
	 * Initializes row with the specified color.
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, Cell cell) {
		for (int col = 0; col < getMaxCols(); col++) {
			setBoardCell(rowIndex, col, cell);
		}
	}
	
	/**
	 * Initializes column with the specified color.
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, Cell cell) {
		for (int row = 0; row < getMaxRows(); row++) {
			setBoardCell(row, colIndex, cell);
		}
	}
	
	/**
	 * Initializes the board with the specified color.
	 * @param cell
	 */
	public void setBoardWithColor(Cell cell) {
		for (int row = 0; row < getMaxRows(); row++) {
			setRowWithColor(row, cell);
		}
	}	
	
	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep(Integer piece);

	/**
	 * Adjust the board state according to the current board state and the
	 * selected cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(Action action);
	
	
}