/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public interface Moveable {
	
	public Position getNextPosition(int dir);
	public void newDirection(int dir);
	public void walk(Position pos);
	public int distanceBetween(Position from, Position to);

}
