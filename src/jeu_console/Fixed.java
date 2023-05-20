/**
 * 
 */
package jeu_console;

/**
 * Describe a fixed occupant on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public abstract class Fixed extends Occupant {

	/**
	 * 
	 * @param pos the position of the fixed
	 */
	public Fixed(Position pos) {
		super(pos);
	}

}
