/**
 * 
 */
package jeu_console;

/**
 * Describe a ladder on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Ladder extends Tool {
	
	/**
	 * 
	 * @param pos the position of the ladder
	 */
	public Ladder(Position pos) {
		super(pos);
	}
	
	/**
	 * Perform the process that chracter <i>c</i> must perform when encountering 
	 * a ladder by adding it to their inventory if they don't have one.
	 */
	@Override
	public void process(Character c) {
		if(!c.haveAlreadyLadder()) {
			String str = "";
			str += c.getNom();
			if(c instanceof Hunter) {
				str += " le chasseur ";
			}else if(c instanceof Wise) {
				str += " le mage ";
			}else if(c instanceof Cheater) {
				str += " le tricheur ";
			}
			str += "("+c+") a recupéré une échelle";
			this.setHistoProcess(str);
			c.takeLadder();
		}
		
	}

	/**
	 * @return the String representation of the ladder
	 */
	@Override
	public String toString() {
		return "l";
	}
	
}
