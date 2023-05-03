/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Position implements Comparable<Position>{
	
	private int row, col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the col
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
	
	/*public Position getNextPosition(int dir) {
		switch(dir) {
		case 1:
			return new Position(this.getRow(), this.getCol()+1);
		case 2:
			return new Position(this.getRow()-1, this.getCol()+1);
		case 3:
			return new Position(this.getRow()-1, this.getCol());
		case 4:
			return new Position(this.getRow()-1, this.getCol()-1);
		case 5:
			return new Position(this.getRow(), this.getCol()-1);
		case 6:
			return new Position(this.getRow()+1, this.getCol()-1);
		case 7:
			return new Position(this.getRow()+1, this.getCol());
		case 8:
			return new Position(this.getRow()+1, this.getCol()+1);
		}
		return null;
	}*/

	/**
	 * 
	 * @param that
	 * @return
	 */
	public boolean equals(Position that) {
		return (this.getCol() == that.getCol() && this.getRow() == that.getRow());
	}

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
