/**
 * 
 */
package jeu_console;

/**
 * Describe a tool on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public abstract class Tool extends Fixed {

	/**
	 * 
	 * @param pos the position of the tool
	 */
	public Tool(Position pos) {
		super(pos);
	}
}
