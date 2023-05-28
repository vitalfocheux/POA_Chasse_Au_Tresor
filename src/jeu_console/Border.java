/**
 * 
 */
package jeu_console;

/**
 * Describe a border on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Border extends Fixed{
	
	private int X = 16;
	private int Y = 31;

	/**
	 * Build a border with the position
	 * @param pos the position of the border 
	 */
	public Border(Position pos) {
		super(pos);
	}

	/**
	 * @return the String of the representation of the border
	 */
	@Override
	public String toString() {
		return "#";
	}

	/**
	 * Perform the process that character <i>c</i> must perform when encountering
	 * a border by changing its direction.
	 */
	@Override
	public void process(Character c) {
		String str = c.getNom();
		if(c instanceof Hunter) {
			str += " le chasseur ";
		}else if(c instanceof Wise) {
			str += " le mage ";
		}else if(c instanceof Cheater) {
			str += " le tricheur ";
		}
		str += " a rebondi contre le bord pour obtenir la nouvelle direction de ";
		Position pos = c.getNextPosition(c.getDir());
		if(pos.getCol() == 0) {
			if(pos.getRow() == 0) {
				str += "8";
				c.setDir(8);
			}else if(pos.getRow() == X-1) {
				str += "2";
				c.setDir(2);
			}else if(c.getDir() == 6) {
				str += "8";
				c.setDir(8);
			}else if(c.getDir() == 4) {
				str += "2";
				c.setDir(2);
			}else if(c.getDir() == 5){
				str += "1";
				c.setDir(1);
			}
		}else if(pos.getCol() == Y-1) {
			if(pos.getRow() == 0) {
				str += "6";
				c.setDir(6);
			}else if(pos.getRow() == X-1) {
				str += "4";
				c.setDir(4);
			}else if(c.getDir() == 8) {
				str += "6";
				c.setDir(6);
			}else if(c.getDir() == 2) {
				str += "4";
				c.setDir(4);
			}else if(c.getDir() == 1){
				str += "5";
				c.setDir(5);
			}
		}else if(pos.getRow() == 0) {
			if(c.getDir() == 2) {
				str += "8";
				c.setDir(8);
			}else if(c.getDir() == 4) {
				str += "6";
				c.setDir(6);
			}else if(c.getDir() == 3){
				str += "7";
				c.setDir(7);
			}
		}else if(pos.getRow() == X-1) {
			if(c.getDir() == 8) {
				str += "2";
				c.setDir(2);
			}else if(c.getDir() == 6) {
				str += "4";
				c.setDir(4);
			}else if (c.getDir() == 7){
				str += "3";
				c.setDir(3);
			}
		}
		this.setHistoProcess(str);
	}
}
