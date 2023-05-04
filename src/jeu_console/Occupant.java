/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public abstract class Occupant implements Questionnable{
	
	private Position pos;
	
	public Occupant(Position pos) {
		this.pos = pos;
	}
	
	public Position getPos() {
		return pos;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}

}
