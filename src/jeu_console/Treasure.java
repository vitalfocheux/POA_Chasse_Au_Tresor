/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Treasure extends Fixed {

	public Treasure(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "$";
	}

	@Override
	public void process(Character c) {
		// TODO Auto-generated method stub
		if(c instanceof Hunter) {
			((Hunter) c).gotTreasure();
		}
	}

	
	
}
