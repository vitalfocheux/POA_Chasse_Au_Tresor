/**
 * 
 */
package jeu_console;

/**
 * Describe a pickaxe on a map by means of a position
 * @author Vital FOCHEUX
 *
 */
public class Pickaxe extends Tool {

	private String str = "";
	
	/**
	 * 
	 * @param pos the position of the pickaxe
	 */
	public Pickaxe(Position pos) {
		super(pos);
	}
	
	public String whoTookPickaxe() {
		return str;
	}
	
	private void tookPickaxe(String str) {
		this.str = str;
	}

	/**
	 * Perform the process that chracter <i>c</i> must perform when encountering 
	 * a pickaxe by adding it to their inventory if they don't have one.
	 */
	@Override
	public void process(Character c) {
		if(!c.haveAlreadyPickaxe()) {
			String str = c.getNom();
			if(c instanceof Hunter) {
				str += " le chasseur ";
			}else if(c instanceof Wise) {
				str += " le mage ";
			}else if(c instanceof Cheater) {
				str += " le tricheur ";
			}
			str += "("+c+") a recupéré une pioche";
			tookPickaxe(str);
			System.out.println(str);
			c.takePickaxe();
		}
	}
	
	/**
	 * @return the String representation of the pickaxe
	 */
	@Override
	public String toString() {
		return "p";
	}

}
