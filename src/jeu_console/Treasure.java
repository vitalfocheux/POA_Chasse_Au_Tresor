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
	}

	@Override
	public String toString() {
		return "$";
	}

	@Override
	public void process(Character c) {
		if(c instanceof Hunter) {
			((Hunter) c).gotTreasure();
		}
	}

	
	
}
