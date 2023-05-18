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
		System.out.println("\n\nrow : " + row + "\ncol : " + col + "\n");
		
		double angle;
		double tan = (double) col / (double) row;
		System.out.println("tan : " + tan + "\n");
		
		if (row == 0) {
			if (col > 0) return 1;
			return 5;
		}
		if (col == 0) {
			if (row > 0) return 7;
			return 3;
		}
		
		angle = Math.atan(tan);
		System.out.println("angle : " + angle + "\n");
		
		if (row < 0) {
			System.out.println("test de l'intervalle : [" + -4*Math.PI/8 + " ; " + -3*Math.PI/8 + "] censé retourner 1\n");
			if (angle > -4*Math.PI/8 && -3*Math.PI/8 >= angle) {
				return 1;
			}
			System.out.println("test de l'intervalle : [" + -3*Math.PI/8 + " ; " + -Math.PI/8 + "] censé retourner 2\n");
			if (angle > -3*Math.PI/8  && -Math.PI/8 >= angle) {
				return 2;
			}
			System.out.println("test de l'intervalle : [" + -Math.PI/8 + " ; " + Math.PI/8 + "] censé retourner 3\n");
			if (angle > -Math.PI/8  && Math.PI/8 >= angle) {
				return 3;
			}
			System.out.println("test de l'intervalle : [" + Math.PI/8 + " ; " + 3*Math.PI/8 + "] censé retourner 4\n");
			if (angle > Math.PI/8  && 3*Math.PI/8 >= angle) {
				return 4;
			}
			System.out.println("test de l'intervalle : [" + 3*Math.PI/8 + " ; " + 4*Math.PI/8 + "] censé retourner 5\n");
			if (angle > 3*Math.PI/8  && 4*Math.PI/8 >= angle) {
				return 5;
			}
		}
		else {
			System.out.println("test de l'intervalle : [" + -4*Math.PI/8 + " ; " + -3*Math.PI/8 + "] censé retourner 5\n");
			if (angle > -4*Math.PI/8 && -3*Math.PI/8 >= angle) {
				return 5;
			}
			System.out.println("test de l'intervalle : [" + -3*Math.PI/8 + " ; " + -Math.PI/8 + "] censé retourner 6\n");
			if (angle > -3*Math.PI/8  && -Math.PI/8 >= angle) {
				return 6;
			}
			System.out.println("test de l'intervalle : [" + -Math.PI/8 + " ; " + Math.PI/8 + "] censé retourner 7\n");
			if (angle > -Math.PI/8  && Math.PI/8 >= angle) {
				return 7;
			}
			System.out.println("test de l'intervalle : [" + Math.PI/8 + " ; " + 3*Math.PI/8 + "] censé retourner 8\n");
			if (angle > Math.PI/8  && 3*Math.PI/8 >= angle) {
				return 8;
			}
			System.out.println("test de l'intervalle : [" + 3*Math.PI/8 + " ; " + 4*Math.PI/8 + "] censé retourner 1\n");
			if (angle > 3*Math.PI/8  && 4*Math.PI/8 >= angle) {
				return 1;
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
