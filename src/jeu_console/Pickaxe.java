/**
 * 
 */
package jeu_console;

/**
 * @author Vital FOCHEUX
 *
 */
public class Pickaxe extends Tool {

	public Pickaxe(Position pos) {
		super(pos);
	}

	@Override
	public void process(Character c) {
		if(!c.haveAlreadyPickaxe()) {
			System.out.print(c.getNom());
			if(c instanceof Hunter) {
				System.out.print(" le chasseur ");
			}else if(c instanceof Wise) {
				System.out.print(" le mage ");
			}else if(c instanceof Cheater) {
				System.out.print(" le tricheur ");
			}
			System.out.println("("+c+") a recupéré une pioche");
			c.takePickaxe();
		}
	}
	
	@Override
	public String toString() {
		return "p";
	}

}
