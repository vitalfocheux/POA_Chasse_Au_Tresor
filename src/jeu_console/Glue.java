/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Glue extends Fixed {

	public Glue(Position pos) {
		super(pos);
	}

	@Override
	public String toString() {
		return "~";
	}

	@Override
	public void process(Character c) {
		c.upRoundWait();		
	}

	
	
}
