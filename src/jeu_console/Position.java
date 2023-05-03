/**
 * 
 */
package jeu_console;

/**
 * Describe a position on a map by means of a row number and a 
 * column number, both in interval [;]
 * @author Vital FOCHEUX
 *
 */
public class Position implements Comparable<Position>{
	
	private int row, col;
	
	/**
	 * Builds a position with <i>row</i> as the row number and
	 * <i>col</i> as the column number.
	 * @param row the row number of the position
	 * @param col the column number of the position
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return the row number of the position
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column number of the position
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void updatePosition(Position pos) {
		row = pos.getRow();
		col = pos.getCol();
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 */
	public void updatePosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	

	/** Tests if position <i>this</i> equals position <i>o</i>.
	 * @return true if <i>o</i> is a position and <i>this</i> and <i>o</i> have same row
	 * number and column number, false otherwise.
	 * @param o an object (supposedly a Position) to be compared with the current one
	 */
	public boolean equals(Object that) {
		if(! (that instanceof Position)) {
			return false;
		}
		return (this.getCol() == ((Position)that).getCol() && this.getRow() == ((Position)that).getRow());
	}

	/**
	 * Builds a String representation of a position as the row number
	 * enclosed in square brackets, followed be the column number
	 * enclosed in square brackets. 
	 * @return the String representation of the position.
	 */
	@Override
	public String toString() {
		return "["+ row +", "+ col + "]";
	}

	@Override
	public int compareTo(Position that) {
		// TODO Auto-generated method stub
		int r = this.getRow() - that.getRow();
		if(r == 0) {
			r = this.getCol() - that.getCol();
		}
		return r;
	}
	
	

}
