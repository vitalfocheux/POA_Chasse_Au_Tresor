/**
 * 
 */
package jeu_console;

/**
 * Describe a occupant on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public abstract class Occupant implements Questionnable{
	
	private Position pos;
	
	/**
	 * 
	 * @param pos the position of the occupant
	 */
	public Occupant(Position pos) {
		this.pos = pos;
	}
	
	/**
	 * 
	 * @return the position of the occupant
	 */
	public Position getPos() {
		return pos;
	}
	
	/**
	 * 
	 * @param pos the position of the occupant to set
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

}
