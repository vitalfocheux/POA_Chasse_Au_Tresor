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
			c.takePickaxe();
		}
	}

}
