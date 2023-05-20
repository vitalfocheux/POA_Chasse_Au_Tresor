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
			System.out.print(c.getNom());
			if(c instanceof Hunter) {
				System.out.print(" le chasseur ");
			}else if(c instanceof Wise) {
				System.out.print(" le mage ");
			}else if(c instanceof Cheater) {
				System.out.print(" le tricheur ");
			}
			System.out.println("("+c+") a recupéré une échelle");
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
