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
	private String str = "";
	
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
	
	/**
	 * Sets the history process string.
	 * @param str the new history process string
	 */
	public void setHistoProcess(String str) {
		this.str = str;
	}
	
	/**
	 * Retrieves the history process string.
	 * @return the history process string
	 */
	public String getHistoProcess() {
		return str;
	}

}
