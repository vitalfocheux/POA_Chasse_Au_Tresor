/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Ladder extends Tool {

	public Ladder(Position pos) {
		super(pos);
	}

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

	@Override
	public String toString() {
		return "l";
	}
	
}
