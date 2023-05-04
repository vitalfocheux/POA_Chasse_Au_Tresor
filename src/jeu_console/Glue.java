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
		// TODO Auto-generated constructor stub
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
