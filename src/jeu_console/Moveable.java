/**
 * 
 */
package jeu_console;

/**
 * Describe the interface of moveable
 * @author Vital FOCHEUX
 *
 */
public interface Moveable {
	
	/**
	 * 
	 * @param dir the direction
	 * @return the position for the next position with the direction
	 */
	public Position getNextPosition(int dir);
	/**
	 * 
	 * @param pos the position to walk towards
	 */
	public void walk(Position pos);

}
