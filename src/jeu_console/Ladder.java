/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Ladder extends Tool {

	public Ladder(Position pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(Character c) {
		if(!c.haveAlreadyLadder()) {
			c.takeLadder();
		}
		
	}

}
