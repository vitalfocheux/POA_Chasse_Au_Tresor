/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class RoadMap extends Fixed {
	
	private Position pos;

	public RoadMap(Position pos) {
		super(pos);
		this.pos = pos;
		// TODO Auto-generated constructor stub
	}

	public int getDirToTreasure(Position treasure) {
		int x = treasure.getCol() - this.pos.getCol();
		int y = treasure.getRow() - this.pos.getRow();
		
		if (x == 0) {
			if (y > 0) {
				return 7;
			}
			return 3;
		}
		else if (y == 0) {
			if (x > 0) {
				return 1;
			}
			return 5;
		}
		
		double arctan = Math.atan2((double) x, (double) y);
		
		for (int i = 1; i < 9; ++i) {
			if (arctan > (2*i - 1) * (Math.PI/8) && (2*i + 1) * (Math.PI/8) > arctan) {
				return 9 - i;
			}
		}
		return -1;
	}
	
	@Override
	public void process(Character c) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "x";
	}

}
