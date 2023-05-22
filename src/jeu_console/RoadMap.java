/**
 * 
 */
package jeu_console;

/**
 * Describe a roadmap on a map by means of a position and a treasure
 * @author Vital FOCHEUX et Elian BADSTÜBER
 *
 */
public class RoadMap extends Fixed {
	
	private Treasure treasure;

	/**
	 * 
	 * @param pos the position of the roadmap
	 * @param treasure the treasure of the map
	 */
	public RoadMap(Position pos, Treasure treasure) {
		super(pos);
		this.treasure = treasure;
	}

	/**
	 * @author elian BADSTÜBER
	 * 
	 * @param angle the angle calculated from tangent
	 * @param low the lower limit of the tested interval
	 * @param upp the upper limit of the tested interval
	 * @return
	 */
	private boolean isBetween(double angle, double low, double upp) {
		return (angle > low && upp >= angle);
	}
	
	/**
	 * @author elian BADSTÜBER
	 * 
	 * @return the direction to the treasure, using tangent
	 */
	private int getDirToTreasure() {
		
		int row = treasure.getPos().getRow() - this.getPos().getRow();
		int col = treasure.getPos().getCol() - this.getPos().getCol();
		
		double angle;
		double tan = (double) col / (double) row;
		
		if (row == 0) {
			if (col > 0) return 1;
			return 5;
		}
		if (col == 0) {
			if (row > 0) return 7;
			return 3;
		}
		
		angle = Math.atan(tan);
		
		if (row < 0) {
			if (isBetween(angle, -4*Math.PI/8, -3*Math.PI/8)) return 1;
			if (isBetween(angle, -3*Math.PI/8, -Math.PI/8)) return 2;
			if (isBetween(angle, -Math.PI/8, Math.PI/8)) return 3;
			if (isBetween(angle, Math.PI/8, 3*Math.PI/8)) return 4;
			if (isBetween(angle, 3*Math.PI/8, 4*Math.PI/8)) return 5;
		}
		else {
			if (isBetween(angle, -4*Math.PI/8, -3*Math.PI/8)) return 5;
			if (isBetween(angle, -3*Math.PI/8, -Math.PI/8)) return 6;
			if (isBetween(angle, -Math.PI/8, Math.PI/8)) return 7;
			if (isBetween(angle, Math.PI/8, 3*Math.PI/8)) return 8;
			if (isBetween(angle, 3*Math.PI/8, 4*Math.PI/8)) return 1;
		}
		return -1;
	}
	
	/**
	 * Perform the process that the character <i>c</i> must perform when 
	 * encountering the roadmap by changing its direction.
	 */
	@Override
	public void process(Character c) {
		if (c instanceof Hunter) {
			c.setDir(this.getDirToTreasure());
		}
		
	}
	
	/**
	 * @return the String representation of the roadmap
	 */
	@Override
	public String toString() {
		return "x";
	}

}
