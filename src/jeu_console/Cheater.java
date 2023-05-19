package jeu_console;

public class Cheater extends Character{
	
	private Treasure treasure;

	public Cheater(Position pos, String nom, char c, Treasure treasure) {
		super(pos, nom, c);
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
	 * @author Vital FOCHEUX
	 * 
	 * @return the opposit direction to the treasure, using tangent
	 */
	public int getDirToTreasure() {
		
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
			if (isBetween(angle, -4*Math.PI/8, -3*Math.PI/8)) return 4;
			if (isBetween(angle, -3*Math.PI/8, -Math.PI/8)) return 5;
			if (isBetween(angle, -Math.PI/8, Math.PI/8)) return 6;
			if (isBetween(angle, Math.PI/8, 3*Math.PI/8)) return 7;
			if (isBetween(angle, 3*Math.PI/8, 4*Math.PI/8)) return 8;
		}
		else {
			if (isBetween(angle, -4*Math.PI/8, -3*Math.PI/8)) return 2;
			if (isBetween(angle, -3*Math.PI/8, -Math.PI/8)) return 3;
			if (isBetween(angle, -Math.PI/8, Math.PI/8)) return 4;
			if (isBetween(angle, Math.PI/8, 3*Math.PI/8)) return 5;
			if (isBetween(angle, 3*Math.PI/8, 4*Math.PI/8)) return 6;
		}
		return -1;
	}

	@Override
	public void process(Character c) {
		if(c instanceof Hunter) {
			c.setDir(this.getDirToTreasure());
		}
	}
}
