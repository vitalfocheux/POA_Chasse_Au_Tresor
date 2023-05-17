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
		
		int row = treasure.getPos().getRow() - this.getPos().getRow();
		int col = treasure.getPos().getCol() - this.getPos().getCol();
		//System.out.println("\n\nrow : " + row + "\ncol : " + col + "\n");
		
		/*
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
		return -1;*/
		
		double angle;
		double tan = (double) col / (double) row;
		//System.out.println("tan : " + tan + "\n");
		
		if (row == 0) {
			if (col > 0) return 1;
			return 5;
		}
		if (col == 0) {
			if (row > 0) return 7;
			return 3;
		}
		angle = Math.atan(tan);
		//System.out.println("angle : " + angle + "\n");
		
		//System.out.println("test de l'intervalle : [" + 7*Math.PI/8 + " ; " + 9*Math.PI/8 + "] censé retourner 1\n");
		if (angle > 7*Math.PI/8 &&  9*Math.PI/8 >= angle) {
			return 1;
		}
		//System.out.println("test de l'intervalle : [" + 5*Math.PI/8 + " ; " + 7*Math.PI/8 + "] censé retourner 2\n");
		if (angle > 5*Math.PI/8 && 7*Math.PI/8 >= angle) {
			return 2;
		}
		//System.out.println("test de l'intervalle : [" + 3*Math.PI/8 + " ; " + 5*Math.PI/8 + "] censé retourner 3\n");
		if (angle > 3*Math.PI/8 && 5*Math.PI/8 >= angle) {
			return 3;
		}
		//System.out.println("test de l'intervalle : [" + Math.PI/8 + " ; " + 3*Math.PI/8 + "] censé retourner 4\n");
		if (angle > Math.PI/8 && 3*Math.PI/8 >= angle) {
			if (col > 0) return 8;
			return 4;
		}
		//System.out.println("test de l'intervalle : [" + -Math.PI/8 + " ; " + Math.PI/8 + "] censé retourner 5\n");
		if (angle > -Math.PI/8 && Math.PI/8 >= angle) {
			return 5;
		}
		//System.out.println("test de l'intervalle : [" + -3*Math.PI/8 + " ; " + -Math.PI/8 + "] censé retourner 6\n");
		if (angle > -3*Math.PI/8 && -Math.PI/8 >= angle) {
			if (col > 0) return 2;
			return 6;
		}
		//System.out.println("test de l'intervalle : [" + -7*Math.PI/8 + " ; " + -5*Math.PI/8 + "] censé retourner 7\n");
		if (angle > -7*Math.PI/8 && -5*Math.PI/8 >= angle) {
			return 7;
		}
		//System.out.println("test de l'intervalle : [" + -9*Math.PI/8 + " ; " + -7*Math.PI/8 + "] censé retourner 8\n");
		if (angle > -9*Math.PI/8 && -7*Math.PI/8 >= angle) {
			return 8;
		}
		
		
		/*
		for (int i = 1; i < 9; ++i) {
			System.out.println("Test de l'intervale : [" + (2*i - 1) * (Math.PI/8) + " ; "+ (2*i + 1) * (Math.PI/8) + "\n");
			if (angle > (2*i - 1) * (Math.PI/8) && (2*i + 1) * (Math.PI/8) >= angle) {
				return i;
			}
		}*/
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
