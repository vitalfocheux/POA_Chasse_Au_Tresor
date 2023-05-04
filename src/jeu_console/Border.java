/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Border extends Fixed{

	public Border(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "#";
	}

	@Override
	public void process(Character c) {
		Position pos = c.getNextPosition(c.getDir());
		if(pos.getCol() == 0) {
			if(pos.getRow() == 0 || c.getDir() == 6) {
				c.setDir(8);
			}else if(pos.getRow() == 9 || c.getDir() == 4) {
				c.setDir(2);
			}else if(c.getDir() == 5){
				c.setDir(1);
			}
		}else if(pos.getCol() == 9) {
			if(pos.getRow() == 0 || c.getDir() == 8) {
				c.setDir(6);
			}else if(pos.getRow() == 9 || c.getDir() == 2) {
				c.setDir(6);
			}else if(c.getDir() == 1){
				c.setDir(5);
			}
		}else if(pos.getRow() == 0) {
			if(c.getDir() == 2) {
				c.setDir(8);
			}else if(c.getDir() == 4) {
				c.setDir(6);
			}else if(c.getDir() == 3){
				c.setDir(7);
			}
		}else if(pos.getRow() == 9) {
			if(c.getDir() == 8) {
				c.setDir(2);
			}else if(c.getDir() == 6) {
				c.setDir(4);
			}else if (c.getDir() == 7){
				c.setDir(3);
			}
		}
	}
}
