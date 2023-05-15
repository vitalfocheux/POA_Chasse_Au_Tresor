/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class RoadMap extends Fixed {
	
	private Treasure treasure;

	public RoadMap(Position pos, Treasure treasure) {
		super(pos);
		this.treasure = treasure;
		// TODO Auto-generated constructor stub
	}

	public int getDirToTreasure() {
		int x = treasure.getPos().getCol() - this.getPos().getCol();
		int y = treasure.getPos().getRow() - this.getPos().getRow();
		
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
		if (c instanceof Hunter) {
			c.setDir(this.getDirToTreasure());
		}
		
	}
	
	@Override
	public String toString() {
		return "x";
	}

}
