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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(Character c) {
		if(!c.haveAlreadyPickaxe()) {
			System.out.println(c.getNom()+" le chasseur ("+c+") a recupéré une pioche");
			c.takePickaxe();
		}
	}
	
	@Override
	public String toString() {
		return "p";
	}

}
