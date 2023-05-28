/**
 * 
 */
package jeu_console;

/**
 * Describe a treasure on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Treasure extends Fixed {

	/**
	 * 
	 * @param pos the position of the treasure
	 */
	public Treasure(Position pos) {
		super(pos);
	}

	/**
	 * @return the String representation of the treasure
	 */
	@Override
	public String toString() {
		return "$";
	}

	/**
	 * Perform the process that character <i>c</i> must perform 
	 * when encountering the treasure
	 */
	@Override
	public void process(Character c) {
		if(c instanceof Hunter) {
			((Hunter) c).gotTreasure();
			this.setHistoProcess(c.getNom()+" le chasseur ("+c+") a trouvé le trésor");
		}
	}

	
	
}
